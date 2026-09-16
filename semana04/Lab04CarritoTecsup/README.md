# Lab04: Carrito de Compras en Jetpack Compose

**Estudiante:** Jose Rojas  
**Curso:** Desarrollo de Aplicaciones Móviles  
**Tecsup - Semana 04**

---

## Descripción del Proyecto
Aplicación móvil desarrollada en Android con Jetpack Compose que implementa un carrito de compras reactivo. Permite agregar productos (nombre, precio y cantidad), visualizarlos dinámicamente en una lista (`LazyColumn`), eliminarlos de manera individual mediante elevación de eventos (`lambdas`) y calcular de forma automática el subtotal, IGV (18%) y total a pagar.

---

## Capturas de Pantalla

| Estado Vacío | Estado con Productos |
| :---: | :---: |
| ![Carrito Vacío](<img width="247" height="531" alt="image" src="https://github.com/user-attachments/assets/e4ed4f3d-8b97-4332-8c9e-736ac6321f85" />
) | ![Carrito con Productos](<img width="254" height="543" alt="image" src="https://github.com/user-attachments/assets/0b9503f3-f3fe-4aa9-93bf-fe17fcd5ea2d" />
) |

---

## Cuestionario Sustentatorio

### (a) ¿Por qué `mutableStateListOf` y no una `MutableList` normal?
Una `MutableList` estándar de Kotlin no es observada por el sistema de re-renderizado (*recomposition*) de Jetpack Compose. Si agregamos o eliminamos elementos en una `MutableList` común, la pantalla no detectará los cambios automáticamente. 

En cambio, `mutableStateListOf` crea una lista reactiva vinculada al estado de Compose. Cada vez que la lista sufre una modificación (adición o eliminación de un elemento), Compose notifica a la interfaz y actualiza automáticamente los composables afectados (como `LazyColumn` y el panel de totales).

### (b) ¿Por qué la lista declarada con `val` permite agregar elementos?
La palabra clave `val` en Kotlin significa que la **referencia del objeto** no puede ser reasignada a una nueva instancia (es decir, no podemos hacer `productos = mutableStateListOf()`). 

Sin embargo, el **contenido interno** del objeto referenciado por `productos` sí es mutable. La instancia del estado creado por `mutableStateListOf` permanece viva en la misma dirección de memoria gracias a `remember`, y nos permite invocar métodos mutables como `.add()` y `.remove()` libremente.

### (c) ¿Qué hace `weight(1f)` en la `LazyColumn`?
El modificador `.weight(1f)` dentro de un contenedor `Column` le indica a la `LazyColumn` que tome todo el espacio vertical sobrante disponible entre el formulario superior y el panel de totales inferior. 

Esto garantiza que la lista sea desplazable (*scrollable*) sin empujar el panel de totales fuera de la pantalla, manteniendo los totales siempre visibles en la parte inferior de la interfaz.
