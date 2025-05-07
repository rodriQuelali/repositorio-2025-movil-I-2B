package com.example.calculadorapoo.data

class Calculadora {

    /*constructor(num1: Int, num2: Int){
        this.num1 = num1
        this.num2 = num2
    }*/


    fun sumar(a: Int, b: Int):Int{
        return a + b
    }

    //sobrecarga de metodos


    fun suma(a :Float, b:Float): Float{
        return a + b
    }

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