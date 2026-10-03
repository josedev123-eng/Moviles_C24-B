package com.tecsup.mibodega

import androidx.compose.runtime.Composable

/** Pantalla 3: Inicio / Catálogo de Productos.
 * Muestra la lista de productos disponibles con filtros por búsqueda y categoría,
 * además de una barra de navegación inferior.
 */
@Composable
fun PantallaInicio() {
    // TODO: Definir los parámetros que debe recibir la función (State Hoisting):
    // - productos: List<Producto> (Lista completa de productos disponibles)
    // - onProductoClick: (Int) -> Unit (Acción al seleccionar un producto para ver su detalle)
    // - onVerCarrito: () -> Unit (Acción al presionar el botón de carrito)
    // - onCerrarSesion: () -> Unit (Acción para salir y regresar al Login)

    // TODO: Definir los estados locales con remember y mutableStateOf:
    // - textoBusqueda: String (para filtrar productos por nombre)
    // - categoriaSeleccionada: String (para filtrar por categoría, por defecto "Todos")

    // TODO: Diseñar la interfaz de usuario con Jetpack Compose:
    // - Scaffold con NavigationBar en el bottomBar conteniendo las opciones: Inicio, Carrito y Salir
    // - TopAppBar con título de la bodega
    // - OutlinedTextField para el texto de búsqueda
    // - LazyRow para las categorías (chips o botones de filtro: Todos, Abarrotes, Lácteos, Bebidas, etc.)
    // - LazyColumn para renderizar la lista de productos filtrados (usar Cards con nombre, precio, categoría y botón ver más)
}
