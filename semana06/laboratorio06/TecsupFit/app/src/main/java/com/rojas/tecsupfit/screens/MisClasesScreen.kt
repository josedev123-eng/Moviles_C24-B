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
import com.rojas.tecsupfit.data.ReservaFit
import com.rojas.tecsupfit.ui.theme.VerdeTecsup

@Composable
fun MisClasesScreen(reservas: List<ReservaFit>, onCancelar: (ReservaFit) -> Unit) {
    var reservaACancelar by remember { mutableStateOf<ReservaFit?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Text(
            text = "Mis clases",
            color = Color(0xFF1C1B1F),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
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
                            Text(
                                text = reserva.tituloClase,
                                color = Color(0xFF1C1B1F),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = reserva.horario,
                                color = Color(0xFF6B6B6B),
                                fontSize = 12.sp
                            )
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
                                        color = if (isConfirmada) VerdeTecsup else Color(0xFF6B6B6B)
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
            title = { Text("Cancelar reserva", color = Color(0xFF1C1B1F), fontWeight = FontWeight.Bold) },
            text = { Text("¿Deseas cancelar tu reserva para '${reserva.tituloClase}'?", color = Color(0xFF1C1B1F)) },
            confirmButton = {
                TextButton(onClick = {
                    onCancelar(reserva)
                    reservaACancelar = null
                }) {
                    Text("Sí, cancelar", color = Color.Red)
                }
            },
            dismissButton = {
                TextButton(onClick = { reservaACancelar = null }) { Text("Volver", color = Color(0xFF1C1B1F)) }
            }
        )
    }
}
