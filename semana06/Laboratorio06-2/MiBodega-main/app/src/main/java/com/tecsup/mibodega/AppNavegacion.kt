package com.tecsup.mibodega

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tecsup.mibodega.ui.theme.VerdeBodega

/**
 * "Director" de la app cliente:
 * - Tiene el NavHost con todas las pantallas.
 * Ninguna pantalla navega sola: todas reciben lambdas desde aquí.
 */
@Composable
fun AppNavegacion() {
    // TODO 1: Crear el NavController
    val navController = rememberNavController()

    // TODO 3: Crear el NavHost con startDestination y las rutas
    NavHost(
        navController = navController,
        startDestination = Rutas.LOGIN
    ) {
        composable(Rutas.LOGIN) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Login")
            }
        }

        composable(Rutas.CREAR_CUENTA) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Crear Cuenta")
            }
        }

        composable(Rutas.INICIO) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Inicio")
            }
        }

        composable(
            route = Rutas.DETALLE,
            arguments = listOf(
                navArgument("productoId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val productoId = backStackEntry.arguments?.getInt("productoId") ?: 0
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Detalle: $productoId")
            }
        }

        composable(Rutas.CARRITO) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Carrito")
            }
        }

        composable(Rutas.DATOS_ENTREGA) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Datos de Entrega")
            }
        }

        composable(Rutas.CONFIRMACION) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Confirmación")
            }
        }
    }
}

/**
 * Barra inferior que usan Inicio y Carrito.
 * Cada pantalla le dice cuál es ella con "seleccionado".
 */
@Composable
fun BarraInferior(
    seleccionado: String,
    onInicio: () -> Unit,
    onCarrito: () -> Unit,
    onSalir: () -> Unit
) {
    val colores = NavigationBarItemDefaults.colors(
        selectedIconColor = VerdeBodega,
        selectedTextColor = VerdeBodega
    )

    NavigationBar {
        NavigationBarItem(
            selected = seleccionado == Rutas.INICIO,
            onClick = onInicio,
            icon = { Icon(Icons.Default.Home, contentDescription = "Inicio") },
            label = { Text("Inicio") },
            colors = colores
        )
        NavigationBarItem(
            selected = seleccionado == Rutas.CARRITO,
            onClick = onCarrito,
            icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Carrito") },
            label = { Text("Carrito") },
            colors = colores
        )
        NavigationBarItem(
            selected = false,
            onClick = onSalir,
            icon = { Icon(Icons.Default.ExitToApp, contentDescription = "Salir") },
            label = { Text("Salir") },
            colors = colores
        )
    }
}
