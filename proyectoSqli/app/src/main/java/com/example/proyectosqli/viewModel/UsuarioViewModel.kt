package com.example.proyectosqli.viewModel


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.proyectosqli.model.RepositoryUsuario
import com.example.proyectosqli.model.Usuario

class UsuarioViewModel(application: Application): AndroidViewModel(application) {

    private val repositoryUsuario = RepositoryUsuario(application)

    val usuarios = MutableLiveData<List<Usuario>>()
    val mensaje = MutableLiveData<String>()



//si llamao a mi funcion resgistroViewModel automaticmente se lanzan las dos variables:usuarios,mensaje
    // en mi view o UI.
    fun registroViewModel(usuario: Usuario){
        if(usuario.getNombre().isEmpty() || usuario.getCorreo().isEmpty() || usuario.getPassword().isEmpty()){
            mensaje.value = "Llenar los campos....."
            return
        }
        val res = repositoryUsuario.registroUsuarioRepository(usuario)
        if (res > 0){
            cargarUsuarioViewModel()
            mensaje.value = "Registro correcto....."
        }else{
            mensaje.value = "Error al registrar....."
        }
    }

    fun cargarUsuarioViewModel(){
        usuarios.value = repositoryUsuario.listaUsuarioRepository()
    }

    //delte

    fun eliminarUsuario(codigo:Int){
        println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>$codigo")
        val filas = repositoryUsuario.deteleRepository(codigo)
        mensaje.value = if (filas > 0) "Usuario eliminado" else "No se encontró el usuario"
        cargarUsuarioViewModel()
    }

    //update

    fun actulizarUsuario(usuario: Usuario){
        if(usuario.getNombre().isEmpty() || usuario.getCorreo().isEmpty() || usuario.getPassword().isEmpty()){
            mensaje.value = "Llenar los campos..."
            return
        }
        val data = repositoryUsuario.updateRepository(usuario)
        if(data > 0){
            mensaje.value = "actualizacion correcto....."
            cargarUsuarioViewModel()
        }else{
            mensaje.value = "Error al editar SQLi..."
        }
    }

}