# NavLab – Rediseño con IA (Gemini)

Aplicación Android del curso de Programación Móviles – TECSUP, rediseñada con **Gemini en Android Studio**. Incluye inicio de sesión, pantalla de bienvenida, directorio de alumnos, expediente académico y configuración de perfil.

**Alumno:** José Rojas Condor

## Capturas

<p align="center">
  <img width="720" height="1523" alt="image" src="https://github.com/user-attachments/assets/c41f6392-b3d8-4834-8a07-4605453fcbf5" />
  <img width="720" height="1540" alt="image" src="https://github.com/user-attachments/assets/fb36ccd5-f6d5-4aab-a646-8b168c5902e2" />
  <img width="720" height="1520" alt="image" src="https://github.com/user-attachments/assets/c24cc7f5-e683-41f2-b815-574765a72e10" />
  <img width="720" height="1522" alt="image" src="https://github.com/user-attachments/assets/b473b89a-dcbc-4840-8a61-edf620eff206" />
  <img width="720" height="1502" alt="image" src="https://github.com/user-attachments/assets/8ae7c66a-5cc9-4ffe-aec8-4fcd6e6e687f" />
</p>

## Prompt utilizado

Actúa como un desarrollador Android senior experto en Jetpack Compose y Material 3. Tienes que rediseñar la interfaz de mi proyecto **NavLab** para que quede **visualmente idéntica** a la referencia que te describo abajo. Esta especificación es exacta: respeta colores, tamaños, espaciados, radios de esquina, jerarquía de textos y la posición de cada elemento.

---

## 1. Contexto del proyecto (NO romper)

- Paquete: `com.rojas.navlab`
- Lenguaje: Kotlin + Jetpack Compose + Material 3. minSdk 24.
- Ya existe una navegación funcional con `navigation-compose:2.7.7`:
  - `navigation/Screen.kt` → `sealed class Screen(val route: String)` con `Home`, `List`, `Profile` y `Detail("detail/{itemId}")`, que tiene `createRoute(itemId: Int)`.
  - `navigation/AppNavigation.kt` → `rememberNavController()` + `NavHost`, con el argumento `itemId` de tipo `NavType.IntType`.
  - `screens/HomeScreen.kt`, `ListScreen.kt`, `DetailScreen.kt`, `ProfileScreen.kt`.
  - `MainActivity.kt` llama a `AppNavigation()` dentro de `setContent` con `enableEdgeToEdge()`.
- **Datos personales:** el usuario de la app soy yo, **José Rojas Condor**. Donde la referencia muestre "Juan León" o "Juan León Suiyon" (saludo de bienvenida, primer alumno del directorio, expediente y configuración de perfil), usa mis datos: nombre "José Rojas Condor", correo "jose.rojas@tecsup.edu.pe" y carrera "Diseño y Desarrollo de Software". No debe quedar ningún texto con "Juan León" en la app.
- **Mantén esta arquitectura**: la sealed class, el NavHost, la carpeta `screens` y las firmas `XxxScreen(navController: NavController, ...)`. Solo agrega lo necesario.

## 2. Cambios de navegación

Agrega una pantalla de login y cambia el contenido de las demás según esta tabla:

| Ruta | Pantalla | Nuevo contenido |
|---|---|---|
| `login` (NUEVA, `startDestination`) | `LoginScreen.kt` | Portal Académico (inicio de sesión) |
| `home` | `HomeScreen.kt` | Bienvenida con menú de opciones |
| `list` | `ListScreen.kt` | Directorio de Alumnos |
| `detail/{itemId}` | `DetailScreen.kt` | Expediente Académico del alumno seleccionado |
| `profile` | `ProfileScreen.kt` | Configuración de Perfil |

Flujos:
- Login → botón **INICIAR SESIÓN** → `home`, con `popUpTo(Screen.Login.route) { inclusive = true }`.
- Home → tarjeta **Directorio de Alumnos** → `list`.
- Home → tarjeta **Mi Perfil Académico** → `profile`.
- List → tocar un alumno → `Screen.Detail.createRoute(alumno.id)`.
- Detail y Profile → flecha ← de la TopAppBar → `popBackStack()`.
- Home **Cerrar Sesión Segura** y Profile **Cerrar Sesión** → navegan a `login` y limpian todo el back stack (`popUpTo(0) { inclusive = true }`).

