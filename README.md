# repositorio-2025-movil-I-2B

# 📱 Proyecto de Registro de Usuarios y Artículos (Android + SQLite + MVVM)

Este proyecto es una aplicación móvil desarrollada en **Android Studio** utilizando **Kotlin**.  
Tiene como objetivo gestionar el **registro de usuarios** y **artículos** mediante una interfaz sencilla y moderna basada en **Material Design 3**, y una arquitectura limpia utilizando el patrón **MVVM (Model - View - ViewModel)**.

---

## 🚀 Características principales

✅ Registro, visualización, edición y eliminación de **usuarios**  
✅ Registro, visualización, edición y eliminación de **artículos**  
✅ Base de datos local con **SQLite**  
✅ Arquitectura **MVVM**, separando la lógica de negocio, datos y la interfaz  
✅ Uso de **RecyclerView** para listar elementos dinámicamente  
✅ Diseño con **Material Design 3 (Material You)**  
✅ Implementación modular y escalable

---

## 🏗️ Arquitectura del proyecto

El proyecto se basa en la arquitectura **MVVM**, que separa las responsabilidades en capas bien definidas:


│ View (UI) │ → Muestra los datos y observa los cambios del ViewModel
│ (Activity / Fragment) │

│ Observa LiveData

│ ViewModel │ → Gestiona la lógica y comunica el modelo con la vista
│ (UsuarioViewModel.kt) │

│ Llama métodos

│ Model │ → Contiene las clases de datos y acceso a la BD
│ (Usuario.kt / Repositorio)│


---

## 💾 Base de datos SQLite

El proyecto utiliza SQLite a través de una clase auxiliar `AdminSQLiteOpenHelper`, que crea las siguientes tablas:

### Tabla Usuario
| Campo | Tipo | Descripción |
|--------|------|-------------|
| id_usuario | INTEGER PRIMARY KEY | Identificador único del usuario |
| nombre | TEXT | Nombre completo del usuario |
| correo | TEXT | Correo electrónico |
| password | TEXT | Contraseña del usuario |

### Tabla Artículo
| Campo | Tipo | Descripción |
|--------|------|-------------|
| codigo | INTEGER PRIMARY KEY | Identificador único del artículo |
| descripcion | TEXT | Detalle del artículo |
| precio | REAL | Precio del artículo |

---

## 🧠 Descripción técnica

- **Lenguaje:** Kotlin  
- **Base de datos:** SQLite  
- **Arquitectura:** MVVM  
- **Diseño:** Material Design 3  
- **Compatibilidad:** Android 8.0 (API 26) o superior  
- **IDE:** Android Studio Iguana o superior

---

## 🪄 Flujo de la aplicación

1. Al iniciar la aplicación, se muestra una **pantalla de bienvenida** con dos botones:
   - **Gestionar Usuarios**
   - **Gestionar Artículos**
2. Desde el menú, el usuario puede registrar nuevos datos, editar o eliminar registros existentes.
3. Los cambios se reflejan automáticamente en la interfaz mediante **LiveData** observada desde el **ViewModel**.

---

## 📸 Capturas (opcional)
> *(Agrega aquí imágenes del diseño o pantallas de la app)*
<img width="592" height="1267" alt="image" src="https://github.com/user-attachments/assets/cdbc5b49-303d-4720-963c-de38f1785a32" />


---

## 🧰 Dependencias principales

```gradle
implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.0'
implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.8.0'
implementation 'com.google.android.material:material:1.12.0'
implementation 'androidx.recyclerview:recyclerview:1.3.2'

👨‍💻 Autor

Rodri Quelali
Desarrollador Android | Proyecto académico de registro de usuarios y artículos.
📧 rodriquelali@gmail.com
📅 Año: 2025
