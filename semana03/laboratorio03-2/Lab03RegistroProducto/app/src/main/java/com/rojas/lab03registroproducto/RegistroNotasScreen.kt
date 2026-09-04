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
fun ItemCurso(
    nombreCurso: String,
    nota: String,
    onNotaChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = CardBackground
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = nombreCurso,
                style = MaterialTheme.typography.titleMedium,
                color = TextPrimary,
                modifier = Modifier.weight(1f)
            )

            OutlinedTextField(
                value = nota,
                onValueChange = onNotaChange,
                label = { Text("Nota") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier.width(100.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = PrimaryBlue,
                    unfocusedBorderColor = TextSecondary,
                    focusedLabelColor = PrimaryBlue
                )
            )
        }
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
        }
    }
}
