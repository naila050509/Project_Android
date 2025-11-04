package com.example.project_kelompok_3

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
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

@Composable
fun ProfileScreen() {
    var selectedTab by remember { mutableStateOf("Posts") }

    Spacer(modifier = Modifier.height(16.dp))
    Column(
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxSize()
            .padding(16.dp)
    ) {
//  ------ Profile Picture User ----
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.bunnyhopscottmascot),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(90.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

//  ------ Statistika Milik User ----
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

//  ------ Nama dan bio data user  ----
        Text("SeaShanty", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Text("Ocean-inspired clothing", fontSize = 14.sp)
        Text("www.seashanty.com", color = Color.Blue, fontSize = 13.sp)

        Spacer(modifier = Modifier.height(8.dp))

//  ------ Tombol Untuk Pemilik User  ----
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedButton(
                onClick = {},
                modifier = Modifier.weight(1f)
            ) { Text("Edit Profile") }

            OutlinedButton(
                onClick = {},
                modifier = Modifier.weight(1f)
            ) { Text("PIE") }

            OutlinedButton(
                onClick = {},
                modifier = Modifier.weight(1f)
            ) { Text("FEMBOY") }
        }

        Spacer(modifier = Modifier.height(12.dp))

//  ------ Highlights  ----
        HighlightsSection()

        Spacer(modifier = Modifier.height(12.dp))

//  ------ Tombol Untuk Semua User ----
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TabButton("Posts", selectedTab) { selectedTab = "Posts" }
            TabButton("Reels", selectedTab) { selectedTab = "Reels" }
            TabButton("Tagged", selectedTab) { selectedTab = "Tagged" }
        }

        Spacer(modifier = Modifier.height(12.dp))

    //  ------ Isi Content Berdasarkan Tombol Diclick  ----
        when (selectedTab) {
            "Posts" -> PostGrid()
            "Reels" -> ReelsSection()
            "Tagged" -> TaggedSection()
        }
    }
}


//  ------ Styling Isi Untuk Statistika Milik User ----
@Composable
fun StatItem(number: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = number, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text(text = label, fontSize = 13.sp, color = Color.Gray)
    }
}

//  ------ Isi Untuk Highlights  ----
@Composable
fun HighlightsSection() {

    //  ------ File Gambar beserta Nama hightlightsnya  ----
    val highlights = listOf(
        Pair(R.drawable.bunnyhopscottmascot, "Trip"),
        Pair(R.drawable.bunnyhopscottmascot, "Pets"),
        Pair(R.drawable.bunnyhopscottmascot, "Family"),
        Pair(R.drawable.bunnyhopscottmascot, "Work"),
        Pair(R.drawable.bunnyhopscottmascot, "Friends")
    )

    //  ------ Styling Untuk Setiap Highlight ----
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(highlights) { (image, name) ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "Highlight $name",
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.Gray, CircleShape),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(name, fontSize = 12.sp)
            }
        }
    }
}


//  ------ Tombol Untuk Semua User ----
@Composable
fun TabButton(
    text: String,
    selectedTab: String,
    onClick: () -> Unit
) {
    val isSelected = text == selectedTab
    TextButton(onClick = onClick) {
        Text(
            text,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            color = if (isSelected) Color.Black else Color.Gray
        )
    }
}

@Composable
fun PostGrid() {
    val posts = List(9) { R.drawable.bunnyhopscottmascot }
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.fillMaxSize(),
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

@Composable
fun ReelsSection() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("🎬 Reels kamu akan tampil di sini", color = Color.Gray)
    }
}

@Composable
fun TaggedSection() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("🏷️ Postingan yang menandai kamu akan muncul di sini", color = Color.Gray)
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    ProjectKelompok3Theme {
        ProfileScreen()
    }
}
