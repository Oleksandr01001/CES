fun main() {
    //eje_1()
    //eje_2()
    //eje_3()
    eje_4()
}

fun eje_1() {
    println("Introduce un numero: ")
    var num = readln().toInt()

    if (num % 2 == 0) {
        println("Es par")
    } else {
        println("Es impar")
    }
}

fun eje_2() {
    println("Introduce un numero: ")
    var num = readln().toInt()
    if (num < 0) {
        println("Es negativo")
    } else if(num > 0){
        println("Es positivo")
    } else {
        println("Es cero")
    }
}

fun eje_3() {
    println("Introduce un numero: ")
    var num = readln().toInt()
    var divisores = 0


    for(i in num downTo 1) {
        if (num % i == 0) {
            divisores++
        }
    }

    if (divisores == 2) {
        println("El número $num es primo")
    } else {
        println("El número $num no es primo")
    }
}

fun eje_4() {
    println("Introduce un numero: ")
    var num = readln().toInt()

}


