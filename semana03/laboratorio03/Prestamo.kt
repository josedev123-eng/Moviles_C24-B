package semana03.laboratorio03
import java.time.LocalDate

class Prestamo(
    val tituloLibro: String,
    val tipoUsuario: String,
    val fechaPrestamo: LocalDate,
    val fechaEntrega: LocalDate,
    val fechaDevolucion: LocalDate
) {
    val tarifaPorDia: Double = when (tipoUsuario.lowercase()) {
        "docente" -> 3.0
        "alumno" -> 1.50
        else -> 0.00
    }

    fun obtenerDiasRetraso(): Long {
        val dias = java.time.temporal.ChronoUnit.DAYS.between(fechaEntrega, fechaDevolucion)
        return if (dias > 0) dias else 0
    }

    fun obtenerEstado(): String {
        val dias = obtenerDiasRetraso()
        return if (dias > 0) {
            "Devuelto con $dias días de retraso"
        } else {
            "Entregado a tiempo"
        }
    }
}