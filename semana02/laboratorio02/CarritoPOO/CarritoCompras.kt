package laboratorio02.CarritoPOO

class CarritoCompras(val cliente: String) {
    private val productos = mutableListOf<Producto>()

    fun agregarProducto(nombre: String, precio: Double, cantidad: Int) {
        val existente = productos.find { it.nombre.equals(nombre, ignoreCase = true) }
        if (existente != null) {
            existente.cantidad += cantidad
            println("-> Se actualizó la cantidad de '${existente.nombre}' a ${existente.cantidad}.")
        } else {
            productos.add(Producto(nombre, precio, cantidad))
            println("-> Producto '$nombre' agregado al carrito.")
        }
    }

    fun eliminarProducto(nombre: String): Boolean {
        return productos.removeIf { it.nombre.equals(nombre, ignoreCase = true) }
    }

    fun calcularSubtotal(): Double = productos.sumOf { it.obtenerSubtotal() }

    fun calcularIGV(): Double = calcularSubtotal() * 0.18

    fun calcularTotal(): Double = calcularSubtotal() + calcularIGV()

    fun calcularDescuento(): Double {
        val total = calcularTotal()
        return when {
            total > 5000 -> total * 0.10
            total > 3000 -> total * 0.05
            else -> 0.0
        }
    }

    fun buscarProducto(nombre: String): Producto? {
        return productos.find { it.nombre.equals(nombre, ignoreCase = true) }
    }

    fun obtenerProductoMasCaro(): Producto? = productos.maxByOrNull { it.precio }

    fun mostrarDetalle() {
        if (productos.isEmpty()) {
            println("\nEl carrito está vacío.")
            return
        }

        println("\n=========================================")
        println("   CARRITO DE COMPRAS - TIENDA TECSUP   ")
        println("=========================================")
        println("Cliente: $cliente")
        println("-----------------------------------------")
        println(String.format("%-3s %-18s %-5s %-10s", "#", "PRODUCTO", "CANT", "SUBTOTAL"))
        println("-----------------------------------------")

        productos.forEachIndexed { i, p ->
            println(String.format("%-3d %-18s x%-4d S/ %7.2f", i + 1, p.nombre, p.cantidad, p.obtenerSubtotal()))
        }

        val subtotal = calcularSubtotal()
        val igv = calcularIGV()
        val total = calcularTotal()
        val descuento = calcularDescuento()

        println("-----------------------------------------")
        println("Cantidad total de ítems  : ${productos.sumOf { it.cantidad }}")
        println(String.format("%-25s : S/ %7.2f", "Subtotal", subtotal))
        println(String.format("%-25s : S/ %7.2f", "IGV (18%)", igv))
        println(String.format("%-25s : S/ %7.2f", "TOTAL A PAGAR", total))
        println("-----------------------------------------")

        val masCaro = obtenerProductoMasCaro()
        if (masCaro != null) {
            println("Producto más caro: ${masCaro.nombre} (S/ ${String.format("%.2f", masCaro.precio)})")
        }

        if (descuento > 0.0) {
            val porcentaje = if (total > 5000) "10%" else "5%"
            val limite = if (total > 5000) "5000" else "3000"
            println("Descuento aplicado ($porcentaje) por compra > S/ $limite: S/ ${String.format("%.2f", descuento)}")
        }

        println(String.format("%-25s : S/ %7.2f", "TOTAL FINAL CON DESCUENTO", total - descuento))
        println("=========================================\n")
    }
}