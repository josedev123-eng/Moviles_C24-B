package laboratorio02.CarritoPOO

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    print("Ingrese el nombre del cliente: ")
    val nombreCliente = scanner.nextLine().ifBlank { "Jose" }

    val carrito = CarritoCompras(nombreCliente)

    carrito.agregarProducto("Laptop", 3500.0, 1)
    carrito.agregarProducto("Mouse", 80.0, 2)
    carrito.agregarProducto("Teclado", 150.0, 1)

    var opcion: Int

    do {
        println("\n--- MENÚ INTERACTIVO (POO) ---")
        println("1. Agregar producto")
        println("2. Eliminar producto")
        println("3. Buscar producto")
        println("4. Ver detalle del carrito")
        println("5. Salir")
        print("Seleccione una opción: ")

        opcion = scanner.nextLine().toIntOrNull() ?: 0

        when (opcion) {
            1 -> {
                print("Nombre del producto: ")
                val nombre = scanner.nextLine()

                print("Precio unitario (S/): ")
                val precio = scanner.nextLine().toDoubleOrNull() ?: 0.0

                print("Cantidad: ")
                val cantidad = scanner.nextLine().toIntOrNull() ?: 1

                if (nombre.isNotBlank() && precio > 0 && cantidad > 0) {
                    carrito.agregarProducto(nombre, precio, cantidad)
                    println("-> Producto '$nombre' agregado.")
                } else {
                    println("-> Datos inválidos.")
                }
            }
            2 -> {
                print("Nombre del producto a eliminar: ")
                val nombre = scanner.nextLine()
                if (carrito.eliminarProducto(nombre)) {
                    println("-> Producto '$nombre' eliminado.")
                } else {
                    println("-> Producto no encontrado.")
                }
            }
            3 -> {
                print("Nombre del producto a buscar: ")
                val nombre = scanner.nextLine()
                val encontrado = carrito.buscarProducto(nombre)
                if (encontrado != null) {
                    println("-> Producto encontrado: ${encontrado.nombre} | S/ ${encontrado.precio} x${encontrado.cantidad}")
                } else {
                    println("-> El producto '$nombre' no existe en el carrito.")
                }
            }
            4 -> carrito.mostrarDetalle()
            5 -> println("\n¡Gracias por su compra, $nombreCliente!")
            else -> println("-> Opción no válida.")
        }
    } while (opcion != 5)
}