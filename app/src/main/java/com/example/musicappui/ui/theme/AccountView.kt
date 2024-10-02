package com.example.musicappui.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.musicappui.R

@Composable
fun AccountView(){
    Column(
        Modifier
            .fillMaxSize()
            .padding(6.dp)) {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween)
        {
            Row(){
                Icon(imageVector = Icons.Default.Person, contentDescription = "Account",
                    modifier = Modifier.padding(end =8.dp))
                Column{
                    Text(text = "Ashish Goyal")
                    Text(text = "@Ashish_Playlist")
                }
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null)
                
            }
        }
        Row(Modifier.padding(top= 16.dp)){
            Icon(painter = painterResource(id = R.drawable.ic_library),
                contentDescription = "Your liked songs",
                modifier = Modifier.padding(end = 8.dp))
            Text(text = "Liked songs")
        }
            Divider()
    }
}