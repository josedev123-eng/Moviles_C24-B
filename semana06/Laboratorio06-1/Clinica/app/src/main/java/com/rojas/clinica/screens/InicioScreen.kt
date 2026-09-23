package com.rojas.clinica.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rojas.clinica.data.Medico

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InicioScreen(
    medicos: List<Medico>,
    onOpenDrawer: () -> Unit,
    onMedicoClick: (String) -> Unit
) {
    var especialidadSeleccionada by remember { mutableStateOf("Todas") }
    val especialidades = listOf("Todas", "Cardiología", "Pediatría", "Dermatología")

    val medicosFiltrados = if (especialidadSeleccionada == "Todas") {
        medicos
    } else {
        medicos.filter { it.especialidad == especialidadSeleccionada }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Clínica Salud+") },
                navigationIcon = {
                    IconButton(onClick = onOpenDrawer) {
                        Icon(Icons.Default.Menu, contentDescription = "Menú")
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            Text("Especialidades", style = MaterialTheme.typography.titleMedium)
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.padding(vertical = 8.dp)) {
                items(especialidades) { esp ->
                    FilterChip(
                        selected = (especialidadSeleccionada == esp),
                        onClick = { especialidadSeleccionada = esp },
                        label = { Text(esp) }
                    )
                }
            }
            Text("Médicos disponibles", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(top = 16.dp))
            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.padding(top = 8.dp)) {
                items(medicosFiltrados) { medico ->
                    Card(
                        modifier = Modifier.fillMaxWidth().clickable { onMedicoClick(medico.id) }
                    ) {
                        Row(modifier = Modifier.padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                            Column {
                                Text(medico.nombre, style = MaterialTheme.typography.titleSmall)
                                Text(medico.especialidad, style = MaterialTheme.typography.bodySmall)
                            }
                            Text("⭐ ${medico.calificacion}")
                        }
                    }
                }
            }
        }
    }
}