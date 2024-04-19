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
    val badgeCount:Int? = null,
    val route:String
){
    companion object{
        val navbarItems = listOf(
            BottomNavigationItem(
                title = "News",
                selectedIcon = Icons.Default.Home,
                unselectedIcon = Icons.Outlined.Home,
                route = "home"
            ),
            BottomNavigationItem(
                title = "My Country",
                selectedIcon = Icons.Default.Place,
                unselectedIcon = Icons.Outlined.Place,
                route = "my country"
            ),
            BottomNavigationItem(
                title = "My Favorite",
                selectedIcon = Icons.Default.ThumbUp,
                unselectedIcon = Icons.Outlined.ThumbUp,
                route = "my favorite"
            ),
            BottomNavigationItem(
                title = "Saved",
                selectedIcon = Icons.Default.AddCircle,
                unselectedIcon = Icons.Outlined.AddCircle,
                route = "saved"
            ),
            BottomNavigationItem(
                title = "Profile",
                selectedIcon = Icons.Default.Face,
                unselectedIcon = Icons.Outlined.Face,
                route = "profile"
            )
        )
    }
}
