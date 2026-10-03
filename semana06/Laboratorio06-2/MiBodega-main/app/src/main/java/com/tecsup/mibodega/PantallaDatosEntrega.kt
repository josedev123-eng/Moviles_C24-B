package com.tecsup.mibodega

import androidx.compose.runtime.Composable

/** Pantalla 6: Datos de Entrega y Pago.
 * Formulario para ingresar los datos de envío y seleccionar el método de pago antes de finalizar el pedido.
 */
@Composable
fun PantallaDatosEntrega() {
    // TODO: Definir los parámetros que debe recibir la función (State Hoisting):
    // - onConfirmarPedido: () -> Unit (Acción al completar los datos e iniciar la confirmación)
    // - onVolver: () -> Unit (Acción para regresar al carrito)

    // TODO: Definir los estados locales con remember y mutableStateOf:
    // - nombre: String
    // - telefono: String
    // - direccion: String
    // - referencia: String
    // - metodoPago: String (ej. "Efectivo", "Yape / Plin", "Tarjeta")
    // - errorMensaje: String?

    // TODO: Diseñar la interfaz de usuario con Jetpack Compose:
    // - TopAppBar con botón de regreso que invoque a onVolver
    // - Formulario con OutlinedTextFields para: Nombre completo, Teléfono, Dirección y Referencia
    // - Sección de método de pago utilizando RadioButtons (Efectivo, Yape / Plin, Tarjeta)
    // - Mensaje de error si faltan llenar campos obligatorios
    // - Botón "Confirmar y realizar pedido" que valide los datos e invoque a onConfirmarPedido
}
