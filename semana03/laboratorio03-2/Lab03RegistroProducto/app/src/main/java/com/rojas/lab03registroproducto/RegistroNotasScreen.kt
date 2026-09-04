package com.rojas.lab03registroproducto

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType

val PrimaryPurple = Color(0xFF6750A4)
val DarkPurple = Color(0xFF4A3780)
val LightBackgroundStart = Color(0xFFEADDFF)
val LightBackgroundEnd = Color(0xFFF3EDF7)
val BadgeBgColor = Color(0xFFE8DEF8)
val PrimaryBlue = Color(0xFF2196F3)
val TextSecondary = Color(0xFF757575)
val TextPrimary = Color(0xFF212121)
val CardBackground = Color(0xFFFFFFFF)

val GreenDark = Color(0xFF1B5E20)
val Amber = Color(0xFFFFB300)
val Red = Color(0xFFE53935)

@Composable
fun ItemCursoSlider(
    nombreCurso: String,
    porcentaje: Int,
    nota: Float,
    onNotaChange: (Float) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = nombreCurso,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "($porcentaje%)",
                    style = MaterialTheme.typography.bodySmall,
                    color = DarkPurple.copy(alpha = 0.7f)
                )
            }
            Surface(
                color = BadgeBgColor,
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "${nota.roundToInt()}",
                    color = DarkPurple,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 2.dp)
                )
            }
        }

        Slider(
            value = nota,
            onValueChange = onNotaChange,
            valueRange = 0f..20f,
            steps = 19,
            colors = SliderDefaults.colors(
                thumbColor = DarkPurple,
                activeTrackColor = DarkPurple,
                inactiveTrackColor = LightBackgroundStart
            )
        )
    }
}
@Composable
fun RegistroNotasScreen() {
    val cursos = remember {
        mutableStateListOf(
            Pair("Programacion en Moviles", ""),
            Pair("Programación Orientada a Objetos", ""),
            Pair("Fundamentos de Progrmacion", ""),
            Pair("Base de Datos", "")
        )
    }

    val notasIngresadas = cursos.mapNotNull { it.second.toFloatOrNull() }
    val promedioCalculado = if (notasIngresadas.isNotEmpty()) notasIngresadas.average() else 0.0
    val promedioRedondeado = (promedioCalculado * 100).roundToInt() / 100.0

    val (estadoTexto, estadoColor) = when {
        notasIngresadas.isEmpty() -> "Sin notas" to TextSecondary
        promedioCalculado >= 18 -> "Excelente" to GreenDark
        promedioCalculado >= 13 -> "Aprobado" to PrimaryBlue
        promedioCalculado >= 10 -> "En Recuperación" to Amber
        else -> "Desaprobado" to Red
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(LightBackgroundStart, LightBackgroundEnd)
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Registro de Notas",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = DarkPurple,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            cursos.forEachIndexed { index, curso ->
                ItemCurso(
                    nombreCurso = curso.first,
                    nota = curso.second,
                    onNotaChange = { nuevaNota ->
                        cursos[index] = curso.copy(second = nuevaNota)
                    }
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = BadgeBgColor),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "PROMEDIO GENERAL",
                        style = MaterialTheme.typography.labelLarge,
                        color = TextSecondary,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = if (notasIngresadas.isNotEmpty()) "$promedioRedondeado" else "--",
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        color = DarkPurple
                    )

                    Surface(
                        color = estadoColor.copy(alpha = 0.15f),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Text(
                            text = estadoTexto,
                            color = estadoColor,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)
                        )
                    }
                }
            }
        }
    }
}