package com.rojas.tecsupfit.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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
fun AgendarClasesScreen(navController: NavController, claseId: Int) {
    val clase = LocalDataSource.listaClases.find { it.id == claseId } ?: LocalDataSource.listaClases[0]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = "← Detalle de clase",
                color = Color(0xFF1C1B1F),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.clickable { navController.popBackStack() }
            )
            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(Color(0xFFDCEFE6), RoundedCornerShape(16.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text("🏋️", fontSize = 40.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = clase.titulo,
                color = Color(0xFF1C1B1F),
                fontSize = 20.sp,
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

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "${clase.cuposDisponibles} de ${clase.cuposTotales} cupos disponibles",
                color = Color(0xFF6B6B6B),
                fontSize = 13.sp
            )
        }

        Button(
            onClick = { navController.navigate("confirmacion/${clase.id}") },
            colors = ButtonDefaults.buttonColors(containerColor = VerdeTecsup),
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Reservar cupo", color = Color.White, fontSize = 16.sp)
        }
    }
}
