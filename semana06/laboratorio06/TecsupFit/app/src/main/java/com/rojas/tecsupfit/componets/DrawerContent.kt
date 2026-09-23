package com.rojas.tecsupfit.componets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DrawerContent(onDestinationClick: (String) -> Unit) {
    ModalDrawerSheet {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .background(Color(0xFF0D634C))
                .padding(16.dp)
        ) {
            Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Bottom) {
                Text("TECSUP Fit", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text("Menú de Navegación", color = Color.White.copy(alpha = 0.8f), fontSize = 14.sp)
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        NavigationDrawerItem(
            label = { Text("Inicio") },
            selected = false,
            onClick = { onDestinationClick("inicio") }
        )
        NavigationDrawerItem(
            label = { Text("Mis Reservas") },
            selected = false,
            onClick = { onDestinationClick("mis_citas") }
        )
        NavigationDrawerItem(
            label = { Text("Rutinas") },
            selected = false,
            onClick = { onDestinationClick("historial") }
        )
        NavigationDrawerItem(
            label = { Text("Mi Perfil") },
            selected = false,
            onClick = { onDestinationClick("perfil_usuario") }
        )
    }
}