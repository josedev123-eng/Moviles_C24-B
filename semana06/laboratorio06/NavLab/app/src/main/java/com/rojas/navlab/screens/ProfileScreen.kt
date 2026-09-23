package com.rojas.navlab.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.rojas.navlab.R
import com.rojas.navlab.navigation.Screen
import com.rojas.navlab.ui.components.ProfileRow
import com.rojas.navlab.ui.components.StudentAvatar
import com.rojas.navlab.ui.theme.LogoutBg
import com.rojas.navlab.ui.theme.LogoutRed
import com.rojas.navlab.ui.theme.Mauve
import com.rojas.navlab.ui.theme.Purple
import com.rojas.navlab.ui.theme.SurfaceWhite
import com.rojas.navlab.ui.theme.TextDark

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {
    Scaffold(
        containerColor = SurfaceWhite,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Configuración de Perfil",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextDark
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver",
                            tint = TextDark
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = SurfaceWhite
                )
            )
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .navigationBarsPadding()
                    .padding(start = 20.dp, end = 20.dp, top = 8.dp, bottom = 16.dp)
            ) {
                Button(
                    onClick = {
                        navController.navigate(Screen.Login.route) {
                            popUpTo(0) { inclusive = true }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(44.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = LogoutBg.copy(alpha = 0.8f),
                        contentColor = LogoutRed
                    ),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 0.dp,
                        pressedElevation = 0.dp,
                        focusedElevation = 0.dp,
                        hoveredElevation = 0.dp
                    )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.Logout,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Cerrar Sesión",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(Purple, Mauve)
                        )
                    )
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    StudentAvatar(
                        res = R.drawable.avatar_juan,
                        size = 96.dp,
                        borderWidth = 3.dp
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Juan León Suiyon",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                Text(
                    text = "INFORMACIÓN PERSONAL",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Purple,
                    letterSpacing = 1.sp,
                    modifier = Modifier.padding(top = 24.dp, bottom = 12.dp)
                )

                ProfileRow(
                    icon = Icons.Filled.Person,
                    label = "Nombre Completo",
                    value = "Jose Rojas Condor"
                )

                Spacer(modifier = Modifier.height(16.dp))

                ProfileRow(
                    icon = Icons.Filled.Email,
                    label = "Correo",
                    value = "jose.rojas@tecsup.edu.pe"
                )

                Spacer(modifier = Modifier.height(16.dp))

                ProfileRow(
                    icon = Icons.Filled.Phone,
                    label = "Teléfono",
                    value = "+51 987 654 321"
                )

                Text(
                    text = "ACADÉMICO",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Purple,
                    letterSpacing = 1.sp,
                    modifier = Modifier.padding(top = 24.dp, bottom = 12.dp)
                )

                ProfileRow(
                    icon = Icons.Filled.School,
                    label = "Carrera",
                    value = "Ingeniería de Software"
                )

                Spacer(modifier = Modifier.height(16.dp))

                ProfileRow(
                    icon = Icons.Filled.CalendarMonth,
                    label = "Ciclo Actual",
                    value = "VI Ciclo"
                )

                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(rememberNavController())
}
