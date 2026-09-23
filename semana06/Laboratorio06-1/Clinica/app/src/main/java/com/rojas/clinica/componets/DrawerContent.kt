package com.rojas.clinica.componets

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.RadioButtonUnchecked
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

data class DrawerMenuItem(
    val label: String,
    val route: String
)

@Composable
fun DrawerContent(
    rutaActual: String?,
    onNavigate: (String) -> Unit
) {
    val opciones = listOf(
        DrawerMenuItem("Inicio", "inicio"),
        DrawerMenuItem("Mis citas", "mis_citas"),
        DrawerMenuItem("Historial médico", "historial"),
        DrawerMenuItem("Perfil", "perfil_usuario")
    )

    ModalDrawerSheet(
        drawerContainerColor = Color.White
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(44.dp),
                shape = CircleShape,
                color = Color(0xFFEDE7F6)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = "JR",
                        color = Color(0xFF5B2A86),
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = "José Rojas",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1C1B1F),
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Paciente",
                    color = Color(0xFF6B6B6B),
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }

        HorizontalDivider()

        Spacer(modifier = Modifier.height(8.dp))

        opciones.forEach { opcion ->
            val selected = (rutaActual == opcion.route)
            NavigationDrawerItem(
                icon = {
                    Icon(
                        imageVector = Icons.Outlined.RadioButtonUnchecked,
                        contentDescription = null,
                        tint = if (selected) Color(0xFF5B2A86) else Color(0xFF1C1B1F)
                    )
                },
                label = {
                    Text(
                        text = opcion.label,
                        fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal,
                        color = if (selected) Color(0xFF5B2A86) else Color(0xFF1C1B1F)
                    )
                },
                selected = selected,
                onClick = { onNavigate(opcion.route) },
                colors = NavigationDrawerItemDefaults.colors(
                    selectedContainerColor = Color(0xFFEDE7F6),
                    selectedIconColor = Color(0xFF5B2A86),
                    selectedTextColor = Color(0xFF5B2A86),
                    unselectedContainerColor = Color.Transparent,
                    unselectedIconColor = Color(0xFF1C1B1F),
                    unselectedTextColor = Color(0xFF1C1B1F)
                ),
                modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
            )
        }
    }
}
