package com.rojas.clinica.data

import java.util.UUID

data class Medico(
    val id: String,
    val nombre: String,
    val especialidad: String,
    val calificacion: Double,
    val aniosExperiencia: Int = 0,
    val resenas: Int = 0,
    val descripcion: String = ""
)

data class Cita(
    val id: String = UUID.randomUUID().toString(),
    val medicoNombre: String,
    val especialidad: String,
    val fecha: String,
    val hora: String,
    var estado: String = "Confirmada"
)
