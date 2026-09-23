package com.rojas.tecsupfit.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.rojas.tecsupfit.data.LocalDataSource
import com.rojas.tecsupfit.data.ReservaFit
import com.rojas.tecsupfit.ui.theme.VerdeTecsup

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AgendarClasesScreen(navController: NavController, claseId: Int, listaReservas: MutableList<ReservaFit>) {
    val clase = LocalDataSource.listaClases.find { it.id == claseId } ?: LocalDataSource.listaClases[0]
    var horarioSeleccionado by remember { mutableStateOf(clase.horario) }
    val horarios = listOf(clase.horario, "6:00 pm", "7:00 pm")

    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                title = { Text("Detalle de clase", color = Color(0xFF1C1B1F), fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Atrás", tint = Color(0xFF1C1B1F))
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(140.dp)
                        .background(Color(0xFFDCEFE6), RoundedCornerShape(16.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.FitnessCenter,
                        contentDescription = null,
                        tint = VerdeTecsup,
                        modifier = Modifier.size(64.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = clase.titulo,
                    color = Color(0xFF1C1B1F),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${clase.horario} · ${clase.sala} · ${clase.duracion}",
                    color = Color(0xFF6B6B6B),
                    fontSize = 13.sp
                )

                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = clase.descripcion,
                    color = Color(0xFF1C1B1F),
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "${clase.cuposDisponibles} de ${clase.cuposTotales} cupos disponibles",
                    color = Color(0xFF6B6B6B),
                    fontSize = 13.sp
                )

                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Elige tu horario",
                    color = Color(0xFF1C1B1F),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(10.dp))

                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    horarios.forEach { h ->
                        val seleccionado = horarioSeleccionado == h
                        Box(
                            modifier = Modifier
                                .width(90.dp)
                                .height(44.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(if (seleccionado) VerdeTecsup else Color(0xFFEEEEEE))
                                .clickable { horarioSeleccionado = h },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = h,
                                color = if (seleccionado) Color.White else Color(0xFF1C1B1F),
                                fontWeight = if (seleccionado) FontWeight.Bold else FontWeight.Normal,
                                fontSize = 14.sp
                            )
                        }
                    }
                }
            }

            Button(
                onClick = {
                    listaReservas.add(
                        ReservaFit(
                            id = (listaReservas.maxOfOrNull { it.id } ?: 0) + 1,
                            tituloClase = clase.titulo,
                            horario = "Hoy, $horarioSeleccionado",
                            estado = "Confirmada"
                        )
                    )
                    navController.navigate("confirmacion/${clase.id}/$horarioSeleccionado")
                },
                colors = ButtonDefaults.buttonColors(containerColor = VerdeTecsup),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
            ) {
                Text("Reservar cupo", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}
