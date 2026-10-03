package com.tecsup.mibodega

import androidx.compose.runtime.Composable

/** Pantalla 4: Detalle del Producto.
 * Muestra la información completa de un producto seleccionado y permite elegir la cantidad a comprar.
 */
@Composable
fun PantallaDetalleProducto() {
    // TODO: Definir los parámetros que debe recibir la función (State Hoisting):
    // - producto: Producto (El producto a mostrar)
    // - onAgregarAlCarrito: (Producto, Int) -> Unit (Acción para añadir el producto con la cantidad seleccionada)
    // - onVolver: () -> Unit (Acción para regresar a la pantalla anterior)

    // TODO: Definir los estados locales con remember y mutableStateOf:
    // - cantidad: Int (iniciado en 1, para el selector de cantidad)

    // TODO: Diseñar la interfaz de usuario con Jetpack Compose:
    // - TopAppBar con botón de regreso que invoque a onVolver
    // - Imagen o icono descriptivo del producto
    // - Nombre del producto en tipografía destacada
    // - Precio unitario del producto (destacado con color de precio)
    // - Descripción detallada del producto
    // - Selector de cantidad con botones (-) y (+) para modificar la variable 'cantidad'
    // - Botón "Agregar al carrito" que pase el producto y la cantidad seleccionada
}
