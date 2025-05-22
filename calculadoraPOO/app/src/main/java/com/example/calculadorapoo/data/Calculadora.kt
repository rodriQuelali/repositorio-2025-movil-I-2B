package com.example.calculadorapoo.data

class Calculadora {

    /*constructor(num1: Int, num2: Int){
        this.num1 = num1
        this.num2 = num2
    }*/


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

    //sobrecarga de metodos


    //public final fun suma(a :String, b:String): Int{
      //  return a.toInt() + b.toInt()
    //}

    /*
    * c#
    * class Calculadora{
    *   private Int num1;
    *   private Int num2;
    *
    *   Calculadora(Int num1, Int numer2){
    *       this.num1 = num1;
    *       this.num2 = num2;
    *   }
    *   funcion
    *   int sumar (){
    *       return this.num1 + this.num2;
    *   }
    *
    *   procedimento
    *   public void restar(){
    *       console.write(this.num1 - this.num2);
    *   }
    *
    * }
    * */


}