package com.rojas.tecsupfit.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rojas.tecsupfit.data.ReservaFit
import com.rojas.tecsupfit.ui.theme.VerdeTecsup

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerfilUsuarioScreen(reservas: List<ReservaFit>) {
    val totalCompletadas = reservas.count { it.estado == "Completada" } + 12
    val totalActivas = reservas.count { it.estado == "Confirmada" }

    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                title = { Text("Mi perfil", color = Color(0xFF1C1B1F), fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .size(88.dp)
                    .background(Color(0xFFDCEFE6), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "JR",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = VerdeTecsup
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "José Rojas Condor",
                color = Color(0xFF1C1B1F),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Plan Premium",
                color = Color(0xFF6B6B6B),
                fontSize = 12.sp
            )

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFF1F1F1)),
                    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = totalCompletadas.toString(),
                            color = Color(0xFF1C1B1F),
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "Clases",
                            color = Color(0xFF6B6B6B),
                            fontSize = 12.sp
                        )
                    }
                }
                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFF1F1F1)),
                    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = totalActivas.toString(),
                            color = Color(0xFF1C1B1F),
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "Reservas activas",
                            color = Color(0xFF6B6B6B),
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}
