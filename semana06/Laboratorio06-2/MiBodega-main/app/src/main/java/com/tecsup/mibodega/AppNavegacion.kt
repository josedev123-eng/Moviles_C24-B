package com.tecsup.mibodega

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavegacion() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Rutas.LOGIN
    ) {
        composable(Rutas.LOGIN) { Text("Login") }
        composable(Rutas.CREAR_CUENTA) { Text("Crear cuenta") }
        composable(Rutas.INICIO) { Text("Inicio") }
        composable(Rutas.DETALLE) { Text("Detalle") }
        composable(Rutas.CARRITO) { Text("Carrito") }
        composable(Rutas.DATOS_ENTREGA) { Text("Datos de entrega") }
        composable(Rutas.CONFIRMACION) { Text("Confirmación") }
    }
}