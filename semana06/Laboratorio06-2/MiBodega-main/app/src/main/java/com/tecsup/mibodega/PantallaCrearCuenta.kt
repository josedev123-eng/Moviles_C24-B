package com.tecsup.mibodega

import androidx.compose.runtime.Composable

/** Pantalla 2: Registro / Crear Cuenta.
 * Permite a un nuevo usuario registrar sus datos personales en la bodega.
 */
@Composable
fun PantallaCrearCuenta() {
    // TODO: Definir los parámetros que debe recibir la función (State Hoisting):
    // - onCuentaCreada: () -> Unit (Acción tras completar el registro exitosamente)
    // - onVolver: () -> Unit (Acción para regresar a la pantalla de Login)

    // TODO: Definir los estados locales con remember y mutableStateOf:
    // - nombre: String
    // - telefono: String
    // - direccion: String
    // - contrasena: String
    // - errorMensaje: String?

    // TODO: Diseñar la interfaz de usuario con Jetpack Compose:
    // - Column con scroll o LazyColumn
    // - Botón o icono de volver atrás que invoque a onVolver
    // - Título "Crear una Cuenta"
    // - OutlinedTextFields para: Nombre completo, Teléfono, Dirección de entrega y Contraseña
    // - Mensaje de error si falta llenar algún campo obligatorio
    // - Button "Registrarse" que valide los datos e invoque a onCuentaCreada
}
