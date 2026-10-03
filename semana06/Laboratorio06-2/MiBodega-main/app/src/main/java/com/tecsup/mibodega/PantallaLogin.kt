package com.tecsup.mibodega

import androidx.compose.runtime.Composable

/** Pantalla 1: Login / Iniciar Sesión.
 * Permite a los usuarios ingresar a la aplicación con su teléfono y contraseña.
 */
@Composable
fun PantallaLogin() {
    // TODO: Definir los parámetros que debe recibir la función (State Hoisting):
    // - onIngresar: () -> Unit (Acción para ir a la pantalla de Inicio tras validar)
    // - onCrearCuenta: () -> Unit (Acción para navegar a la pantalla de registro)

    // TODO: Definir los estados locales con remember y mutableStateOf:
    // - telefono: String (para el campo de texto de teléfono)
    // - contrasena: String (para el campo de texto de contraseña)
    // - errorMensaje: String? (para mostrar mensajes de validación)

    // TODO: Diseñar la interfaz de usuario con Jetpack Compose:
    // - Column centrada con padding
    // - Título y subtítulo de bienvenida
    // - OutlinedTextField para el teléfono (con KeyboardOptions para tipo Phone)
    // - OutlinedTextField para la contraseña (con VisualTransformation.Password)
    // - Texto de error si las validaciones fallan (campos vacíos)
    // - Button "Ingresar" que valide que los campos no estén vacíos antes de llamar a onIngresar
    // - TextButton "¿No tienes cuenta? Regístrate aquí" que llame a onCrearCuenta
}
