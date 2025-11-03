package com.example.project_kelompok_3


import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
    Spacer(modifier = Modifier.height(16.dp))
    Column(
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // --- Header: Profile Picture and Stats ---
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Profile Picture
            Image(
                painter = painterResource(id = R.drawable.bunnyhopscottmascot), // add image in res/drawable
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(90.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Stats
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

        // --- Username & Bio ---
        Text("SeaShanty", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Text("Ocean-inspired clothing ", fontSize = 14.sp)
        Text("www.seashanty.com", color = Color.Blue, fontSize = 13.sp)

        Spacer(modifier = Modifier.height(8.dp))

        // --- Profile Button ---
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
            ) {
                Text("Edit Profile")
            }
            OutlinedButton(
                onClick = {},
                modifier = Modifier.weight(1f)
            ) {
                Text("PIE")
            }
            OutlinedButton(
                onClick = {},
                modifier = Modifier.weight(1f)
            ) {
                Text("FEMBOY")
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        HighlightsSection()

        Spacer(modifier = Modifier.height(12.dp))

        // --- Grid of Posts ---
        val images = listOf(
            R.drawable.bunnyhopscottmascot, R.drawable.bunnyhopscottmascot, R.drawable.bunnyhopscottmascot,
            R.drawable.bunnyhopscottmascot, R.drawable.bunnyhopscottmascot, R.drawable.bunnyhopscottmascot
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(2.dp),
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            items(images) { image ->
                Image(
                    painter = painterResource(id = image),
                    contentDescription = null,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Composable
fun StatItem(number: String, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = number, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text(text = label, fontSize = 13.sp, color = Color.Gray)
    }
}

@Composable
fun HighlightsSection() {
    val highlights = listOf(
        R.drawable.bunnyhopscottmascot,
        R.drawable.bunnyhopscottmascot,
        R.drawable.bunnyhopscottmascot,
        R.drawable.bunnyhopscottmascot,
        R.drawable.bunnyhopscottmascot
    )

    androidx.compose.foundation.lazy.LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(highlights) { image ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "Highlight",
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.Gray, CircleShape),
                    contentScale = ContentScale.Crop
                )
                Text("Story", fontSize = 12.sp)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ProfilePreview(){
    ProjectKelompok3Theme {
        ProfileScreen()
    }
}
