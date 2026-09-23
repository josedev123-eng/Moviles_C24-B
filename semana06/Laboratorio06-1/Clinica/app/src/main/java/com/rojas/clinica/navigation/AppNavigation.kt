package com.rojas.clinica.navigation

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.rojas.clinica.data.Cita
import com.rojas.clinica.data.LocalDataSource
import com.rojas.clinica.components.DrawerContent
import com.rojas.clinica.screens.*
import kotlinx.coroutines.launch

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val listaCitas = remember { mutableStateListOf(*LocalDataSource.citasIniciales.toTypedArray()) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(
                onNavigate = { ruta ->
                    scope.launch { drawerState.close() }
                    navController.navigate(ruta) {
                        popUpTo("inicio") { if (ruta == "inicio") inclusive = true }
                    }
                }
            )
        }
    ) {
        NavHost(navController = navController, startDestination = "inicio") {
            composable("inicio") {
                InicioScreen(
                    medicos = LocalDataSource.medicosBase,
                    onOpenDrawer = { scope.launch { drawerState.open() } },
                    onMedicoClick = { id -> navController.navigate("perfil/$id") }
                )
            }

            composable("perfil/{id}") { backStack ->
                val id = backStack.arguments?.getString("id")
                val medico = LocalDataSource.medicosBase.find { it.id == id }
                PerfilMedicoScreen(
                    medico = medico,
                    onAgendarClick = { navController.navigate("agendar/${medico?.id}") },
                    onBack = { navController.popBackStack() }
                )
            }

            composable("agendar/{id}") { backStack ->
                val id = backStack.arguments?.getString("id")
                val medico = LocalDataSource.medicosBase.find { it.id == id }
                AgendarCitaScreen(
                    medico = medico,
                    onConfirmar = { fecha, hora ->
                        listaCitas.add(0, Cita(medicoNombre = medico?.nombre ?: "", especialidad = medico?.especialidad ?: "", fecha = fecha, hora = hora))
                        navController.navigate("confirmacion/${medico?.nombre}/$fecha/$hora")
                    },
                    onBack = { navController.popBackStack() }
                )
            }

            composable(
                "confirmacion/{medico}/{fecha}/{hora}",
                arguments = listOf(
                    navArgument("medico") { type = NavType.StringType },
                    navArgument("fecha") { type = NavType.StringType },
                    navArgument("hora") { type = NavType.StringType }
                )
            ) { backStack ->
                val medico = backStack.arguments?.getString("medico") ?: ""
                val fecha = backStack.arguments?.getString("fecha") ?: ""
                val hora = backStack.arguments?.getString("hora") ?: ""

                ConfirmacionScreen(
                    medicoNombre = medico,
                    fecha = fecha,
                    hora = hora,
                    onVerMisCitas = { navController.navigate("mis_citas") { popUpTo("inicio") } }
                )
            }

            composable("mis_citas") {
                MisCitasScreen(
                    citas = listaCitas,
                    onOpenDrawer = { scope.launch { drawerState.open() } }
                )
            }

            composable("historial") {
                HistorialMedicoScreen(onOpenDrawer = { scope.launch { drawerState.open() } })
            }
        }
    }
}