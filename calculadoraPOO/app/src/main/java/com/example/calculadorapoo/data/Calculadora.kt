package com.example.calculadorapoo.data

class Calculadora {



    //suma --- sumar solo eso.
    //SaberEnteroFloat ---
    fun suma(a: String, b: String): String{
        if (a.contains(".") || b.contains(".")){
            val resul:Float = a.toFloat() + b.toFloat()
            if (resul.toString().contains(".0")){
                return resul.toInt().toString()
            }
                return resul.toString()
        }
        val resul:Int = a.toInt() + b.toInt()
        return resul.toString()

    }




}