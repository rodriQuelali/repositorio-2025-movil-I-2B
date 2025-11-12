package com.example.proyectosqli.model

import android.content.Context

class RepositoryUsuario (context: Context){

    private val dataSourceUsuario: DataSourceUsuario = DataSourceUsuario(context)

    fun registroUsuarioRepository(usuario: Usuario):Long{
        return dataSourceUsuario.registroUsuarioDataSource(usuario)
    }

    fun listaUsuarioRepository(): List<Usuario>{
        return dataSourceUsuario.listarUsuarios()
    }

}