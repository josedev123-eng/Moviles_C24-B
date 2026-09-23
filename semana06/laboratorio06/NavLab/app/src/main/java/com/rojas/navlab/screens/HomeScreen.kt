package com.rojas.navlab.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.rojas.navlab.navigation.Screen
import com.rojas.navlab.ui.components.MenuOptionCard
import com.rojas.navlab.ui.theme.LavenderBg
import com.rojas.navlab.ui.theme.LogoutRed
import com.rojas.navlab.ui.theme.PurpleGradientTop

@Composable
fun HomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(PurpleGradientTop, LavenderBg)
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
                .statusBarsPadding()
                .navigationBarsPadding(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(120.dp))

            Text(
                text = "Bienvenido,\nJuan León",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
                lineHeight = 38.sp
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "¿Qué deseas gestionar hoy?",
                fontSize = 14.sp,
                color = Color.White.copy(alpha = 0.85f),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(20.dp))

            MenuOptionCard(
                icon = Icons.Filled.Groups,
                title = "Directorio de Alumnos",
                subtitle = "Ver y gestionar estudiantes",
                onClick = { navController.navigate(Screen.List.route) }
            )

            Spacer(modifier = Modifier.height(14.dp))

            MenuOptionCard(
                icon = Icons.Filled.Person,
                title = "Mi Perfil Académico",
                subtitle = "Datos personales y progreso",
                onClick = { navController.navigate(Screen.Profile.route) }
            )

            Spacer(modifier = Modifier.weight(1f))

            TextButton(
                onClick = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(0) { inclusive = true }
                    }
                },
                modifier = Modifier.padding(bottom = 24.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.Logout,
                        contentDescription = null,
                        tint = LogoutRed,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Cerrar Sesión Segura",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = LogoutRed
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}
