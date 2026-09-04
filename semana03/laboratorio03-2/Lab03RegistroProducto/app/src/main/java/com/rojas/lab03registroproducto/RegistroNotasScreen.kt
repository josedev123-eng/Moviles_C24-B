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
val RedLight = Color(0xFFFFCDD2)
val GreenLight = Color(0xFFD4EDDA)

@Composable
fun ItemCursoSlider(
    nombreCurso: String,
    porcentaje: Int,
    nota: Float,
    onNotaChange: (Float) -> Unit
) {
    val notaRedondeada = nota.roundToInt()
    val aporte = notaRedondeada * (porcentaje / 100.0)


    val badgeBg = if (notaRedondeada < 13) RedLight else GreenLight
    val badgeTextColor = if (notaRedondeada < 13) Red else GreenDark

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
                color = badgeBg,
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "$notaRedondeada",
                    color = badgeTextColor,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 2.dp)
                )
            }
        }

        Text(
            text = "Aporte: $notaRedondeada × $porcentaje% = ${String.format("%.2f", aporte)}",
            style = MaterialTheme.typography.bodySmall,
            color = TextSecondary,
            modifier = Modifier.padding(top = 2.dp)
        )

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
    var nota1 by rememberSaveable { mutableFloatStateOf(0f) }
    var nota2 by rememberSaveable { mutableFloatStateOf(0f) }
    var nota3 by rememberSaveable { mutableFloatStateOf(0f) }
    var nota4 by rememberSaveable { mutableFloatStateOf(0f) }

    var redondear by rememberSaveable { mutableStateOf(false) }
    var confirmado by rememberSaveable { mutableStateOf(false) }
    var calculado by rememberSaveable { mutableStateOf(false) }

    var promedioPonderado by rememberSaveable { mutableDoubleStateOf(0.0) }
    var promedioFinalStr by rememberSaveable { mutableStateOf("") }
    var estadoTexto by rememberSaveable { mutableStateOf("") }

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
                modifier = Modifier.padding(vertical = 4.dp)
            )

            Text(
                text = "Notas del ciclo",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Desliza para asignar cada nota (0 a 20)",
                style = MaterialTheme.typography.bodySmall,
                color = TextSecondary
            )

            ItemCursoSlider("Fundamentos de Programación", 20, nota1) { nota1 = it }
            ItemCursoSlider("Programación Orientada a Objetos", 25, nota2) { nota2 = it }
            ItemCursoSlider("Programación en Móviles", 30, nota3) { nota3 = it }
            ItemCursoSlider("Base de Datos", 25, nota4) { nota4 = it }

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Redondear promedio final", style = MaterialTheme.typography.bodyMedium)
                Switch(
                    checked = redondear,
                    onCheckedChange = { redondear = it },
                    colors = SwitchDefaults.colors(checkedTrackColor = DarkPurple)
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = confirmado,
                    onCheckedChange = { confirmado = it },
                    colors = CheckboxDefaults.colors(checkedColor = DarkPurple)
                )
                Text("Confirmo que las notas son correctas", style = MaterialTheme.typography.bodyMedium)
            }

            Button(
                onClick = {
                    promedioPonderado = (nota1 * 0.20) + (nota2 * 0.25) + (nota3 * 0.30) + (nota4 * 0.25)
                    val finalVal = if (redondear) promedioPonderado.roundToInt().toDouble() else promedioPonderado

                    promedioFinalStr = if (redondear) "${finalVal.toInt()}" else String.format("%.2f", finalVal)
                    estadoTexto = if (finalVal >= 13) "APROBADO" else "DESAPROBADO"
                    calculado = true
                },
                enabled = confirmado,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = DarkPurple,
                    disabledContainerColor = Color(0xFFBBB3D7)
                ),
                shape = RoundedCornerShape(24.dp)
            ) {
                Text("CALCULAR PROMEDIO", fontWeight = FontWeight.Bold)
            }

            OutlinedButton(
                onClick = {
                    nota1 = 0f
                    nota2 = 0f
                    nota3 = 0f
                    nota4 = 0f
                    redondear = false
                    confirmado = false
                    calculado = false
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = DarkPurple)
            ) {
                Text("LIMPIAR", fontWeight = FontWeight.Bold)
            }

            if (calculado) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = CardBackground),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Text(
                            text = "Promedio ponderado: ${String.format("%.2f", promedioPonderado)}",
                            color = TextSecondary,
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Row(verticalAlignment = Alignment.Bottom) {
                            Text(
                                text = "Promedio final: ",
                                fontWeight = FontWeight.Bold,
                                color = DarkPurple
                            )
                            Text(
                                text = promedioFinalStr,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = DarkPurple
                            )
                        }
                        if (redondear) {
                            Text("(redondeado)", fontSize = 11.sp, color = TextSecondary)
                        }

                        Surface(
                            color = if (estadoTexto == "APROBADO") Color(0xFFD4EDDA) else Color(0xFFFFCDD2),
                            shape = RoundedCornerShape(16.dp),
                            modifier = Modifier.padding(top = 4.dp)
                        ) {
                            Text(
                                text = estadoTexto,
                                color = if (estadoTexto == "APROBADO") GreenDark else Red,
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp,
                                modifier = Modifier.padding(horizontal = 14.dp, vertical = 4.dp)
                            )
                        }
                    }
                }
                Text(
                    text = "✓ Promedio calculado correctamente",
                    color = GreenDark,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            } else {
                Text(
                    text = "Asigna las notas y confirma para calcular",
                    fontSize = 12.sp,
                    color = TextSecondary,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }

            Text(
                text = "Desarrollado por: Jose Rojas Condor",
                fontSize = 11.sp,
                color = TextSecondary,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}