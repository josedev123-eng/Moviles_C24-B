package com.rojas.tecsupfit.data

object LocalDataSource {
    val listaClases = listOf(
        ClaseFit(1, "Yoga funcional", "7:00 am", "Sala 2", "45 min", "Mejora la flexibilidad y alineación corporal.", 5, 10, "Hoy"),
        ClaseFit(2, "Cross Training", "6:00 pm", "Sala 1", "45 min", "Entrenamiento funcional de alta intensidad. Cupos limitados.", 8, 12, "Hoy"),
        ClaseFit(3, "Spinning", "7:30 pm", "Sala 3", "50 min", "Ciclismo cardiovascular de alta intensidad.", 4, 15, "Hoy"),
        ClaseFit(4, "Pilates", "9:00 am", "Sala 2", "45 min", "Control y fuerza muscular.", 6, 10, "Semana"),
        ClaseFit(5, "Box funcional", "5:00 pm", "Sala 1", "50 min", "Resistencia y agilidad.", 7, 12, "Semana")
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
