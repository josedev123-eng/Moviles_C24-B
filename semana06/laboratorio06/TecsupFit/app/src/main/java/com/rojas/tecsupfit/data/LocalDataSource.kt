package com.rojas.tecsupfit.data

object LocalDataSource {
    val listaClases = listOf(
        ClaseFit(1, "Yoga funcional", "7:00 am", "Sala 2", "45 min", "Mejora la flexibilidad y alineación corporal.", 5, 10),
        ClaseFit(2, "Cross Training", "6:00 pm", "Sala 1", "45 min", "Entrenamiento funcional de alta intensidad. Cupos limitados.", 8, 12),
        ClaseFit(3, "Spinning", "7:30 pm", "Sala 3", "50 min", "Ciclismo cardiovascular de alta intensidad.", 4, 15)
    )

    val misReservasIniciales = mutableListOf(
        ReservaFit(1, "Cross Training", "Hoy, 6:00 pm", "Confirmada"),
        ReservaFit(2, "Yoga funcional", "Ayer, 7:00 am", "Completada")
    )

    val historialRutinas = listOf(
        Rutina(1, "Rutina de Piernas & Core", "Ayer", "4 ejercicios · 45 min"),
        Rutina(2, "Cardio HIIT", "Hace 3 días", "5 ejercicios · 30 min")
    )
}