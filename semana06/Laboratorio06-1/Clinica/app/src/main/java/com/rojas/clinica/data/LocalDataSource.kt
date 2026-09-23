package com.rojas.clinica.data

object LocalDataSource {
    val medicosBase = listOf(
        Medico("1", "Dra. Ana Torres", "Cardiología", 4.9),
        Medico("2", "Dr. Luis Vega", "Pediatría", 4.7),
        Medico("3", "Dra. Rosa Díaz", "Dermatología", 4.8)
    )

    val citasIniciales = listOf(
        Cita(medicoNombre = "Dra. Ana Torres", especialidad = "Cardiología", fecha = "Viernes 27", hora = "10:30 am", estado = "Confirmada"),
        Cita(medicoNombre = "Dr. Luis Vega", especialidad = "Pediatría", fecha = "Miércoles 15", hora = "3:00 pm", estado = "Completada")
    )
}

