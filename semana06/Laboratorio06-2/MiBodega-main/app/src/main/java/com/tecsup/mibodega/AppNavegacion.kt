package com.tecsup.mibodega

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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tecsup.mibodega.ui.theme.VerdeBodega

/**
 * "Director" de la app cliente:
 * - Tiene el NavHost con todas las pantallas.
 * Ninguna pantalla navega sola: todas reciben lambdas desde aquí.
 */
@Composable
fun AppNavegacion() {
    val navController = rememberNavController()
    val irAInicio: () -> Unit = { navController.navigate(Rutas.INICIO) { launchSingleTop = true } }
    val irAlCarrito: () -> Unit = { navController.navigate(Rutas.CARRITO) { launchSingleTop = true } }
    val salir: () -> Unit = { navController.navigate(Rutas.LOGIN) }

    NavHost(
        navController = navController,
        startDestination = Rutas.LOGIN
    ) {
        composable(Rutas.LOGIN) {
            PantallaLogin(
                onIngresar = { navController.navigate(Rutas.INICIO) },
                onCrearCuenta = { navController.navigate(Rutas.CREAR_CUENTA) }
            )
        }

        composable(Rutas.CREAR_CUENTA) {
            PantallaCrearCuenta(
                onVolver = { navController.popBackStack() },
                onCuentaCreada = { navController.navigate(Rutas.INICIO) }
            )
        }

        composable(Rutas.INICIO) {
            PantallaInicio(
                onIrCarrito = irAlCarrito,
                onSalir = salir
            )
        }

        composable(Rutas.DETALLE) { Text("Detalle") }

        composable(Rutas.CARRITO) {
            PantallaCarrito(
                onIrInicio = irAInicio,
                onSalir = salir
            )
        }

        composable(Rutas.DATOS_ENTREGA) { Text("Datos de entrega") }
        composable(Rutas.CONFIRMACION) { Text("Confirmación") }
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