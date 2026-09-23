package com.rojas.clinica.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rojas.clinica.data.Medico

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AgendarCitaScreen(
    medico: Medico?,
    onConfirmar: (String, String) -> Unit,
    onBack: () -> Unit
) {
    var fecha by remember { mutableStateOf("Viernes 27") }
    var hora by remember { mutableStateOf("10:30 am") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Agendar cita") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Atrás")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding).padding(16.dp).fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text("Selecciona fecha:", style = MaterialTheme.typography.titleMedium)
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.padding(vertical = 8.dp)) {
                    listOf("Jueves 26", "Viernes 27", "Sábado 28").forEach { f ->
                        FilterChip(selected = (fecha == f), onClick = { fecha = f }, label = { Text(f) })
                    }
                }
                Text("Selecciona hora:", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(top = 16.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.padding(vertical = 8.dp)) {
                    listOf("9:00 am", "10:30 am", "3:00 pm").forEach { h ->
                        FilterChip(selected = (hora == h), onClick = { hora = h }, label = { Text(h) })
                    }
                }
            }
            Button(
                onClick = { onConfirmar(fecha, hora) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Confirmar cita")
            }
        }
    }
}