package com.rojas.tecsupfit.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.EventAvailable
import androidx.compose.material.icons.outlined.FitnessCenter
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.rojas.tecsupfit.screens.*

val VerdeTecsup = Color(0xFF0D634C)

data class BottomNavItem(val route: String, val label: String, val icon: ImageVector)

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    val showBottomBar = currentRoute in listOf("inicio", "mis_citas", "historial", "perfil_usuario")

    Scaffold(
        containerColor = Color.White,
        bottomBar = {
            if (showBottomBar) {
                NavigationBar(containerColor = Color.White) {
                    val items = listOf(
                        BottomNavItem("inicio", "Inicio", Icons.Outlined.Home),
                        BottomNavItem("mis_citas", "Reservas", Icons.Outlined.EventAvailable),
                        BottomNavItem("historial", "Rutinas", Icons.Outlined.FitnessCenter),
                        BottomNavItem("perfil_usuario", "Perfil", Icons.Outlined.Person)
                    )
                    items.forEach { item ->
                        val selected = currentRoute == item.route
                        NavigationBarItem(
                            selected = selected,
                            onClick = {
                                navController.navigate(item.route) {
                                    popUpTo("inicio")
                                    launchSingleTop = true
                                }
                            },
                            icon = {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.label,
                                    tint = if (selected) Color(0xFF0D634C) else Color(0xFF8A8A8A)
                                )
                            },
                            label = {
                                Text(
                                    text = item.label,
                                    color = if (selected) Color(0xFF0D634C) else Color(0xFF8A8A8A),
                                    fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal
                                )
                            },
                            colors = NavigationBarItemDefaults.colors(
                                indicatorColor = Color(0xFFDCEFE6),
                                unselectedIconColor = Color(0xFF8A8A8A),
                                unselectedTextColor = Color(0xFF8A8A8A)
                            )
                        )
                    }
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
