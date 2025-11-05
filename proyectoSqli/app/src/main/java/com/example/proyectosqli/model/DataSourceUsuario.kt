package com.example.proyectosqli.model

class DataSourceUsuario {

    //insert
    //delete
    //update
    //lista
    // otras operaciones mas ....

    //registro
    fun registroUsuarioDataSource(usuario: Usuario){

        val admin = AdminSQLiteOpenHelper(this,"administracion", null, 1)

    }
}