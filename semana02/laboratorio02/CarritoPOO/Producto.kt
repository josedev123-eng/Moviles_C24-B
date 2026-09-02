package laboratorio02.CarritoPOO

class Producto(
    val nombre: String,
    val precio: Double,
    var cantidad: Int
) {
    fun obtenerSubtotal(): Double {
        return precio * cantidad
    }
}