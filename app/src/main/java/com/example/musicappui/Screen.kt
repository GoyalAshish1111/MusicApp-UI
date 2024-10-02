package com.example.musicappui

import androidx.annotation.DrawableRes

sealed class Screen(val title :String , val route :String) {

    sealed class BottomScreen (val bTitle :String , val bRoute :String , @DrawableRes val icon :Int)
    : Screen(bTitle , bRoute){
        object Home :BottomScreen(bTitle = "Home", bRoute = "home", R.drawable.ic_home)
        object Library :BottomScreen(bTitle = "Library", bRoute = "library", R.drawable.ic_library)
        object Browse :BottomScreen(bTitle = "Browse", bRoute = "browse", R.drawable.ic_browse)
        object Search :BottomScreen(bTitle = "Search", bRoute = "search", R.drawable.ic_search)
    }

    sealed class DrawerScreen(val dTitle :String , val dRoute :String , @DrawableRes val icon :Int)
        : Screen(dTitle , dRoute){

            object Account :DrawerScreen(
                dTitle = "Account",
                dRoute = "account",
                R.drawable.ic_account
            )
        object SettingAndPrivacy :DrawerScreen(
            dTitle = "Setting and privacy",
            dRoute = "setting_and_privacy",
            R.drawable.ic_setting
        )
        object AddAccount :DrawerScreen(
            dTitle = "Add account",
            dRoute = "add_account",
            R.drawable.baseline_person_add_alt_1_24
        )
        }

}
val screensInBottom = listOf(
    Screen.BottomScreen.Home,
    Screen.BottomScreen.Search,
    Screen.BottomScreen.Library,
    Screen.BottomScreen.Browse
)
val screensInDrawer = listOf(
    Screen.DrawerScreen.Account,
    Screen.DrawerScreen.SettingAndPrivacy,
    Screen.DrawerScreen.AddAccount
)