package com.example.calculadorapoo.data

class Calculadora {



    //suma --- sumar solo eso.
    //SaberEnteroFloat ---
    //con las A, B verofocar
    // con el resultado, manteniendo el float.
    fun suma(a: String, b: String): String{
        val res = a.toFloat() + b.toFloat()
        val resString =saberEnteroFloat(res.toString())
        return resString
    }

    private fun saberEnteroFloat(res: String):String{
        val test = res.toFloat()
        return if (test % 1.0f == 0.0f) res.toInt().toString() else res.toString()
    }




}