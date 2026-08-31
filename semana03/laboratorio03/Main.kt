import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun main() {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    println("=== SISTEMA DE GESTIÓN DE PRÉSTAMOS DE LIBROS ===")

    print("Ingrese el título del libro: ")
    val titulo = readln()

    print("Ingrese el tipo de usuario (Alumno / Profesor): ")
    val tipoUsuario = readln()

    print("Ingrese la fecha de préstamo (dd/MM/yyyy): ")
    val fPrestamo = LocalDate.parse(readln(), formatter)

    print("Ingrese la fecha límite de entrega (dd/MM/yyyy): ")
    val fEntrega = LocalDate.parse(readln(), formatter)

    print("Ingrese la fecha de devolución real (dd/MM/yyyy): ")
    val fDevolucion = LocalDate.parse(readln(), formatter)

    val prestamo = Prestamo(titulo, tipoUsuario, fPrestamo, fEntrega, fDevolucion)

    println("\n==================================================")
    println("              RESUMEN DEL PRÉSTAMO               ")
    println("==================================================")
    println("Título del libro : ${prestamo.tituloLibro}")
    println("Tipo de usuario  : ${prestamo.tipoUsuario.uppercase()}")
    println("Fecha préstamo   : ${prestamo.fechaPrestamo.format(formatter)}")
    println("Fecha entrega    : ${prestamo.fechaEntrega.format(formatter)}")
    println("Fecha devolución : ${prestamo.fechaDevolucion.format(formatter)}")
    println("Estado           : ${prestamo.obtenerEstado()}")
    println("==================================================")
}