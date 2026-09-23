package com.rojas.clinica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.rojas.clinica.navigation.AppNavigation
import com.rojas.clinica.ui.theme.ClinicaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClinicaTheme {
                AppNavigation()
            }
        }
    }
}