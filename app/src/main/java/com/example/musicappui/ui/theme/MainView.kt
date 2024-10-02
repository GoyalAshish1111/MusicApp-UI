package com.example.musicappui.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.primarySurface
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.musicappui.MainViewModel
import com.example.musicappui.R
import com.example.musicappui.Screen
import com.example.musicappui.screensInBottom
import com.example.musicappui.screensInDrawer
import com.example.musicappui.ui.theme.AccountDialog
import com.example.musicappui.ui.theme.AccountView
import com.example.musicappui.ui.theme.Browser
import com.example.musicappui.ui.theme.Home
import com.example.musicappui.ui.theme.Library
import com.example.musicappui.ui.theme.SettingAndPrivacy
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun MainView(){

    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val scope : CoroutineScope = rememberCoroutineScope()
    val viewModel : MainViewModel = viewModel()
    val currentScreen = remember{ viewModel.currentScreen.value}
    val isSheetFullScreen by remember{ mutableStateOf(false) }
    val modifier = if(isSheetFullScreen) Modifier.fillMaxSize() else Modifier.fillMaxWidth()

//    these allows us to kow which page currently we are or screen
    val controller : NavController = rememberNavController()
    val navBackStackEntry by controller.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val dialogOpen = remember{ mutableStateOf(false) }

//    todo change it to current screen title

    val title =  remember{ mutableStateOf(currentScreen.title) }

    val modalSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden,
        confirmValueChange = {it != ModalBottomSheetValue.HalfExpanded})
    val roundedCornerRadius = if (isSheetFullScreen)0.dp else 12.dp

    val bottombar: @Composable () -> Unit = {
        if (currentScreen is Screen.DrawerScreen || currentScreen == Screen.BottomScreen.Home) {
            BottomNavigation(Modifier.wrapContentSize()) {
                screensInBottom.forEach { item ->
                    val isSelected: Boolean = currentRoute == item.bRoute
                    val tint = if (isSelected) Color.White else Color.Black

                    BottomNavigationItem(
                        selected = isSelected,
                        onClick = { controller.navigate(item.bRoute)
                                  title.value = item.bTitle
                                  },
                        icon = {
                            Icon(
                                tint = tint,
                                painter = painterResource(id = item.icon),
                                contentDescription = item.bTitle
                            )
                        },
                        label = { Text(text = item.bTitle, color = tint) },
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color.Black
                    )
                }
            }
        }
    }


    ModalBottomSheetLayout(
        sheetState = modalSheetState,
        sheetShape = RoundedCornerShape(topStart = roundedCornerRadius, topEnd = roundedCornerRadius)
        ,sheetContent = {
        MoreBottomSheet(modifier = modifier)
    }) {

        Scaffold(
            bottomBar = bottombar,
            topBar = {
                TopAppBar(title = { Text(text = title.value) },
                    actions = {
                              IconButton(onClick = {
                                  scope.launch {
                                      if(modalSheetState.isVisible) modalSheetState.hide()
                                      else modalSheetState.show()
                                  }
                              }) {
                                  Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
                              }
                    },
                    navigationIcon = { IconButton(onClick = {
//                    we want to open the drawer
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }) {
                        Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Menu")
                    }}
                ) },scaffoldState = scaffoldState,
            drawerContent = {
                LazyColumn(Modifier.padding(16.dp)){
                    items(screensInDrawer){item ->
                        DrawerItem(selected = currentRoute == item.dRoute, item = item) {
                            scope.launch {
                                scaffoldState.drawerState.close()
                            }
                            if(item.dRoute == "add_account"){
//                                    open dialog
                                dialogOpen.value=true
                            }
                            else{
                                controller.navigate(item.dRoute)
                                title.value = item.dTitle
                            }
                        }
                    }
                }
            }
        )
        {
            Navigation(navController = controller, viewModel = viewModel, pd = it)
            AccountDialog(dialogOpen = dialogOpen)
        }
    }
}

@Composable
fun DrawerItem(
    selected: Boolean,
    item: Screen.DrawerScreen,
    onDrawerItemClicked: () -> Unit
) {
    val customTypography = Typography(
        defaultFontFamily = FontFamily.Default,
        h5 = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )
    )
    val background = if (selected) Color.DarkGray else Color.White

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 16.dp)
            .background(background)
            .clickable { onDrawerItemClicked() }
    ) {
        Icon(
            painter = painterResource(id = item.icon),
            contentDescription = item.dTitle,
            modifier = Modifier.padding(end = 8.dp, top = 4.dp)
        )

        Text(text = item.title, style = customTypography.h5)
    }
}


@Composable
fun MoreBottomSheet(modifier: Modifier){
    Box(
        modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(MaterialTheme.colors.primarySurface)) {
        Column(modifier=modifier.padding(16.dp), verticalArrangement = Arrangement.SpaceBetween) {
            Row(modifier=modifier.padding(16.dp)){
                Icon(painter = painterResource(id = R.drawable.ic_setting), contentDescription ="Settings", modifier = Modifier.padding(end=8.dp) )
                Text(text = "Settings", style = TextStyle(fontSize = 20.sp, color = Color.White))
            }
            Row(modifier=modifier.padding(16.dp)){
                Icon(painter = painterResource(id = R.drawable.ic_baseline_share_24), contentDescription ="Settings", modifier = Modifier.padding(end=8.dp) )
                Text(text = "Share", style = TextStyle(fontSize = 20.sp, color = Color.White))
            }
            Row(modifier=modifier.padding(16.dp)){
                Icon(painter = painterResource(id = R.drawable.ic_help_green), contentDescription ="Settings", modifier = Modifier.padding(end=8.dp) )
                Text(text = "Help", style = TextStyle(fontSize = 20.sp, color = Color.White))
            }
        }
    }
}


@Composable
fun Navigation(navController : NavController, viewModel: MainViewModel, pd : PaddingValues){

NavHost(navController = navController as NavHostController, startDestination = Screen.DrawerScreen.Account.route, Modifier.padding(pd) )
{
//    only three because for the add account we want to opnen a pop up
    composable(Screen.DrawerScreen.Account.route){
        AccountView()
    }
    composable(Screen.DrawerScreen.SettingAndPrivacy.route){
        SettingAndPrivacy()
    }
    composable(Screen.BottomScreen.Home.bRoute){
        Home()
    }
    composable(Screen.BottomScreen.Library.bRoute){
        Library()
    }
    composable(Screen.BottomScreen.Browse.bRoute){
        Browser()
    }
    composable(Screen.BottomScreen.Search.bRoute){

    }
}
}