package com.tecsup.mibodega

import androidx.compose.runtime.Composable

/** Pantalla 5: Carrito de Compras.
 * Muestra los productos agregados, permite modificar cantidades, calcula el total y el costo de delivery.
 */
@Composable
fun PantallaCarrito() {
    // TODO: Definir los parámetros que debe recibir la función (State Hoisting):
    // - itemsCarrito: List<ItemCarrito> (Lista de ítems en el carrito)
    // - onIncrementarCantidad: (Int) -> Unit (Aumentar cantidad de un ítem)
    // - onDecrementarCantidad: (Int) -> Unit (Disminuir cantidad de un ítem)
    // - onEliminarItem: (Int) -> Unit (Eliminar ítem del carrito)
    // - onContinuarPedido: () -> Unit (Acción para avanzar a la pantalla de datos de entrega)
    // - onVolver: () -> Unit (Acción para regresar)

    // TODO: Realizar cálculos reactivos (sin guardar en estado mutable innecesario):
    // - subtotal = suma del precio * cantidad de cada ítem
    // - delivery = 4.00 (monto fijo de envío en S/)
    // - total = subtotal + delivery

    // TODO: Diseñar la interfaz de usuario con Jetpack Compose:
    // - TopAppBar con título "Mi Carrito" y botón volver
    // - Condicional: si el carrito está vacío, mostrar un mensaje "Tu carrito está vacío"
    // - LazyColumn con la lista de productos (Card para cada ítem con controles para sumar, restar y eliminar)
    // - Card de resumen con el cálculo reactivo: Subtotal, Delivery (S/ 4.00) y Total
    // - Botón "Continuar pedido" que navegue a Datos de Entrega
}
