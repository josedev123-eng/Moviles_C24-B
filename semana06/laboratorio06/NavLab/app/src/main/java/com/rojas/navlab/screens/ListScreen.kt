package com.rojas.navlab.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.rojas.navlab.data.StudentRepository
import com.rojas.navlab.navigation.Screen
import com.rojas.navlab.ui.components.StudentCard
import com.rojas.navlab.ui.theme.LavenderTop
import com.rojas.navlab.ui.theme.SurfaceWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(navController: NavController) {
    val students = StudentRepository.students

    Scaffold(
        containerColor = SurfaceWhite,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Directorio de Alumnos",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF21005D)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver",
                            tint = Color(0xFF21005D)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = LavenderTop
                )
            )
        }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = PaddingValues(
                start = 16.dp,
                end = 16.dp,
                top = innerPadding.calculateTopPadding() + 12.dp,
                bottom = innerPadding.calculateBottomPadding() + 12.dp
            ),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(students) { student ->
                StudentCard(
                    student = student,
                    onClick = {
                        navController.navigate(Screen.Detail.createRoute(student.id))
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ListScreenPreview() {
    ListScreen(rememberNavController())
}
