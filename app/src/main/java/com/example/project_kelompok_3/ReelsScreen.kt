package com.example.project_kelompok_3

import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.example.project_kelompok_3.ui.theme.ProjectKelompok3Theme

data class ReelVideo(
    val title: String,
    val videoUrl: String
)
@Composable
fun ReelsScreen() {
    val reels = listOf(
        ReelVideo("Pantai Bali", "https://www.w3schools.com/html/mov_bbb.mp4"),
        ReelVideo("Ngopi Senja", "https://samplelib.com/lib/preview/mp4/sample-5s.mp4"),
        ReelVideo("Gunung Rinjani", "https://samplelib.com/lib/preview/mp4/sample-10s.mp4")
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        items(reels) { reel ->
            ReelItem(reel)
        }
    }
}

@Composable
fun ReelItem(reel: ReelVideo) {
    val context = LocalContext.current

    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            val mediaItem = MediaItem.fromUri(Uri.parse(reel.videoUrl))
            setMediaItem(mediaItem)
            prepare()
            playWhenReady = true
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            exoPlayer.release()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(600.dp),
        contentAlignment = Alignment.Center
    ) {
        AndroidView(
            factory = { ctx ->
                PlayerView(ctx).apply {
                    player = exoPlayer
                    useController = false
                }
            },
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewReelsScreen() {
    ProjectKelompok3Theme {
        ReelsScreen()
    }
}
