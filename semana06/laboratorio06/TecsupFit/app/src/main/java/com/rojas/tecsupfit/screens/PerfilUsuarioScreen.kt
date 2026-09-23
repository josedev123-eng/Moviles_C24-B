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
import com.rojas.tecsupfit.ui.theme.VerdeTecsup

@Composable
fun PerfilUsuarioScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Mi perfil",
                color = Color(0xFF1C1B1F),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color(0xFFDCEFE6), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text("DR", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = VerdeTecsup)
        }

        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Jose Rojas",
            color = Color(0xFF1C1B1F),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Plan Premium",
            color = Color(0xFF6B6B6B),
            fontSize = 12.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFEEEEEE)),
                modifier = Modifier.weight(1f)
            ) {
                Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "14",
                        color = Color(0xFF1C1B1F),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text("Clases", color = Color(0xFF6B6B6B), fontSize = 12.sp)
                }
            }
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFEEEEEE)),
                modifier = Modifier.weight(1f)
            ) {
                Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "3",
                        color = Color(0xFF1C1B1F),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text("Rachas", color = Color(0xFF6B6B6B), fontSize = 12.sp)
                }
            }
        }
    }
}
