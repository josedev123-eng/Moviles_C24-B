package com.rojas.clinica.componets

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DrawerContent(
    onNavigate: (String) -> Unit
) {
    ModalDrawerSheet {
        Text("Clínica Salud+", style = MaterialTheme.typography.titleLarge, modifier = Modifier.padding(16.dp))
        HorizontalDivider()
        NavigationDrawerItem(
            icon = { Icon(Icons.Default.Home, contentDescription = null) },
            label = { Text("Inicio") },
            selected = false,
            onClick = { onNavigate("inicio") }
        )
        NavigationDrawerItem(
            icon = { Icon(Icons.Default.DateRange, contentDescription = null) },
            label = { Text("Mis citas") },
            selected = false,
            onClick = { onNavigate("mis_citas") }
        )
        NavigationDrawerItem(
            icon = { Icon(Icons.Default.List, contentDescription = null) },
            label = { Text("Historial médico") },
            selected = false,
            onClick = { onNavigate("historial") }
        )
    }
}