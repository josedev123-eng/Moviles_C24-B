package com.tecsup.mibodega

data class Producto(
    val id: Int,
    val nombre: String,
    val descripcion: String,
    val precio: Double,
    val categoria: String
)

val listaCategorias = listOf("Todos", "Abarrotes", "Bebidas", "Lácteos", "Snacks", "Limpieza")

val listaProductos = listOf(
    Producto(1, "Arroz Costeño 1 kg", "Arroz extra de grano largo, ideal para el día a día.", 4.50, "Abarrotes"),
    Producto(2, "Aceite Primor 1 L", "Aceite vegetal alto en vitamina E.", 8.90, "Abarrotes"),
    Producto(3, "Azúcar rubia 1 kg", "Azúcar rubia de caña.", 3.80, "Abarrotes"),
    Producto(4, "Coca-Cola 1.5 L", "Bebida gaseosa sabor cola para compartir.", 6.50, "Bebidas"),
    Producto(5, "Agua San Luis 625 ml", "Agua de mesa sin gas.", 1.50, "Bebidas"),
    Producto(6, "Leche Gloria 400 g", "Leche evaporada entera.", 4.20, "Lácteos"),
    Producto(7, "Yogurt Laive 1 L", "Yogurt bebible sabor fresa.", 6.90, "Lácteos"),
    Producto(8, "Galleta Oreo", "Galletas de chocolate rellenas de crema.", 3.50, "Snacks"),
    Producto(9, "Papas Lay's clásicas", "Papas fritas clásicas 42 g.", 2.50, "Snacks"),
    Producto(10, "Detergente Bolívar 500 g", "Detergente en polvo para ropa.", 7.90, "Limpieza")
)