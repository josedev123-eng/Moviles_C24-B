package com.rojas.navlab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.rojas.navlab.navigation.AppNavigation
import com.rojas.navlab.navigation.Screen
import com.rojas.navlab.screens.DetailScreen
import com.rojas.navlab.screens.HomeScreen
import com.rojas.navlab.screens.ListScreen
import com.rojas.navlab.screens.ProfileScreen
import com.rojas.navlab.ui.theme.NavLabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppNavigation()
        }
    }
}