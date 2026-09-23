package com.rojas.clinica.data

object LocalDataSource {
    val medicosBase = listOf(
        Medico(
            id = "1",
            nombre = "Dra. Ana Torres",
            especialidad = "Cardiología",
            calificacion = 4.9,
            aniosExperiencia = 12,
            resenas = 128,
            descripcion = "Especialista en arritmias e hipertensión, formación en la Clínica Mayo."
        ),
        Medico(
            id = "2",
            nombre = "Dr. Luis Vega",
            especialidad = "Pediatría",
            calificacion = 4.7,
            aniosExperiencia = 8,
            resenas = 95,
            descripcion = "Atención integral para bebés y niños, especialista en pediatría general y neonatología."
        ),
        Medico(
            id = "3",
            nombre = "Dra. Rosa Díaz",
            especialidad = "Dermatología",
            calificacion = 4.8,
            aniosExperiencia = 10,
            resenas = 110,
            descripcion = "Especialista en dermatología clínica y estética, tratamiento de acné, manchas y rejuvenecimiento."
        )
    )

    val citasIniciales = listOf(
        Cita(medicoNombre = "Dra. Ana Torres", especialidad = "Cardiología", fecha = "Viernes 27", hora = "10:30 am", estado = "Confirmada"),
        Cita(medicoNombre = "Dr. Luis Vega", especialidad = "Pediatría", fecha = "Miércoles 15", hora = "3:00 pm", estado = "Completada")
    )
}
