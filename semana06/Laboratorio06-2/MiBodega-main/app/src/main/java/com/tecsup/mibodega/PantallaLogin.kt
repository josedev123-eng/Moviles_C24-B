package com.tecsup.mibodega

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tecsup.mibodega.ui.theme.AzulEnlace
import com.tecsup.mibodega.ui.theme.GrisTexto
import com.tecsup.mibodega.ui.theme.VerdeBodega

/**
 * Pantalla 1: Login.
 * Solo valida que los campos no estén vacíos (no hay base de datos todavía).
 * No navega sola: avisa a AppNavegacion con onIngresar / onCrearCuenta.
 */
@Composable
fun PantallaLogin(
    onIngresar: () -> Unit,
    onCrearCuenta: () -> Unit
) {
    val context = LocalContext.current
    var telefono by remember { mutableStateOf("") }
    var clave by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        Image(
            painter = painterResource(R.drawable.ilustracion_bodega),
            contentDescription = "Mi Bodega",
            modifier = Modifier.size(170.dp)
        )

        Text(
            text = "Mi Bodega",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = VerdeBodega
        )
        Text(
            text = "Tus productos de siempre en la puerta de tu casa",
            color = GrisTexto,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = telefono,
            onValueChange = { telefono = it },
            label = { Text("Teléfono") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = clave,
            onValueChange = { clave = it },
            label = { Text("Contraseña") },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                if (telefono.isBlank() || clave.isBlank()) {
                    Toast.makeText(context, "Ingresa tu teléfono y contraseña", Toast.LENGTH_SHORT).show()
                } else {
                    onIngresar()
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = VerdeBodega),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Iniciar sesión", fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(8.dp))

        TextButton(onClick = onCrearCuenta) {
            Text("¿No tienes cuenta? Crear cuenta", color = AzulEnlace)
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}