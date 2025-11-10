package com.example.project_kelompok_3

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun InstagramApp() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        StorySection()
        Spacer(modifier = Modifier.height(20.dp))
        PostList()
    }
}

@Composable
fun StorySection() {
    val stories = listOf(
        Pair(R.drawable.face2, "cloudysilly"),
        Pair(R.drawable.face10, "pillow._dreams"),
        Pair(R.drawable.face23, "mintymager"),
        Pair(R.drawable.face11, "bloomysilly"),
        Pair(R.drawable.face6, "vanillalucu"),
        Pair(R.drawable.face26, "honeygiggle"),
    )

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(stories) { (imageRes, username) ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = "Story",
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape)
                        .border(3.dp, Color.Red, CircleShape)
                )
                Text(
                    text = username,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
fun PostList() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            PostItem(
                profileImage = R.drawable.face10,
                username = "sillyfluffy",
                location = "Bali, Indonesia",
                images = listOf(R.drawable.senja, R.drawable.sungai, R.drawable.senja),
                caption = "Pemandangan yang sangat indah!!"
            )
        }

        item {
            PostItem(
                profileImage = R.drawable.face26,
                username = "Honeybunny",
                location = "Seoul, Korea Selatan",
                images = listOf(R.drawable.senja, R.drawable.sungai, R.drawable.senja),
                caption = "Senja yang indahh!!"
            )
        }

        item {
            PostItem(
                profileImage = R.drawable.face11,
                username = "coffeelover",
                location = "Jakarta, Indonesia",
                images = listOf(R.drawable.senja, R.drawable.sungai),
                caption = "Ngopi sambil lihat view 😍☕"
            )
        }
    }
}

@Composable
fun PostItem(
    profileImage: Int,
    username: String,
    location: String,
    images: List<Int>,
    caption: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(profileImage),
                contentDescription = "profile",
                modifier = Modifier
                    .size(45.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Black, CircleShape)
            )
            Column(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .weight(1f)
            ) {
                Text(username, fontSize = 16.sp)
                Spacer(modifier = Modifier.height(5.dp))
                Text(location, fontSize = 12.sp)
            }
            IconButton(onClick = {}) {
                Icon(Icons.Default.MoreVert, contentDescription = "More options")
            }
        }

        // Foto
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(images) { imageRes ->
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = "Post image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(355.dp)
                )
            }
        }

        // Tombol Aksi
        ActionButtons()

        // Caption
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = username,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(end = 6.dp)
            )
            Text(caption, fontSize = 16.sp)
        }
    }
}

@Composable
fun ActionButtons() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        var likeCount by remember { mutableStateOf(0) }
        var isLiked by remember { mutableStateOf(false) }

        IconButton(onClick = {
            if (isLiked) likeCount-- else likeCount++
            isLiked = !isLiked
        }) {
            Icon(
                imageVector = if (isLiked) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                contentDescription = "Like",
                tint = if (isLiked) Color.Red else Color.Black
            )
        }
        Text(text = likeCount.toString(), fontSize = 14.sp)

        Spacer(modifier = Modifier.width(12.dp))

        var sendCount by remember { mutableStateOf(0) }
        var issend by remember { mutableStateOf(false) }

        IconButton(onClick = {
            if (issend) sendCount-- else sendCount++
            issend = !issend
        }) {
            Icon(
                imageVector = if (issend) Icons.AutoMirrored.Filled.Send else Icons.AutoMirrored.Outlined.Send,
                contentDescription = "Send",
                tint = if (issend) Color(0xFF2196F3) else Color.Black
            )
        }
        Text(text = sendCount.toString(), fontSize = 14.sp)

        Spacer(modifier = Modifier.width(12.dp))

        Spacer(modifier = Modifier.weight(1f))

        var saveCount by remember { mutableIntStateOf(0) }
        var isSaved by remember { mutableStateOf(false) }

        IconButton(onClick = {
            if (isSaved) saveCount-- else saveCount++
            isSaved = !isSaved
        }) {
            Icon(
                imageVector = if (isSaved) Icons.Filled.Bookmark else Icons.Outlined.BookmarkBorder,
                contentDescription = "Save",
                tint = if (isSaved) Color(0xFF2196F3) else Color.Black
            )
        }
        Text(text = saveCount.toString(), fontSize = 14.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun HomeIG() {
    ProjectKelompok3Theme {
        InstagramApp()
    }
}