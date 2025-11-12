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



}