## 3. Datos

Crea `model/Student.kt`:

```kotlin
data class Student(
    val id: Int,
    val name: String,
    val career: String,
    val code: String,
    val email: String,
    val faculty: String,
    val bio: String,
    @DrawableRes val avatar: Int
)
```

Crea también un objeto `StudentRepository` con una lista fija de 5 alumnos y una función `getById(id: Int)`:

1. José Rojas Condor — Diseño y Desarrollo de Software — 2024-0001 — jose.rojas@tecsup.edu.pe — Tecnología Digital — "Estudiante de Diseño y Desarrollo de Software con interés en desarrollo Android."
2. Maria Garcia — Arquitectura
3. Carlos Perez — Medicina
4. Ana Lopez — Derecho
5. Luis Ramirez — Administración

Para los alumnos 2 a 5, genera código, correo, facultad y biografía coherentes con su carrera.

**Imágenes:** usa `painterResource` con los drawables `R.drawable.avatar_jose`, `avatar_maria`, `avatar_carlos`, `avatar_ana` y `avatar_luis` (fotos que yo agregaré en `res/drawable`). Siempre muéstralas con `ContentScale.Crop` y `Modifier.clip(CircleShape)`. Crea un composable reutilizable `StudentAvatar(@DrawableRes res: Int, size: Dp, borderWidth: Dp = 0.dp)`.

## 4. Paleta de colores (usar exactamente estos)

Crea un archivo `ui/theme/AppColors.kt` con estas constantes:

| Nombre | Hex | Uso |
|---|---|---|
| `Purple` | `#6750A4` | color primario, botones, textos destacados, íconos |
| `PurpleDark` | `#4F378B` | fin del degradado del encabezado del expediente |
| `PurpleGradientTop` | `#6B5CA5` | parte superior del degradado de Bienvenida |
| `LavenderTop` | `#EADDFF` | fondo de TopAppBar del directorio, cajas de íconos |
| `LavenderBg` | `#F4EFFB` | fondos claros y parte inferior de los degradados |
| `CardGray` | `#E7E0EC` | tarjetas del directorio, tarjeta de login, tarjeta del expediente |
| `SurfaceWhite` | `#FFFBFE` | tarjetas blancas del menú de Home |
| `TextDark` | `#1D1B20` | títulos |
| `TextGray` | `#49454F` | subtítulos y etiquetas |
| `Mauve` | `#7D5260` | fin del degradado horizontal de Configuración de Perfil |
| `LogoutRed` | `#B3261E` | textos e íconos de cerrar sesión |
| `LogoutBg` | `#F9DEDC` | fondo del botón Cerrar Sesión |

Íconos: agrega `implementation("androidx.compose.material:material-icons-extended")` y usa `Icons.Filled` / `Icons.AutoMirrored.Filled`: `Email`, `Lock`, `VisibilityOff`, `Visibility`, `Groups`, `Person`, `Badge`, `School`, `Phone`, `CalendarMonth`, `ArrowBack`, `KeyboardArrowRight` y `AutoMirrored.Filled.Logout`.

---

## 5. Especificación pantalla por pantalla

### 5.1 LoginScreen — "Portal Académico"
- **Fondo:** degradado vertical a pantalla completa, de `LavenderTop` (arriba) a `LavenderBg` (abajo).
- **Contenido** centrado vertical y horizontalmente, con padding horizontal de 32.dp.
- **Card de login:**
  - `fillMaxWidth()`, color `CardGray` con alpha 0.85, esquinas `RoundedCornerShape(20.dp)`, elevación 8.dp y padding interno de 24.dp.
