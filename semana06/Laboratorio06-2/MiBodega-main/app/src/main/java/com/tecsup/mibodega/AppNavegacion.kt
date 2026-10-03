package com.tecsup.mibodega

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

/**
 * "Director" de la app cliente:
 * - Tiene el NavHost con todas las pantallas.
 * Ninguna pantalla navega sola: todas reciben lambdas desde aquí.
 */
@Composable
fun AppNavegacion() {
    val navController = rememberNavController()

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

        composable(Rutas.INICIO) { Text("Inicio") }
        composable(Rutas.DETALLE) { Text("Detalle") }
        composable(Rutas.CARRITO) { Text("Carrito") }
        composable(Rutas.DATOS_ENTREGA) { Text("Datos de entrega") }
        composable(Rutas.CONFIRMACION) { Text("Confirmación") }
    }
}