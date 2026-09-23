package com.rojas.tecsupfit.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rojas.tecsupfit.data.LocalDataSource
import com.rojas.tecsupfit.data.ReservaFit
import com.rojas.tecsupfit.ui.theme.VerdeTecsup

@Composable
fun MisClasesScreen() {
    val reservas = remember { mutableStateListOf<ReservaFit>().apply { addAll(LocalDataSource.misReservasIniciales) } }
    var reservaACancelar by remember { mutableStateOf<ReservaFit?>(null) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Mis clases", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(reservas) { reserva ->
                val isConfirmada = reserva.estado == "Confirmada"

                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFEEEEEE)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(modifier = Modifier.height(IntrinsicSize.Min)) {
                        Box(
                            modifier = Modifier
                                .width(6.dp)
                                .fillMaxHeight()
                                .background(if (isConfirmada) VerdeTecsup else Color.Transparent)
                        )
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(reserva.tituloClase, fontWeight = FontWeight.Bold)
                            Text(reserva.horario, color = Color.Gray, fontSize = 12.sp)
                            Spacer(modifier = Modifier.height(8.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Surface(
                                    shape = RoundedCornerShape(12.dp),
                                    color = if (isConfirmada) Color(0xFFDCEFE6) else Color(0xFFE0E0E0)
                                ) {
                                    Text(
                                        text = reserva.estado,
                                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                                        fontSize = 12.sp,
                                        color = if (isConfirmada) VerdeTecsup else Color.Gray
                                    )
                                }

                                if (isConfirmada) {
                                    TextButton(onClick = { reservaACancelar = reserva }) {
                                        Text("Cancelar", color = Color.Red, fontSize = 12.sp)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    reservaACancelar?.let { reserva ->
        AlertDialog(
            onDismissRequest = { reservaACancelar = null },
            title = { Text("Cancelar reserva") },
            text = { Text("¿Deseas cancelar tu reserva para '${reserva.tituloClase}'?") },
            confirmButton = {
                TextButton(onClick = {
                    val index = reservas.indexOfFirst { it.id == reserva.id }
                    if (index != -1) {
                        reservas[index] = reserva.copy(estado = "Cancelada")
                    }
                    reservaACancelar = null
                }) {
                    Text("Sí, cancelar", color = Color.Red)
                }
            },
            dismissButton = {
                TextButton(onClick = { reservaACancelar = null }) { Text("Volver") }
            }
        )
    }
}