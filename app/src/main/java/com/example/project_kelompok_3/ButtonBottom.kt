package com.example.project_kelompok_3


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.VideoLibrary
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class BottomNavItem(
    val label: String,
    val icon: @Composable () -> Unit
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InstagramTopBar() {
    TopAppBar(
        title = {
            Text(
                text = "???",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp
            )
        },

        actions = {
            IconButton(onClick = {}) {
//                Icon(Icons.Outlined.FavoriteBorder, contentDescription = "Likes")
            }
            IconButton(onClick = {}) {
                Icon(Icons.AutoMirrored.Outlined.Send, contentDescription = "Messages")
            }
        }
    )
}


@Composable
fun InstagramBottomNavigation(modifier: Modifier = Modifier) {
    var selectedTab by remember { mutableIntStateOf(0) }
    val bottomNavItems = listOf(
//    Membuat List untuk bisa ditampilkan di mainactivity
        BottomNavItem("Home", { Icon(Icons.Outlined.Home, contentDescription = "Home") }),
        BottomNavItem("Search", { Icon(Icons.Outlined.Search, contentDescription = "Search") }),
        BottomNavItem("Reels", { Icon(Icons.Outlined.VideoLibrary, contentDescription = "Reels") }),
        BottomNavItem("Profile", {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Profile",
                modifier = Modifier
                    .size(24.dp)
                    .clip(CircleShape)
            )
        })
    )
    Scaffold(
        modifier = modifier, // Ini cuman memanggil modifier supaya tidak ada warning
        topBar = {
            if (selectedTab == 3) {
                InstagramTopBar()
            }
        },
        bottomBar = {
            NavigationBar {
                bottomNavItems.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedTab == index,
                        onClick = { selectedTab = index },
                        icon = { item.icon() },
                        label = { Text(item.label) }
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (selectedTab) {
                3 -> ProfileScreen()
            }
        }
    }
}