package com.example.project_kelompok_3


import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.VideoLibrary
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class BottomNavItem(
    val label: String,
    val icon: @Composable () -> Unit
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar() {

    val billabong = FontFamily(Font(R.font.billabong, FontWeight.Bold))

    TopAppBar(
        title = {
            Text(
                text = "Instagram",
                fontWeight = FontWeight.Bold,
                fontFamily = billabong,
                fontSize = 30.sp
            )
        },
        actions = {
            Row {
                IconButton(onClick = { /* aksi Likes */ }) {
                    Icon(
                        Icons.Outlined.FavoriteBorder,
                        contentDescription = "Likes"
                    )
                }
                Spacer(modifier = Modifier.width(2.dp)) // jarak antar icon
                IconButton(onClick = { /* aksi Send */ }) {
                    Icon(
                        Icons.AutoMirrored.Filled.Send,
                        contentDescription = "Send"
                    )
                }
            }
        }
    )
}

// ----- Top Bar Untuk Profile Instagram -----
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InstagramTopBar(
    selectedAccount: String,
    onAccountSelected: (String) -> Unit,
    accounts: List<String>
) {
    var expanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = LocalIndication.current
                ) {
                    expanded = true
                }
            ) {
                Text(
                    text = selectedAccount,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Icon(
                    imageVector = Icons.Outlined.ArrowDropDown,
                    contentDescription = "Dropdown",
                    modifier = Modifier.size(18.dp)
                )
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                accounts.forEach { account ->
                    DropdownMenuItem(
                        text = { Text(account) },
                        onClick = {
                            onAccountSelected(account) // panggil callback ke parent
                            expanded = false
                        }
                    )
                }
            }
        },
        actions = {
            IconButton(onClick = {}) {
//                Icon(Icons.Outlined.FavoriteBorder, contentDescription = "Likes")
            }
            IconButton(onClick = { /* buka menu */ }) {
                Icon(Icons.Outlined.Menu, contentDescription = "Menu")
            }
        }
    )
}


@Composable
fun InstagramBottomNavigation(modifier: Modifier = Modifier) {
    var selectedTab by remember { mutableIntStateOf(0) }

    // 🔹 State akun aktif disimpan di sini (global di halaman utama)
    var selectedAccount by remember { mutableStateOf("SeaShanty") }

    // 🔹 Daftar akun (nanti bisa dari database)
    val accounts = listOf("SeaShanty", "BunnyHop", "OceanVibes")

    val bottomNavItems = listOf(
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
        modifier = modifier,
        topBar = {
            when (selectedTab) {
                0 -> HomeTopBar() // 🟢 tampilkan top bar untuk halaman Home
                3 -> InstagramTopBar(
                    selectedAccount = selectedAccount,
                    onAccountSelected = { selectedAccount = it },
                    accounts = accounts
                ) // 🟣 tampilkan top bar untuk halaman Profile
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
                0 -> InstagramApp()
                1 -> SearchScreen()
                2 -> ReelsScreen()
                3 -> ProfileScreen(selectedAccount = selectedAccount)
            }
        }
    }
}
