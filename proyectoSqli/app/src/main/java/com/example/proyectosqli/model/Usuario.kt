package com.example.proyectosqli.model

class Usuario (
    private val codigo: Int = 1,
    private val nombre:String,
    private val correo:String,
    private val password:String){

    fun getCodigo ()= this.codigo
    fun getNombre ()= this.nombre
    fun getCorreo ()= this.correo
    fun getPassword ()= this.password

}