package com.example.calculadorapoo.data

class Calculadora {

    fun suma(a: Double, b: Double): String{
        val res = a + b
        val resString =saberEnteroFloat(res)
        return resString
    }

    private fun saberEnteroFloat(res: Double):String{
        val test = res.toFloat()
        return if (test % 1.0f == 0.0f) res.toInt().toString() else res.toString()
    }


}