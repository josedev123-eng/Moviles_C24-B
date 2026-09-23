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
import androidx.navigation.NavController
import com.rojas.tecsupfit.data.LocalDataSource

@Composable
fun ConfirmacionScreen(navController: NavController, claseId: Int) {
    val clase = LocalDataSource.listaClases.find { it.id == claseId } ?: LocalDataSource.listaClases[0]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color(0xFFDCEFE6), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text("✓", fontSize = 36.sp, color = Color(0xFF0D634C), fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(20.dp))
        Text("¡Cupo reservado!", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text(clase.titulo, color = Color.Gray, fontSize = 14.sp)
        Text("Hoy, ${clase.horario} · ${clase.sala}", color = Color.Gray, fontSize = 12.sp)

        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = { navController.navigate("mis_citas") { popUpTo("inicio") } },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEEEEEE)),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text("Ver mis reservas", color = Color.Black)
        }
    }
}