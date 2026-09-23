package com.rojas.clinica.screens

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

@Composable
fun ConfirmacionScreen(
    medicoNombre: String,
    fecha: String,
    hora: String,
    onVerMisCitas: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Surface(
            modifier = Modifier.size(80.dp),
            shape = CircleShape,
            color = Color(0xFFE3F4EA)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    tint = Color(0xFF2E9E5B),
                    modifier = Modifier.size(40.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "¡Cita agendada!",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1C1B1F)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = medicoNombre,
            style = MaterialTheme.typography.bodyLarge,
            color = Color(0xFF6B6B6B)
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "$fecha, $hora",
            style = MaterialTheme.typography.bodyMedium,
            color = Color(0xFF6B6B6B)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onVerMisCitas,
            modifier = Modifier
                .width(200.dp)
                .height(46.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFEEEEF2),
                contentColor = Color(0xFF1C1B1F)
            ),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp)
        ) {
            Text(
                text = "Ver mis citas",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
