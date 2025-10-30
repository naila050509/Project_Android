package com.example.project_kelompok_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.project_kelompok_3.ui.theme.ProjectKelompok3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjectKelompok3Theme {
                InstagramBottomNavigation()
            }
        }
    }
}