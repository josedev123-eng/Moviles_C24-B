package com.rojas.tecsupfit.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.navigation.NavController
import com.rojas.tecsupfit.data.LocalDataSource
import com.rojas.tecsupfit.ui.theme.VerdeTecsup

@Composable
fun InicioScreen(navController: NavController) {
    var filtro by remember { mutableStateOf("Hoy") }

    Column(modifier = Modifier.fillMaxSize().background(Color(0xFFF7F9F8))) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(VerdeTecsup)
                .padding(20.dp)
        ) {
            Column {
                Text("TECSUP Fit", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text("Hola, Diego", color = Color.White.copy(alpha = 0.8f), fontSize = 14.sp)
            }
        }

        Column(modifier = Modifier.padding(16.dp)) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                listOf("Hoy", "Esta semana").forEach { f ->
                    FilterChip(
                        selected = filtro == f,
                        onClick = { filtro = f },
                        label = { Text(f) },
                        shape = RoundedCornerShape(20.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text("Clases disponibles", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(12.dp))

            LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                items(LocalDataSource.listaClases) { clase ->
                    Card(
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFEEEEEE)),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { navController.navigate("agendar_cita/${clase.id}") }
                    ) {
                        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .background(Color(0xFFDCEFE6), RoundedCornerShape(8.dp)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("🏋️")
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text(clase.titulo, fontWeight = FontWeight.Bold)
                                Text("${clase.horario} · ${clase.sala}", color = Color.Gray, fontSize = 12.sp)
                            }
                        }
                    }
                }
            }
        }
    }
}