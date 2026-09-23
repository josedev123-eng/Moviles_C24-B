package com.rojas.navlab.data

import com.rojas.navlab.R
import com.rojas.navlab.model.Student

object StudentRepository {
    val students: List<Student> = listOf(
        Student(
            id = 1,
            name = "Jose Rojas Condor",
            career = "Ingeniería de Sistemas",
            code = "2024-0001",
            email = "jose.rojas@example.com",
            faculty = "Ingeniería y Tecnología",
            bio = "Estudiante destacado con interés en desarrollo Android.",
            avatar = R.drawable.avatar_juan
        ),
        Student(
            id = 2,
            name = "Maria Garcia",
            career = "Arquitectura",
            code = "2024-0002",
            email = "maria.garcia@example.com",
            faculty = "Arquitectura y Diseño",
            bio = "Apasionada por el diseño sostenible y el urbanismo moderno.",
            avatar = R.drawable.avatar_maria
        ),
        Student(
            id = 3,
            name = "Carlos Perez",
            career = "Medicina",
            code = "2024-0003",
            email = "carlos.perez@example.com",
            faculty = "Ciencias de la Salud",
            bio = "Enfocado en la investigación médica y la salud comunitaria.",
            avatar = R.drawable.avatar_carlos
        ),
        Student(
            id = 4,
            name = "Ana Lopez",
            career = "Derecho",
            code = "2024-0004",
            email = "ana.lopez@example.com",
            faculty = "Derecho y Ciencias Políticas",
            bio = "Interesada en el derecho internacional y la defensa de los derechos humanos.",
            avatar = R.drawable.avatar_ana
        ),
        Student(
            id = 5,
            name = "Luis Ramirez",
            career = "Administración",
            code = "2024-0005",
            email = "luis.ramirez@example.com",
            faculty = "Gestión y Negocios",
            bio = "Orientado a la gestión de proyectos y la innovación empresarial.",
            avatar = R.drawable.avatar_luis
        )
    )

    fun getById(id: Int): Student {
        return students.find { it.id == id } ?: students.first()
    }
}
