package com.rojas.tecsupfit.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
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
fun ConfirmacionScreen(navController: NavController, claseId: Int, horarioElegido: String) {
    val clase = LocalDataSource.listaClases.find { it.id == claseId } ?: LocalDataSource.listaClases[0]

    Scaffold(
        containerColor = Color.White
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
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
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = null,
                    tint = VerdeTecsup,
                    modifier = Modifier.size(40.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "¡Cupo reservado!",
                color = Color(0xFF1C1B1F),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = clase.titulo,
                color = Color(0xFF6B6B6B),
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Hoy, $horarioElegido · ${clase.sala}",
                color = Color(0xFF6B6B6B),
                fontSize = 12.sp
            )

            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = { navController.navigate("mis_citas") { popUpTo("inicio") } },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEEEEEE)),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .width(200.dp)
                    .height(46.dp)
            ) {
                Text("Ver mis reservas", color = Color(0xFF1C1B1F), fontWeight = FontWeight.Bold)
            }
        }
    }
}
