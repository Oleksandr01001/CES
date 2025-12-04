package com.example.practicapsp

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

class TCPCliente {

    fun enviarLogin(usuario: String, contrasena: String, onResult: (String) -> Unit) {

        CoroutineScope(Dispatchers.IO).launch {
            try {
                // IP de tu Mac
                val socket = Socket("10.69.194.254", 6000)

                val salida = PrintWriter(socket.getOutputStream(), true)
                val entrada = BufferedReader(InputStreamReader(socket.getInputStream()))

                // Enviamos: "usuario;contrasena"
                val mensaje = "$usuario;$contrasena"
                salida.println(mensaje)

                // Leemos respuesta
                val respuesta = entrada.readLine() ?: "SIN_RESPUESTA"

                entrada.close()
                salida.close()
                socket.close()

                withContext(Dispatchers.Main) {
                    onResult(respuesta)
                }

            } catch (e: Exception) {
                e.printStackTrace()
                withContext(Dispatchers.Main) {
                    onResult("ERROR_CONEXION")
                }
            }
        }
    }
}
