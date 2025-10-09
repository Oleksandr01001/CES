fun main() {
    val hilo = Thread{
        for (i in 1..5) {
            println("Holo ejecutando")
            Thread.sleep(1000)
        }
        println("Holo acabado")
    }
}