package com.tecsup.mibodega

// Rutas de navegación de la app
object Rutas {
    const val LOGIN = "login"
    const val CREAR_CUENTA = "crear_cuenta"
    const val INICIO = "inicio"
    const val DETALLE = "detalle/{productoId}"
    const val CARRITO = "carrito"
    const val DATOS_ENTREGA = "datos_entrega"
    const val CONFIRMACION = "confirmacion"

    // Arma la ruta del detalle con el id del producto
    fun detalle(productoId: Int) = "detalle/$productoId"
}