- **Dentro de la card**, en un Column centrado:
  1. "Portal Académico": 26.sp, `FontWeight.Bold`, color `Purple`.
  2. "Accede a tu cuenta": 14.sp, color `TextDark`. Spacer de 28.dp debajo.
  3. `OutlinedTextField` "Correo Institucional":
     - `leadingIcon` `Icons.Filled.Email` en `TextDark`, esquinas 12.dp, `fillMaxWidth()`.
     - Borde gris `#79747E` sin foco y `Purple` con foco. Fondo transparente.
  4. Spacer de 16.dp.
  5. `OutlinedTextField` "Contraseña":
     - `leadingIcon` `Icons.Filled.Lock` y `trailingIcon` `IconButton` que alterna `VisibilityOff`/`Visibility`.
     - `PasswordVisualTransformation` cuando está oculta. Mismo estilo que el campo anterior.
  6. Spacer de 28.dp.
  7. `Button` "INICIAR SESIÓN":
     - `fillMaxWidth()`, altura 52.dp, esquinas 10.dp, fondo `Purple`.
     - Texto blanco, 15.sp, Bold, con letterSpacing de 1.sp.
  8. Spacer de 20.dp.
  9. `TextButton` "¿Olvidaste tu contraseña?": 13.sp, color `TextGray`.

### 5.2 HomeScreen — "Bienvenida"
- **Fondo:** degradado vertical a pantalla completa, de `PurpleGradientTop` (0%) a `LavenderBg` (100%). No uses TopAppBar.
- `Column(fillMaxSize, padding horizontal 24.dp)` con `statusBarsPadding()` y `navigationBarsPadding()`.
- Spacer superior de ~120.dp, para que el saludo quede a un 20 % de la altura.
- **Saludo:** "Bienvenido,\nJosé Rojas", 32.sp, Bold, blanco, `TextAlign.Center`, `lineHeight` de 38.sp, centrado.
- Spacer de 32.dp.
- **Pregunta:** "¿Qué deseas gestionar hoy?", 14.sp, blanco con alpha 0.85, centrado.
- Spacer de 20.dp.
- **Dos tarjetas de menú**, separadas por 14.dp. Composable reutilizable `MenuOptionCard(icon, title, subtitle, onClick)`:
  - Card: `fillMaxWidth()`, altura 76.dp, esquinas 16.dp, fondo `SurfaceWhite`, elevación 6.dp y `clickable`.
  - Row con padding horizontal de 16.dp y centrado vertical:
    - Caja de ícono: 44.dp, esquinas 12.dp, fondo `LavenderTop`, con el ícono de 24.dp en `Purple` centrado.
    - Spacer de 16.dp.
    - Column con el título (15.sp, Bold, `TextDark`) y el subtítulo (12.sp, `TextGray`).
  - Tarjeta 1: ícono `Groups`, "Directorio de Alumnos", "Ver y gestionar estudiantes".
  - Tarjeta 2: ícono `Person`, "Mi Perfil Académico", "Datos personales y progreso".
- `Spacer(Modifier.weight(1f))` para empujar el siguiente elemento al fondo.
- **Cerrar sesión:** `TextButton` centrado con Row: ícono `Logout` de 18.dp en `LogoutRed` + Spacer de 8.dp + "Cerrar Sesión Segura" (13.sp, SemiBold, `LogoutRed`). Padding inferior de 24.dp.

### 5.3 ListScreen — "Directorio de Alumnos"
- `Scaffold` con fondo `SurfaceWhite`.
- **TopAppBar:** `containerColor = LavenderTop`.
  - Título "Directorio de Alumnos": 20.sp, Bold, color `#21005D`.
  - `navigationIcon`: flecha `ArrowBack` en `#21005D` con `popBackStack()`.
- `LazyColumn` con `contentPadding` = padding del Scaffold + 16.dp horizontal y 12.dp vertical. Usa `verticalArrangement = Arrangement.spacedBy(12.dp)`.
- **Item** (composable `StudentCard`):
  - Card: `fillMaxWidth()`, esquinas 14.dp, fondo `CardGray`, elevación 3.dp, `clickable`.
  - Row con padding de 14.dp y centrado vertical:
    - `StudentAvatar` de 52.dp, circular.
    - Spacer de 14.dp.
    - Column con `weight(1f)`: nombre (16.sp, Bold, `TextDark`) y carrera (13.sp, `Purple`).
    - Ícono `KeyboardArrowRight` de 20.dp en `TextGray`.
