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

    al diasRetraso = prestamo.obtenerDiasRetraso()

    if (diasRetraso > 0) {
        println("\n--- DETALLE DE MULTAS POR DÍA ---")
        println("%-5s | %-12s | %-10s | %-10s".format("Día", "Fecha", "Multa", "Acumulado"))
        println("--------------------------------------------------")

        var acumulado = 0.0
        var fechaCorriente = prestamo.fechaEntregaEsperada.plusDays(1)

        for (i in 1..diasRetraso) {
            val multaDia = prestamo.tarifaPorDia
            acumulado += multaDia

            println("%-5d | %-12s | S/ %-7.2f | S/ %-7.2f".format(
                i,
                fechaCorriente.format(formatter),
                multaDia,
                acumulado
            ))

            fechaCorriente = fechaCorriente.plusDays(1)
        }

        println("--------------------------------------------------")
        println("MULTA TOTAL A PAGAR: S/ %.2f".format(acumulado))
    } else {
        println("\n¡El libro fue devuelto a tiempo! No aplica multa. Total: S/ 0.00")
    }
 }
}