package com.rojas.clinica.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rojas.clinica.data.Medico

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerfilMedicoScreen(
    medico: Medico?,
    onAgendarClick: () -> Unit,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Perfil del médico") },
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
                Text(medico?.nombre ?: "", style = MaterialTheme.typography.headlineSmall)
                Text(medico?.especialidad ?: "", style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Calificación: ⭐ ${medico?.calificacion}")
            }
            Button(onClick = onAgendarClick, modifier = Modifier.fillMaxWidth()) {
                Text("Agendar cita")
            }
        }
    }
}