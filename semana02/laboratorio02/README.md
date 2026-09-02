# Laboratorio 02: Carrito de Compras en Kotlin

**Estudiante:** Jose
**Curso:** Desarrollo de Aplicaciones Móviles

## Descripción
Programa en consola desarrollado en Kotlin para gestionar un carrito de compras. El sistema permite listar productos, calcular subtotales, aplicar IGV (18%), calcular descuentos escalonados según el monto total, identificar el producto de mayor valor y formatear el reporte final en columnas ordenadas.

## Funciones Implementadas
* `calcularSubtotal`: Calcula el importe total sumando `precio * cantidad`.
* `calcularIGV`: Calcula el 18% del subtotal.
* `calcularTotal`: Realiza la suma del subtotal e IGV.
* `mostrarDetalle`: Formatea y alinea en columnas los datos de los productos mediante `String.format`.
* `calcularDescuento`: Evalúa los rangos de compra con `when` para aplicar 5% o 10% de descuento.
* `buscarProducto`: Busca un elemento específico en la lista usando `.find`.
* `removeIf`: Filtra y elimina un producto del carrito actualizando los totales.

## Pregunta de Reflexión (Parte 2)

**¿Por qué `nombre` y `precio` son `val` pero `cantidad` es `var`?**
* **`nombre` y `precio` son `val`** porque son atributos inmutables del producto en el catálogo (sus valores no varían durante la compra).
* **`cantidad` es `var`** porque es mutable y representa las unidades seleccionadas por el cliente, las cuales pueden modificarse dinámicamente.

**¿Qué pasaría si intentas cambiar el precio después de crear el producto?**
Kotlin arrojará un error de compilación (`Val cannot be reassigned`), ya que los atributos `val` son de solo lectura una vez asignados
<img width="530" height="697" alt="image" src="https://github.com/user-attachments/assets/e3c830bc-591e-44ea-b767-1f52c35cf821" />

