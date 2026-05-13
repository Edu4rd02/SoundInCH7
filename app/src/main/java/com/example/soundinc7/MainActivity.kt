package com.example.soundinc7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.soundinc7.ui.UserSessionViewModel
import com.example.soundinc7.ui.navigation.SoundInNavGraph
import com.example.soundinc7.ui.theme.SoundInC7Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val sessionViewModel: UserSessionViewModel = viewModel()
            SoundInC7Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SoundInNavGraph(navController = navController,
                        sessionViewModel = sessionViewModel
                    )
                }
            }
        }
    }
}