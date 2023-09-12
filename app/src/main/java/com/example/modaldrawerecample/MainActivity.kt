package com.example.modaldrawerecample

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.modaldrawerecample.commonui.MenuItem
import com.example.modaldrawerecample.data.Repository
import com.example.modaldrawerecample.models.MenuItemModel
import com.example.modaldrawerecample.ui.theme.ModalDrawerEcampleTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModalDrawerEcampleTheme {
                val scope = rememberCoroutineScope()
                val drawerState = rememberDrawerState(DrawerValue.Closed)

                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        ModalDrawerSheet {
                            Surface(
                                modifier = Modifier.fillMaxSize(),
                                color = Color.Blue
                            )
                            {

                                val items = Repository.getMenuItems()
                                Drawer(title = "My Menu", menuItems = items)
                            }
                        }
                    },
            content = {
                Scaffold(
                    topBar =
                    {
                        MyAppBar(title = "menu", onMenu = {
                            if (drawerState.isOpen)
                                scope.launch {
                                    drawerState.close()
                                }
                            else
                                scope.launch {
                                    drawerState.open()
                                }


                        })
                    },
                    content =
                    {
                            padding -> MainContent(padding = padding,drawerState)

                    })
            }
            )
        }
    }
}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable fun MainContent(padding: PaddingValues, drawerState:DrawerState)
{
    val scope = rememberCoroutineScope()
    Column(modifier = Modifier.padding(padding)) {
        Text("Main screen")
        Button(onClick = {

            scope.launch {
                drawerState.open()
            }

        }) {
            Text("Click to open")
        }
        Greeting("Hello from my composable")
        Greeting(
            "Hello from my composable",
            modifier = Modifier.background(color = Color.Red)
        )

    }

}


@Composable
fun Drawer(title: String, menuItems: List<MenuItemModel>) {
    Column() {
        DrawerHeader(title = title)
        DrawerBody(menuItems = menuItems)
    }
}

@Composable
fun DrawerHeader(title: String) {
    Text(text = title, fontSize = 30.sp)
}

@Preview
@Composable
fun DrawerPreview() {
    var items = Repository.getMenuItems()

    Drawer(title = "My Menu", menuItems = items)
}

@Composable
fun DrawerBody(menuItems: List<MenuItemModel>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(menuItems) { item ->
            MenuItem(menuItem = item)
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppBar(title: String, onMenu: () -> Unit) {
    TopAppBar(
        title = {
            Text(text = title)
        }, colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onSecondary
        ),
        navigationIcon = {
            IconButton(onClick = onMenu) {
                Icon(Icons.Filled.Menu, "menu")
            }
        }

    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ModalDrawerEcampleTheme {
        Greeting("Android")
    }
}