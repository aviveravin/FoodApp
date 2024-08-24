package com.example.foodapp.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(val label: String, val icon: ImageVector, val isSelected: Boolean)

val navItems = listOf(
    NavItem("Cook", Icons.Default.Home, true),
    NavItem("Favourites", Icons.Default.FavoriteBorder, false),
    NavItem("Manual", Icons.Default.Menu, false),
    NavItem("Device", Icons.Default.MailOutline, false),
    NavItem("Preferences", Icons.Default.Settings, false)
)
