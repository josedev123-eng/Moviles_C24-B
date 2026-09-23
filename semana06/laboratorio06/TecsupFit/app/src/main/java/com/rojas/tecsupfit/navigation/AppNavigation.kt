package com.rojas.tecsupfit.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.rojas.tecsupfit.screens.*

val VerdeTecsup = Color(0xFF0D634C)

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar(containerColor = Color.White) {
                val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
                val items = listOf(
                    "inicio" to "Inicio",
                    "mis_citas" to "Reservas",
                    "historial" to "Rutinas",
                    "perfil_usuario" to "Perfil"
                )
                items.forEach { (route, label) ->
                    NavigationBarItem(
                        selected = currentRoute == route,
                        onClick = { navController.navigate(route) },
                        icon = { Surface(color = if (currentRoute == route) VerdeTecsup else Color.Transparent) {} },
                        label = { Text(label, color = if (currentRoute == route) VerdeTecsup else Color.Gray) }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "inicio",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("inicio") { InicioScreen(navController) }
            composable("mis_citas") { MisClasesScreen() }
            composable("historial") { RutinasScreen() }
            composable("perfil_usuario") { PerfilUsuarioScreen() }

            composable(
                "agendar_cita/{claseId}",
                arguments = listOf(navArgument("claseId") { type = NavType.IntType })
            ) { backStack ->
                val id = backStack.arguments?.getInt("claseId") ?: 1
                AgendarClasesScreen(navController, id)
            }

            composable(
                "confirmacion/{claseId}",
                arguments = listOf(navArgument("claseId") { type = NavType.IntType })
            ) { backStack ->
                val id = backStack.arguments?.getInt("claseId") ?: 1
                ConfirmacionScreen(navController, id)
            }
        }
    }
}