- Sin divisores: la separación la dan las tarjetas.

### 5.4 DetailScreen — "Expediente Académico"
- Recibe `itemId: Int` y obtiene el alumno con `StudentRepository.getById(itemId)`.
- `Scaffold` con fondo `SurfaceWhite`.
- **TopAppBar:** `containerColor = SurfaceWhite`.
  - Título "Expediente Académico": 18.sp, Bold, `TextDark`.
  - Flecha ← con `popBackStack()`.
- **Contenido:** Column con scroll vertical.
- **Encabezado:** `Box` de `fillMaxWidth()` y altura 230.dp.
  - Fondo: `Box` de altura 150.dp con degradado vertical de `Purple` a `PurpleDark`. Esquinas **solo inferiores** redondeadas: `RoundedCornerShape(bottomStart = 28.dp, bottomEnd = 28.dp)`.
  - Avatar: `StudentAvatar` de 130.dp con borde blanco de 4.dp, alineado `Alignment.BottomCenter`, de modo que la mitad superior quede sobre el degradado y la mitad inferior sobre el fondo blanco.
- Spacer de 12.dp.
- **Datos principales:**
  - Nombre: 24.sp, Bold, `TextDark`, centrado.
  - Carrera: 14.sp, `Purple`, centrado.
- Spacer de 20.dp.
- **Card de información:**
  - `fillMaxWidth()`, padding horizontal de 20.dp, esquinas 18.dp, fondo `CardGray` con alpha 0.6, sin elevación.
  - Padding interno de 20.dp.
- **Dentro de la card**, tres filas con el composable `InfoRow(icon, label, value)`, separadas por 14.dp:
  - Estructura de cada fila: ícono de 20.dp en `Purple` + Spacer de 14.dp + Column con la etiqueta (11.sp, `TextGray`) y el valor (14.sp, SemiBold, `TextDark`).
  - Filas:
    - `Badge` / "ID Estudiante" / código
    - `Email` / "Correo Electrónico" / email
    - `School` / "Facultad" / facultad
  - `HorizontalDivider` con padding vertical de 16.dp y color `#CAC4D0`.
  - "Biografía": 15.sp, Bold, `TextDark`.
  - Spacer de 6.dp.
  - Texto de la biografía: 13.sp, `TextGray`, `lineHeight` de 18.sp, `TextAlign.Justify`.

### 5.5 ProfileScreen — "Configuración de Perfil"
- `Scaffold` con fondo `SurfaceWhite`.
- **TopAppBar:** `containerColor = SurfaceWhite`.
  - Título "Configuración de Perfil": 18.sp, Bold, `TextDark`.
  - Flecha ← con `popBackStack()`.
- **Encabezado:** `Box` de `fillMaxWidth()` y altura 180.dp.
  - Fondo: degradado **horizontal** (`Brush.horizontalGradient`) de `Purple` (izquierda) a `Mauve` (derecha), sin esquinas redondeadas.
  - Contenido centrado:
    - `StudentAvatar` de 96.dp con borde blanco de 3.dp.
    - Spacer de 10.dp.
    - "José Rojas Condor": 20.sp, Bold, blanco.
- Column con padding horizontal de 20.dp.
- **Títulos de sección:**
  - Textos "INFORMACIÓN PERSONAL" y "ACADÉMICO".
  - Estilo: 12.sp, Bold, `Purple`, letterSpacing de 1.sp.
  - Padding: 24.dp arriba y 12.dp abajo.
- **Filas de dato:** composable `ProfileRow(icon, label, value)`, separadas por 16.dp.
  - Estructura: caja de ícono de 36.dp con esquinas 10.dp y fondo `CardGray`, con el ícono de 18.dp en `TextGray` + Spacer de 16.dp + Column con la etiqueta (11.sp, `TextGray`) y el valor (15.sp, Medium, `TextDark`).
  - Sección personal:
    - `Person` / "Nombre Completo" / "José Rojas Condor"
    - `Email` / "Correo" / "jose.rojas@tecsup.edu.pe"
    - `Phone` / "Teléfono" / "+51 987 654 321"
  - Sección académica:
    - `School` / "Carrera" / "Diseño y Desarrollo de Software"
    - `CalendarMonth` / "Ciclo Actual" / "VI Ciclo"
