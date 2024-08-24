package com.example.foodapp.ui.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodapp.ui.components.SideNavigationMenu
import com.example.foodapp.ui.navItems

@Composable
fun App() {
    val items = navItems
    var selectedItem = remember { mutableStateOf(items[0]) }

    Row(
        modifier = Modifier.fillMaxSize()
    ) {
        SideNavigationMenu(
            items = items.map { it.copy(isSelected = it == selectedItem.value) }
        ) { selectedItem.value = it }

        MainContent()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    App()
}
