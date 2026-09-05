## Mejora con IA

En esta sección se documenta el proceso de integración de características asistidas por inteligencia artificial y las decisiones de refinamiento humano aplicadas sobre el código base.

| Prompt que usé | Qué generó Gemini | Qué acepté o corregí (y por qué) |
| :--- | :--- | :--- |
| **"En la función `PantallaRegistro` de `MainActivity.kt`, agrega validación de campos vacíos al presionar el botón REGISTRAR (si falta algún dato, muestra un mensaje de error en rojo en lugar de la Card de resumen) y añade un botón 'Limpiar' que vacíe todos los campos y estados. NO modifiques la estructura general de los `OutlinedTextField` ni el diseño del Scaffold."** | - Código base para manejar los estados de validación de campos vacíos.<br>- Estructura general de la pantalla con Jetpack Compose.<br>- Lógica básica para el botón de limpiar y la tarjeta de resultados. | **Acepté:**<br>- La estructura principal y la lógica de validación general aportada por la IA.<br><br>**Corregí:**<br>- Realicé ajustes ligeros en algunos textos y espaciados de la interfaz.<br>- Añadí y organicé el texto del resumen de la operación dentro de la tarjeta para que se visualice correctamente el cálculo final, asi como ajustes algunos espaciados y textos para una mejora claridad de la aplicacion. |
