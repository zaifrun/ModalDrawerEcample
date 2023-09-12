package com.example.modaldrawerecample.commonui

import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.modaldrawerecample.models.MenuItemModel


@Composable
fun MenuItem(menuItem: MenuItemModel) {
    Row(Modifier.padding(0.dp).fillMaxWidth().background(color = Color.Gray)
        )
    {
         Text(modifier = Modifier.padding(0.dp).weight(0.8f).align(Alignment.CenterVertically), text = menuItem.title, color = Color.Black)
         IconButton(modifier = Modifier
             .weight(0.2f),
             onClick = menuItem.onclick
         ) {
             Icon(imageVector = menuItem.iconVector , contentDescription = menuItem.contentDescription,
                 tint = Color.White)
         }

    }
}