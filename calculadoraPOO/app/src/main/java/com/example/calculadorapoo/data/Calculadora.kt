package com.example.calculadorapoo.data

class Calculadora {

    fun suma(a: Double, b: Double): String{
        val res = a + b
        val resString =saberEnteroFloat(res)
        return resString
    }

    fun resta(a: Double, b: Double): String{
        val res = a - b
        val resString =saberEnteroFloat(res)
        return resString
    }

    fun multi(a: Double, b: Double): String{
        val res = a * b
        val resString =saberEnteroFloat(res)
        return resString
    }

    fun divi(a: Double, b: Double): String{
        if (b.toInt() ==0){
           return "NO se puede"
        }
        val res = a / b
        val resString =saberEnteroFloat(res)
        return resString
    }

    private fun saberEnteroFloat(res: Double):String{
        val test = res.toFloat()
        return if (test % 1.0f == 0.0f) res.toInt().toString() else res.toString()
    }

    //con los boton re +,-,* y /.


}