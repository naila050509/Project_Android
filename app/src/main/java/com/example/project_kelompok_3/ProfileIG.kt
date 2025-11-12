package com.example.project_kelompok_3

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project_kelompok_3.ui.theme.ProjectKelompok3Theme


// 🔹 HEADER PROFIL
@Composable
fun ProfileHeader(imageRes: Int, name: String, bio: String, website: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(90.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(16.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            StatItem("54", "Posts")
            StatItem("834", "Followers")
            StatItem("162", "Following")
        }
    }

    Spacer(modifier = Modifier.height(8.dp))

    Text(name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
    Text(bio, fontSize = 14.sp)
    Text(website, color = Color.Blue, fontSize = 13.sp)
}


// 🔹 TOMBOL TAB (Posts, Reels, Tagged)
@Composable
fun TabButton(text: String, selectedTab: String, onClick: () -> Unit) {
    val isSelected = text == selectedTab
    TextButton(onClick = onClick) {
        Text(
            text,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            color = if (isSelected) Color.Black else Color.Gray
        )
    }
}


// 🔹 HIGHLIGHTS SECTION
@Composable
fun HighlightsSection(selectedAccount: String) {
    val highlights = remember(selectedAccount) {
        when (selectedAccount) {
            "SeaShanty" -> listOf(
                Pair(R.drawable.sungai, "Ocean"),
                Pair(R.drawable.bunnyhopscottmascot, "Beach"),
                Pair(R.drawable.face10, "Coral"),
                Pair(R.drawable.face11, "Ocean"),
                Pair(R.drawable.face23, "Beach"),
                Pair(R.drawable.face26, "Coral")
            )
            "BunnyHop" -> listOf(
                Pair(R.drawable.gambar4, "Friends"),
                Pair(R.drawable.face2, "Pets"),
                Pair(R.drawable.face6, "Coral"),
                Pair(R.drawable.ic_launcher_background, "Ocean"),
                Pair(R.drawable.ic_launcher_foreground, "Beach"),
                Pair(R.drawable.senja, "Coral")
            )
            "OceanVibes" -> listOf(
                Pair(R.drawable.git1, "Surf"),
                Pair(R.drawable.git3, "Waves"),
                Pair(R.drawable.sungai, "Sunset")
            )
            else -> emptyList()
        }
    }

    LazyRow(
    horizontalArrangement = Arrangement.spacedBy(12.dp), // 🔹 jarak antar item
    ) {
        items(highlights) { (imageRes, label) ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = label,
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.Gray, CircleShape)
                )
                Spacer(modifier = Modifier.height(4.dp)) // jarak teks dari gambar
                Text(label, fontSize = 12.sp)
            }
        }
    }
}



// 🔹 GRID POST
@Composable
fun PostGrid(selectedAccount: String) {
    val posts = when (selectedAccount) {
        "SeaShanty" -> listOf(R.drawable.face10, R.drawable.git8, R.drawable.face6, R.drawable.git2)
        "BunnyHop" -> listOf(R.drawable.git6, R.drawable.git5, R.drawable.git6, R.drawable.git7)
        "OceanVibes" -> listOf(R.drawable.sungai, R.drawable.bunnyhopscottmascot)
        else -> emptyList()
    }

    // 🔹 Tambahkan heightIn agar tidak infinite
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(max = 1200.dp) // ✅ batasi tinggi
    ) {
        items(posts) { post ->
            Image(
                painter = painterResource(id = post),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .fillMaxWidth()
            )
        }
    }
}



// 🔹 REELS SECTION
@Composable
fun ReelsSection() {
    val posts = listOf(
        R.drawable.sungai,
        R.drawable.bunnyhopscottmascot,
        R.drawable.sungai,
        R.drawable.bunnyhopscottmascot,
        R.drawable.sungai,
        R.drawable.bunnyhopscottmascot
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(max = 1200.dp), // ✅ batas tinggi juga
        verticalArrangement = Arrangement.spacedBy(2.dp),
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        items(posts) { post ->
            Image(
                painter = painterResource(id = post),
                contentDescription = null,
                modifier = Modifier
                    .aspectRatio(1f)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
        }
    }
}



// 🔹 TAGGED SECTION
@Composable
fun TaggedSection() {
    val posts = listOf(
        R.drawable.sungai,
        R.drawable.bunnyhopscottmascot,
        R.drawable.sungai
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(max = 1200.dp), // ✅ batasi tinggi
        verticalArrangement = Arrangement.spacedBy(2.dp),
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        items(posts) { post ->
            Image(
                painter = painterResource(id = post),
                contentDescription = null,
                modifier = Modifier
                    .aspectRatio(1f)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
        }
    }
}



// 🔹 PROFILE SCREEN
@Composable
fun ProfileScreen(selectedAccount: String) {
    var selectedTab by remember { mutableStateOf("Posts") }

    // Data profil tiap akun
    val profileData = when (selectedAccount) {
        "SeaShanty" -> Quadruple(R.drawable.sungai, "SeaShanty", "Ocean-inspired clothing", "www.seashanty.com")
        "BunnyHop" -> Quadruple(R.drawable.bunnyhopscottmascot, "BunnyHop", "Cute bunny apparel", "www.bunnyhop.com")
        "OceanVibes" -> Quadruple(R.drawable.sungai, "OceanVibes", "Beach life and waves", "www.oceanvibes.com")
        else -> Quadruple(R.drawable.bunnyhopscottmascot, "Unknown", "", "")
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            ProfileHeader(
                imageRes = profileData.first,
                name = profileData.second,
                bio = profileData.third,
                website = profileData.fourth
            )
        }

        item { HighlightsSection(selectedAccount) }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                TabButton("Posts", selectedTab) { selectedTab = "Posts" }
                TabButton("Reels", selectedTab) { selectedTab = "Reels" }
                TabButton("Tagged", selectedTab) { selectedTab = "Tagged" }
            }
        }

        item {
            when (selectedTab) {
                "Posts" -> PostGrid(selectedAccount)
                "Reels" -> ReelsSection()
                "Tagged" -> TaggedSection()
            }
        }
    }
}


// 🔹 ITEM STATISTIK
@Composable
fun StatItem(number: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = number, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text(text = label, fontSize = 13.sp, color = Color.Gray)
    }
}


// 🔹 DROPDOWN UNTUK GANTI AKUN
@Composable
fun ProfileIG() {
    var selectedAccount by remember { mutableStateOf("SeaShanty") }
    val accounts = listOf("SeaShanty", "BunnyHop", "OceanVibes")

    Column(modifier = Modifier.fillMaxSize()) {
        var expanded by remember { mutableStateOf(false) }

        Box(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            OutlinedButton(onClick = { expanded = true }) {
                Text(selectedAccount)
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                accounts.forEach { account ->
                    DropdownMenuItem(
                        text = { Text(account) },
                        onClick = {
                            selectedAccount = account
                            expanded = false
                        }
                    )
                }
            }
        }

        // Isi profil berubah sesuai akun
        ProfileScreen(selectedAccount = selectedAccount)
    }
}


// 🔹 PREVIEW
@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    ProjectKelompok3Theme {
        ProfileIG()
    }
}


// 🔹 Quadruple helper (karena Kotlin tidak punya bawaan)
data class Quadruple<A, B, C, D>(
    val first: A,
    val second: B,
    val third: C,
    val fourth: D
)
