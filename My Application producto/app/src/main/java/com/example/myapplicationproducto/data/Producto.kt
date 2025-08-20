package com.example.myapplicationproducto.data

class Producto(private val nombre: String, private val des: String, private val precio:Int) {

    fun getNombre():String = this.nombre

    fun getPrecio():Int = this.precio

    fun getDes():String = this.des

}