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
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MisClasesScreen(reservas: List<ReservaFit>, onCancelar: (ReservaFit) -> Unit) {
    var reservaACancelar by remember { mutableStateOf<ReservaFit?>(null) }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                title = { Text("Mis reservas", color = Color(0xFF1C1B1F), fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(reservas) { reserva ->
                    val isConfirmada = reserva.estado == "Confirmada"
                    val isCompletada = reserva.estado == "Completada"

                    val (bgColor, textColor) = when {
                        isConfirmada -> Color(0xFFDCEFE6) to VerdeTecsup
                        isCompletada -> Color(0xFFE0E0E0) to Color(0xFF6B6B6B)
                        else -> Color(0xFFFDE7E9) to Color(0xFFC62828)
                    }

                    Card(
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFF1F1F1)),
                        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(modifier = Modifier.height(IntrinsicSize.Min)) {
                            if (isConfirmada) {
                                Box(
                                    modifier = Modifier
                                        .width(4.dp)
                                        .fillMaxHeight()
                                        .background(VerdeTecsup)
                                )
                            }
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
                                        color = bgColor
                                    ) {
                                        Text(
                                            text = reserva.estado,
                                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                                            fontSize = 12.sp,
                                            color = textColor,
                                            fontWeight = FontWeight.Medium
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
    }

    reservaACancelar?.let { reserva ->
        AlertDialog(
            onDismissRequest = { reservaACancelar = null },
            title = { Text("Cancelar reserva", color = Color(0xFF1C1B1F), fontWeight = FontWeight.Bold) },
            text = { Text("¿Deseas cancelar tu reserva para '${reserva.tituloClase}'?", color = Color(0xFF1C1B1F)) },
            confirmButton = {
                TextButton(onClick = {
                    val reservaAnterior = reserva
                    onCancelar(reserva.copy(estado = "Cancelada"))
                    reservaACancelar = null
                    scope.launch {
                        val result = snackbarHostState.showSnackbar(
                            message = "Reserva de ${reserva.tituloClase} cancelada",
                            actionLabel = "Deshacer"
                        )
                        if (result == SnackbarResult.ActionPerformed) {
                            onCancelar(reservaAnterior.copy(estado = "Confirmada"))
                        }
                    }
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
