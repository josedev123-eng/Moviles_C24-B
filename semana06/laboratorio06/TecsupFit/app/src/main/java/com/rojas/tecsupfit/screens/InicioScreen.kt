package com.rojas.tecsupfit.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
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
import com.rojas.tecsupfit.ui.theme.VerdeTecsup

@Composable
fun InicioScreen(navController: NavController) {
    var filtro by remember { mutableStateOf("Hoy") }

    val clasesFiltradas = if (filtro == "Hoy") {
        LocalDataSource.listaClases.filter { it.dia == "Hoy" }
    } else {
        LocalDataSource.listaClases
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(VerdeTecsup)
                .statusBarsPadding()
                .padding(20.dp)
        ) {
            Column {
                Text("TECSUP Fit", color = Color.White, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(2.dp))
                Text("Hola, José", color = Color.White, fontSize = 14.sp)
            }
        }

        Column(modifier = Modifier.padding(16.dp)) {
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                val opciones = listOf("Hoy", "Esta semana")
                items(opciones) { opcion ->
                    val seleccionado = filtro == opcion
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(50))
                            .background(if (seleccionado) VerdeTecsup else Color(0xFFEEEEEE))
                            .clickable { filtro = opcion }
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = opcion,
                            color = if (seleccionado) Color.White else Color(0xFF1C1B1F),
                            fontWeight = if (seleccionado) FontWeight.Bold else FontWeight.Normal
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Clases disponibles",
                color = Color(0xFF1C1B1F),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(12.dp))

            LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                items(clasesFiltradas) { clase ->
                    Card(
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFF1F1F1)),
                        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { navController.navigate("agendar_cita/${clase.id}") }
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(44.dp)
                                    .background(Color(0xFFDCEFE6), RoundedCornerShape(10.dp)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.FitnessCenter,
                                    contentDescription = null,
                                    tint = VerdeTecsup,
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text(
                                    text = clase.titulo,
                                    color = Color(0xFF1C1B1F),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                )
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = "${clase.horario} · ${clase.sala}",
                                    color = Color(0xFF6B6B6B),
                                    fontSize = 12.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
