import java.net.Socket


fun main() {
    try {
        val cliente = Socket("192.168.2.101",12345)
        val output = cliente.getOutputStream().writer()
        val input = cliente.getInputStream().bufferedReader()

        output.write("Hola\n")
        output.flush()

        // Читаємо відповідь
        val response = input.readLine()
        println("Отримано: $response")

        // Закриваємо з'єднання
        cliente.close()

    }catch (e : Exception){
        println(e.message)
    }

}