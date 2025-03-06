fun main() {
    
   
    
    var estado:Int
    var auxEs:Int = 1 // 1=rojo, 2=amarillo, 3=verde, 4 = descompuesto
    var aux:Boolean =false
    var i:Int =0
    
    print("Ingrese el tamano:")
    val a:Int = readln().toInt()//2
    
    while(i<a){
        //pedirnumero
        //estado = 0
        estado = readln().toInt()//1
        
        if(estado == 0){
            aux = true
            println("apagado")
            ++i
        }else if(estado == 1){
            //pedir numero
            while(i<a){
                if(estado == 1 && auxEs == 1){
                    auxEs = 2
                    println("Rojo")
                    estado = readln().toInt()
                    
                }else if(estado == 1 && auxEs == 2){
                    auxEs = 3
                    println("Amarrillo")
                    estado = readln().toInt()
                    
                }else if(estado == 1 && auxEs == 3){
                    auxEs = 1
                    println("Verde")
                    estado = readln().toInt()
                    
                }else{
                    println("descompuesto")
                    auxEs = 1
                    estado = readln().toInt()
                    
                }
                 ++i
                
            }
           
            ++i
           
        }
       ++i
        
    }
    
}