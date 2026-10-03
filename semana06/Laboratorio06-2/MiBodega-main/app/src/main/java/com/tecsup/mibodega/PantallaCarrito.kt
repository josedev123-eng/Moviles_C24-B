package com.tecsup.mibodega

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tecsup.mibodega.ui.theme.GrisTexto

/**
 * Pantalla 5: Mi carrito.
 * Por ahora solo muestra la barra inferior; los productos se agregan después.
 */
@Composable
fun PantallaCarrito(
    onIrInicio: () -> Unit,
    onSalir: () -> Unit
) {
    Scaffold(
        bottomBar = {
            BarraInferior(
                seleccionado = Rutas.CARRITO,
                onInicio = onIrInicio,
                onCarrito = { },
                onSalir = onSalir
            )
        }
    ) { paddingInterno ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingInterno),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = null,
                tint = GrisTexto,
                modifier = Modifier.size(72.dp)
            )
            Text("Mi carrito", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Text("Aún no hay productos", color = GrisTexto)
        }
    }
}