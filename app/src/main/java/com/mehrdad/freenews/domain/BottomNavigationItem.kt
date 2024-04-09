package com.mehrdad.freenews.domain

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val title:String,
    val selectedIcon:ImageVector,
    val unselectedIcon:ImageVector,
    val hasNews:Boolean = false,
    val badgeCount:Int? = null
){
    companion object{
        val navbarItems = listOf(
            BottomNavigationItem(
                title = "News",
                selectedIcon = Icons.Default.Home,
                unselectedIcon = Icons.Outlined.Home,
            ),
            BottomNavigationItem(
                title = "Near Me",
                selectedIcon = Icons.Default.Place,
                unselectedIcon = Icons.Outlined.Place,
            ),
            BottomNavigationItem(
                title = "My Favorite",
                selectedIcon = Icons.Default.ThumbUp,
                unselectedIcon = Icons.Outlined.ThumbUp,
            ),
            BottomNavigationItem(
                title = "Saved",
                selectedIcon = Icons.Default.AddCircle,
                unselectedIcon = Icons.Outlined.AddCircle,
            ),
            BottomNavigationItem(
                title = "Profile",
                selectedIcon = Icons.Default.Face,
                unselectedIcon = Icons.Outlined.Face,
            )
        )
    }
}
