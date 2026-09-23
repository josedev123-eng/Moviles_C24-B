package com.rojas.tecsupfit.data

data class ClaseFit(
    val id: Int,
    val titulo: String,
    val horario: String,
    val sala: String,
    val duracion: String,
    val descripcion: String,
    val cuposDisponibles: Int,
    val cuposTotales: Int,
    val dia: String = "Hoy"
)

data class ReservaFit(
    val id: Int,
    val tituloClase: String,
    val horario: String,
    var estado: String
)

data class Rutina(
    val id: Int,
    val nombre: String,
    val fecha: String,
    val detalles: String
)
