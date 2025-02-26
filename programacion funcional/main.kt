fun main(){



    // tipo de datos
 /*var b: Double  //64bit
 var a: Int = 45 //32bits
     a = 50
    
    var c: Float = 2.4F //32bits
    var x: Long = 2 //64bits
    var h: String  = "holaaa" //16bits
    var k: Boolean  = true //8bits
    var g: Char  = 'h' //12bits
    
    b = 3.14*/
     
    //if
    var estado: Int = 30
    /*if (estado != false){
        print("Inactivo")
    }else{
        print("activo")
    }*/
    
    //if ternario
    //javascroipt -> alert(estado == true ? "activo" : "inactivo")
    
    //var b = if(estado != false) "Inactivo" else "activo"
    //print(if(estado != false) "Inactivo" else "activo")


    //operadores logicos
    
    // || -> O -> OR
    // && -> Y -> AND
    // ! -> not

    //operadores relacionales
    // >, <, >=, =>, <>, ==

    // case -> switch
    // when
    var a:Int = 53
    var b:Int = 23
    var c:Int = 3
    
    when{
        a>b && a>c -> println("el amyor es: $a")
        b>a && b>c -> println("el amyor es: $b")
        else -> println("el mayor es: c")
    }


    //Estructuras de repeticion
    //while(){}

    //do{}()

    //for(int i=0; i>10; i++){}

    //for(i in 5..10){
        //println(i)
    //}



}