- **Botón Cerrar Sesión (IMPORTANTE: debe quedar pegado al fondo de la pantalla):**
  - NO lo pongas justo debajo de la última fila. Debe quedar **anclado en la parte inferior**, dejando un espacio grande vacío entre "Ciclo Actual" y el botón.
  - Cómo hacerlo:
    - Coloca el botón en el parámetro **`bottomBar`** del `Scaffold`, dentro de un `Box`/`Column` con `navigationBarsPadding()` y padding horizontal de 20.dp, 8.dp arriba y 16.dp abajo.
    - Alternativa: el Column de contenido debe tener `fillMaxSize()`, **sin** `verticalScroll`, y un `Spacer(Modifier.weight(1f))` antes del botón.
    - `weight(1f)` no funciona dentro de un Column con `verticalScroll`.
  - Estilo: `Button` con `fillMaxWidth()`, altura 44.dp y esquinas 12.dp.
  - Colores: fondo `LogoutBg` con alpha 0.8, contenido `LogoutRed`, sin elevación.
  - Contenido: Row centrado con ícono `Logout` de 18.dp + Spacer de 8.dp + "Cerrar Sesión" (14.sp, SemiBold).

---

## 6. Reglas de implementación

1. Entrega el **código completo** de cada archivo, con su `package` e imports. No uses fragmentos ni "// resto igual".
2. Archivos a entregar:
   - `Screen.kt` (agregar `Login`)
   - `AppNavigation.kt`
   - `model/Student.kt`
   - `data/StudentRepository.kt`
   - `ui/theme/AppColors.kt`
   - `ui/components/` (con `StudentAvatar`, `MenuOptionCard`, `StudentCard`, `InfoRow` y `ProfileRow`)
   - `LoginScreen.kt`, `HomeScreen.kt`, `ListScreen.kt`, `DetailScreen.kt` y `ProfileScreen.kt`
   - Líneas a agregar en `build.gradle.kts (Module :app)`.
3. Usa `@OptIn(ExperimentalMaterial3Api::class)` donde haya `TopAppBar`.
4. Usa solo Material 3 (`androidx.compose.material3`). No mezcles componentes de Material 2.
5. Maneja el estado de los campos del login con `remember { mutableStateOf("") }`. No hace falta validar credenciales.
6. Respeta los insets del sistema, ya que `enableEdgeToEdge()` está activo: el degradado de Login y Home debe cubrir también la barra de estado.
7. Agrega un `@Preview(showBackground = true, showSystemUi = true)` por pantalla, usando un `rememberNavController()` falso.
8. No cambies el nombre del paquete ni la firma de `AppNavigation()`.
9. Al final, dame una lista breve de los nombres exactos que deben tener las imágenes en `res/drawable`.

---

## 7. Verificación final (revisa esto antes de terminar)

1. **Datos personales:**
   - No debe quedar ningún texto con "Juan León" ni "Juan León Suiyon" en la app.
   - Bienvenida: "Bienvenido,\nJosé Rojas".
   - Primer alumno de `StudentRepository`: "José Rojas Condor", "jose.rojas@tecsup.edu.pe", "Diseño y Desarrollo de Software".
   - Configuración de Perfil: nombre "José Rojas Condor" y correo "jose.rojas@tecsup.edu.pe".
   - El drawable del usuario se llama `avatar_jose`.
2. **Botón Cerrar Sesión en ProfileScreen:**
   - Debe quedar anclado al fondo de la pantalla, dentro del `bottomBar` del `Scaffold`, con un espacio vacío grande entre "Ciclo Actual" y el botón.
   - No debe quedar pegado justo debajo de las filas de datos.
3. **Botón Cerrar Sesión Segura en HomeScreen:** también debe quedar abajo, con `Spacer(Modifier.weight(1f))` antes, en un Column sin `verticalScroll`.
4. **Compilación:** el proyecto debe compilar sin errores. Si faltan las imágenes `avatar_*`, crea drawables vectoriales temporales con esos nombres para que compile.
