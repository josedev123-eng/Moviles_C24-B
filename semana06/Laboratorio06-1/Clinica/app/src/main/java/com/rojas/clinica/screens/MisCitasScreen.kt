package com.rojas.clinica.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rojas.clinica.data.Cita
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MisCitasScreen(
    citas: List<Cita>,
    onOpenDrawer: () -> Unit,
    onCancelar: (Cita) -> Unit
) {
    var citaACancelar by remember { mutableStateOf<Cita?>(null) }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Mis citas",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1C1B1F)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onOpenDrawer) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menú",
                            tint = Color(0xFF1C1B1F)
                        )
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(citas) { cita ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFF3EFF8)
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(IntrinsicSize.Min)
                    ) {
                        if (cita.estado == "Confirmada") {
                            Box(
                                modifier = Modifier
                                    .width(4.dp)
                                    .fillMaxHeight()
                                    .background(MaterialTheme.colorScheme.primary)
                            )
                        }
                        Column(
                            modifier = Modifier
                                .padding(16.dp)
                                .weight(1f)
                        ) {
                            Text(
                                text = cita.medicoNombre,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF1C1B1F),
                                style = MaterialTheme.typography.titleMedium
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = "${cita.fecha}, ${cita.hora}",
                                color = Color(0xFF6B6B6B),
                                style = MaterialTheme.typography.bodyMedium
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                val (bgColor, textColor) = when (cita.estado) {
                                    "Confirmada" -> Pair(Color(0xFFDFF5E6), Color(0xFF2E9E5B))
                                    "Completada" -> Pair(Color(0xFFEEEEEE), Color(0xFF6B6B6B))
                                    "Cancelada" -> Pair(Color(0xFFFDE7E9), Color(0xFFC62828))
                                    else -> Pair(Color(0xFFEEEEEE), Color(0xFF6B6B6B))
                                }

                                Surface(
                                    shape = RoundedCornerShape(50),
                                    color = bgColor
                                ) {
                                    Text(
                                        text = cita.estado,
                                        color = textColor,
                                        style = MaterialTheme.typography.labelMedium,
                                        fontWeight = FontWeight.SemiBold,
                                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
                                    )
                                }

                                if (cita.estado == "Confirmada") {
                                    TextButton(
                                        onClick = { citaACancelar = cita },
                                        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 0.dp)
                                    ) {
                                        Text(
                                            text = "Cancelar",
                                            color = Color(0xFFC62828),
                                            fontWeight = FontWeight.Bold,
                                            style = MaterialTheme.typography.bodyMedium
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (citaACancelar != null) {
            val cita = citaACancelar!!
            AlertDialog(
                onDismissRequest = { citaACancelar = null },
                title = {
                    Text(
                        text = "Cancelar cita",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1C1B1F)
                    )
                },
                text = {
                    Text(
                        text = "¿Seguro que deseas cancelar tu cita con ${cita.medicoNombre} el ${cita.fecha} a las ${cita.hora}?",
                        color = Color(0xFF1C1B1F)
                    )
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            onCancelar(cita)
                            citaACancelar = null
                            scope.launch {
                                snackbarHostState.showSnackbar("Cita con ${cita.medicoNombre} cancelada")
                            }
                        }
                    ) {
                        Text(
                            text = "Sí, cancelar",
                            color = Color(0xFFC62828),
                            fontWeight = FontWeight.Bold
                        )
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = { citaACancelar = null }
                    ) {
                        Text(
                            text = "No",
                            color = Color(0xFF1C1B1F)
                        )
                    }
                },
                containerColor = Color.White
            )
        }
    }
}
