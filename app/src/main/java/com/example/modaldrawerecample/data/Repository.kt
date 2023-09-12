package com.example.modaldrawerecample.data

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import com.example.modaldrawerecample.models.MenuItemModel

object Repository {
    private var items = mutableListOf<MenuItemModel>()

    fun getMenuItems() : MutableList<MenuItemModel>
    {
        return items
    }

    init {
        items.add(
            MenuItemModel(
                id = "1",
                title = "Home",
                iconVector = Icons.Default.Home,
                contentDescription = "home", onclick = {
                    Log.d("test", "home clicked")
                })
        )
        items.add(
            MenuItemModel(
                id = "2",
                title = "Settings",
                iconVector = Icons.Default.Settings,
                contentDescription = "home", onclick = {
                    Log.d("test", "settings clicked")
                })
        )
        items.add(
            MenuItemModel(
                id = "3",
                title = "Vactions",
                iconVector = Icons.Default.AccountBox,
                contentDescription = "vacation", onclick = {

                    Log.d("test", "vacation clicked clicked")
                    /* val intent = Intent(context, VacationActivity::class.java)
                     context.startActivity(intent)*/


                })
        )
    }

}