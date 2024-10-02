package com.example.musicappui.ui.theme


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.musicappui.R

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun Home(){

    val categories = listOf("Punjabi", "Indie India" , "Hindi","Trending Now" , "Bollywood")
    val grouped = listOf<String>("Today's biggest hits","Jump back in", "Recently played","Recommended Stations").groupBy { it[0] }
    Row(Modifier.padding(8.dp)) {
        Button(modifier = Modifier
            .wrapContentSize()
            .padding(start = 2.dp),onClick ={} , shape =  RoundedCornerShape(50)) {
            Text(text = "A", style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 14.sp))
        }
        TextButton(modifier = Modifier.padding(start = 2.dp),onClick = { /*TODO*/ }) {
            Text(style = TextStyle( fontSize = 16.sp),text = "All")
        }
        TextButton(modifier = Modifier.padding(start = 2.dp),onClick = { /*TODO*/ }) {
            Text(style = TextStyle( fontSize = 16.sp),text = "Music")
        }
        TextButton(modifier = Modifier.padding(start = 2.dp),onClick = { /*TODO*/ }) {
            Text(style = TextStyle( fontSize = 16.sp),text = "Podcast")
        }
    }
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 76.dp, start = 16.dp, end = 16.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        Card(border = BorderStroke(2.dp, Color.DarkGray),modifier = Modifier
            .padding(start = 8.dp, end = 10.dp)
            .size(width = 20.dp, height = 80.dp)
            .weight(1f), elevation = 3.dp, onClick = {}) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(4.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(imageVector = Icons.Filled.PlayArrow, contentDescription = "")
                Text(style = TextStyle( fontSize = 16.sp), text = "Liked Songs", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth()) } }

        Card(border = BorderStroke(2.dp, Color.DarkGray),modifier = Modifier
            .padding(start = 10.dp, end = 8.dp)
            .weight(1f)
            .size(width = 20.dp, height = 80.dp), elevation = 3.dp, onClick = {}) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(4.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(imageVector = Icons.Filled.PlayArrow, contentDescription = "")
                Text(style = TextStyle( fontSize = 16.sp),text = "Bollywood", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth()) } } }

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 170.dp, start = 16.dp, end = 16.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        Card(border = BorderStroke(2.dp, Color.DarkGray),modifier = Modifier
            .padding(start = 8.dp, end = 10.dp)
            .size(width = 20.dp, height = 80.dp)
            .weight(1f), elevation = 3.dp, onClick = {}) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(4.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(imageVector = Icons.Filled.PlayArrow, contentDescription = "")
                Text(style = TextStyle( fontSize = 16.sp), text = "Pbx1", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth()) } }

        Card(border = BorderStroke(2.dp, Color.DarkGray),modifier = Modifier
            .padding(start = 10.dp, end = 8.dp)
            .weight(1f)
            .size(width = 20.dp, height = 80.dp), elevation = 3.dp, onClick = {}) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(4.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(imageVector = Icons.Filled.PlayArrow, contentDescription = "")
                Text(style = TextStyle( fontSize = 16.sp),text = "New Songs", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth()) } } }

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 264.dp, start = 16.dp, end = 16.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        Card(border = BorderStroke(2.dp, Color.DarkGray),modifier = Modifier
            .padding(start = 8.dp, end = 10.dp)
            .size(width = 20.dp, height = 80.dp)
            .weight(1f), elevation = 3.dp, onClick = {}) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(4.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(imageVector = Icons.Filled.PlayArrow, contentDescription = "")
                Text(style = TextStyle( fontSize = 16.sp), text = "Animal", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth()) } }

        Card(border = BorderStroke(2.dp, Color.DarkGray),modifier = Modifier
            .padding(start = 10.dp, end = 8.dp)
            .weight(1f)
            .size(width = 20.dp, height = 80.dp), elevation = 3.dp, onClick = {}) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(4.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(imageVector = Icons.Filled.PlayArrow, contentDescription = "")
                Text(style = TextStyle( fontSize = 16.sp),text = "Doorie", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth()) } } }

        
        LazyColumn(Modifier.padding(top=358.dp, start=16.dp)){
            grouped.forEach {
                stickyHeader {
                    Text(style = TextStyle( fontSize = 21.sp),text = it.value[0], modifier= Modifier.padding(16.dp))
                    LazyRow{
                        items(categories){
                            cat ->
                            BrowserItem(cat =cat , drawable = R.drawable.ic_music)
                        }
                    }
                }
            }
        }
}
@Composable
fun BrowserItem(cat :String , drawable:Int){
 Card(modifier = Modifier
     .padding(16.dp)
     .size(120.dp), border = BorderStroke(2.dp, Color.DarkGray)) {
     Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = cat)
         Icon(painter = painterResource(id = drawable), contentDescription = cat )
     }
 }
}



