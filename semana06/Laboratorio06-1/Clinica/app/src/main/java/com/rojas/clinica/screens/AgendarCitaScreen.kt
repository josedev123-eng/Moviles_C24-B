package com.rojas.clinica.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rojas.clinica.data.Medico

private data class FechaOption(
    val diaCorto: String,
    val numero: String,
    val textoCompleto: String
)

private data class HoraOption(
    val horaCorta: String,
    val textoCompleto: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AgendarCitaScreen(
    medico: Medico?,
    onConfirmar: (String, String) -> Unit,
    onBack: () -> Unit
) {
    val opcionesFecha = listOf(
        FechaOption("Jue", "26", "Jueves 26"),
        FechaOption("Vie", "27", "Viernes 27"),
        FechaOption("Sáb", "28", "Sábado 28")
    )

    val opcionesHora = listOf(
        HoraOption("9:00", "9:00 am"),
        HoraOption("10:30", "10:30 am"),
        HoraOption("3:00", "3:00 pm")
    )

    var fechaSeleccionada by remember { mutableStateOf("Viernes 27") }
    var horaSeleccionada by remember { mutableStateOf("10:30 am") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Agendar cita",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1C1B1F)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Atrás",
                            tint = Color(0xFF1C1B1F)
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Selecciona fecha",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF6B6B6B)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    opcionesFecha.forEach { option ->
                        val isSelected = (fechaSeleccionada == option.textoCompleto)
                        Surface(
                            modifier = Modifier
                                .size(width = 72.dp, height = 60.dp)
                                .clickable { fechaSeleccionada = option.textoCompleto },
                            shape = RoundedCornerShape(12.dp),
                            color = if (isSelected) MaterialTheme.colorScheme.primary else Color(0xFFEDE7F6)
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = option.diaCorto,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = if (isSelected) Color.White else Color(0xFF1C1B1F)
                                )
                                Text(
                                    text = option.numero,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isSelected) Color.White else Color(0xFF1C1B1F)
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Selecciona hora",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF6B6B6B)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    opcionesHora.forEach { option ->
                        val isSelected = (horaSeleccionada == option.textoCompleto)
                        Surface(
                            modifier = Modifier
                                .size(width = 80.dp, height = 44.dp)
                                .clickable { horaSeleccionada = option.textoCompleto },
                            shape = RoundedCornerShape(12.dp),
                            color = if (isSelected) MaterialTheme.colorScheme.primary else Color(0xFFEDE7F6)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text(
                                    text = option.horaCorta,
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isSelected) Color.White else Color(0xFF1C1B1F)
                                )
                            }
                        }
                    }
                }
            }

            Button(
                onClick = { onConfirmar(fechaSeleccionada, horaSeleccionada) },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
            ) {
                Text(
                    text = "Confirmar cita",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}
