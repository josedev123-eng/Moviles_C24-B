package com.rojas.navlab.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.rojas.navlab.data.StudentRepository
import com.rojas.navlab.ui.components.InfoRow
import com.rojas.navlab.ui.components.StudentAvatar
import com.rojas.navlab.ui.theme.CardGray
import com.rojas.navlab.ui.theme.Purple
import com.rojas.navlab.ui.theme.PurpleDark
import com.rojas.navlab.ui.theme.SurfaceWhite
import com.rojas.navlab.ui.theme.TextDark
import com.rojas.navlab.ui.theme.TextGray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavController, itemId: Int) {
    val student = StudentRepository.getById(itemId)

    Scaffold(
        containerColor = SurfaceWhite,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Expediente Académico",
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
                    .height(230.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(Purple, PurpleDark)
                            ),
                            shape = RoundedCornerShape(
                                bottomStart = 28.dp,
                                bottomEnd = 28.dp
                            )
                        )
                )

                StudentAvatar(
                    res = student.avatar,
                    size = 130.dp,
                    borderWidth = 4.dp,
                    modifier = Modifier.align(Alignment.BottomCenter)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = student.name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = TextDark,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = student.career,
                fontSize = 14.sp,
                color = Purple,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(
                    containerColor = CardGray.copy(alpha = 0.6f)
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    InfoRow(
                        icon = Icons.Filled.Badge,
                        label = "ID Estudiante",
                        value = student.code
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    InfoRow(
                        icon = Icons.Filled.Email,
                        label = "Correo Electrónico",
                        value = student.email
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    InfoRow(
                        icon = Icons.Filled.School,
                        label = "Facultad",
                        value = student.faculty
                    )

                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = 16.dp),
                        color = Color(0xFFCAC4D0)
                    )

                    Text(
                        text = "Biografía",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextDark
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = student.bio,
                        fontSize = 13.sp,
                        color = TextGray,
                        lineHeight = 18.sp,
                        textAlign = TextAlign.Justify
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailScreenPreview() {
    DetailScreen(rememberNavController(), itemId = 1)
}
