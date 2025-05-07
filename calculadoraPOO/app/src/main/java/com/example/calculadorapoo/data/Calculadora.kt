package com.example.calculadorapoo.data

class Calculadora constructor(num1: Int, num2: Int){

    /*constructor(num1: Int, num2: Int){
        this.num1 = num1
        this.num2 = num2
    }*/

    private val num1: Int = num1
    private val num2: Int = num2
    private var resultado: Int = 0

    fun sumar():Int{
        this.resultado = this.num1 + this.num2
        return this.resultado
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