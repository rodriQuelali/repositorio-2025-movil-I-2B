package com.example.calculadorapoo.data

class Calculadora {

    /*constructor(num1: Int, num2: Int){
        this.num1 = num1
        this.num2 = num2
    }*/


    public final fun suma(a: String, b: String):Float{
        if (a.contains(".") || b.contains(".")){
            val resul:Float = a.toFloat() + b.toFloat()
            if (resul.toString().contains(".0")){
                return resul
                //tvResul.text = resul.toInt().toString()
            }else{
                return resul
                //tvResul.text = resul.toString()
            }
        }else{
            return a.toFloat() + b.toFloat()
            //tvResul.text = "Total de suma: ${cal1.suma(et1.text.toString().toInt(), et2.text.toString().toInt()).toString()}"
        }

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