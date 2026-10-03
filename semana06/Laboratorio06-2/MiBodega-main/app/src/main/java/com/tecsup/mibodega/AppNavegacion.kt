package com.tecsup.mibodega

import androidx.compose.runtime.Composable

/**
 * Contenedor principal de navegación de la aplicación.
 * Administra el grafo de navegación y los estados compartidos como el carrito de compras.
 */
@Composable
fun AppNavegacion() {
    // TODO 1: Instanciar el NavController con rememberNavController()
    // TODO 2: Crear el estado global del carrito usando remember { mutableStateListOf<Producto>() } o lista de ítems
    // TODO 3: Configurar el NavHost con startDestination = Rutas.LOGIN
    // TODO 4: Registrar la pantalla de Login (Rutas.LOGIN)
    //         - Pasar lambdas para navegar a Inicio (usando popUpTo para limpiar el stack) y a Crear Cuenta
    // TODO 5: Registrar la pantalla de Crear Cuenta (Rutas.CREAR_CUENTA)
    //         - Pasar lambda para volver a Login (popBackStack)
    // TODO 6: Registrar la pantalla de Inicio (Rutas.INICIO)
    //         - Pasar lambdas para navegar a Detalle, Carrito y Salir (Login con popUpTo)
    // TODO 7: Registrar la pantalla de Detalle del Producto (Rutas.DETALLE)
    //         - Recibir el parámetro "productoId" desde navBackStackEntry.arguments
    //         - Buscar el producto correspondiente
    //         - Pasar lambdas para agregar al carrito y volver
    // TODO 8: Registrar la pantalla de Carrito (Rutas.CARRITO)
    //         - Pasar la lista del carrito y lambdas para modificar cantidades e ir a Datos de Entrega
    // TODO 9: Registrar la pantalla de Datos de Entrega (Rutas.DATOS_ENTREGA)
    //         - Pasar lambdas para confirmar pedido y volver
    // TODO 10: Registrar la pantalla de Confirmación (Rutas.CONFIRMACION)
    //         - Limpiar el carrito de compras
    //         - Pasar lambda para regresar a Inicio usando popUpTo para reiniciar el flujo
}
