package com.example.foodapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodapp.ui.NavItem
import com.example.foodapp.ui.navItems

@Composable
fun SideNavigationMenu(
    items: List<NavItem>,
    onItemSelected: (NavItem) -> Unit
) {
    Column(
        modifier = Modifier
            .width(80.dp)
            .padding(vertical = 50.dp)
            .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items.forEach { item ->
            NavigationItem(item = item, onItemSelected = onItemSelected)
        }
    }
}

@Composable
fun NavigationItem(item: NavItem, onItemSelected: (NavItem) -> Unit) {
    val backgroundColor = if (item.isSelected) Color(0xFFEEF5FF) else Color.Transparent
    val iconTint = if (item.isSelected) Color(0xFFFFA500) else Color(0xFF1C1D22)

    Box(
        modifier = Modifier
            .height(80.dp)
            .background(backgroundColor)
            .clickable { onItemSelected(item) },
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            Icon(
                imageVector = item.icon,
                contentDescription = item.label,
                tint = iconTint,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.padding(20.dp))
            if (item.isSelected) {

                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(Color(0xFFFFA500), CircleShape)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSideNavigation() {
    val items = navItems
    var selectedItem = remember { mutableStateOf(items[0]) }

    SideNavigationMenu(
        items = items.map { it.copy(isSelected = it == selectedItem.value) }
    ) { selectedItem.value = it }
}

