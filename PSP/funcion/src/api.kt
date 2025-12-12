package org.example

import com.google.zxing.BarcodeFormat
import com.google.zxing.client.j2se.MatrixToImageWriter
import com.google.zxing.qrcode.QRCodeWriter
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.ByteArrayOutputStream

fun main() {
    embeddedServer(Netty, port = 8080) {
        routing {
            get("/generar-qr") {
                val textoParaQr = call.request.queryParameters["texto"] ?: "No has enviado texto"

                println("Solicitud recibida para procesar: $textoParaQr")

                try {
                    val qrWriter = QRCodeWriter()
                    val bitMatrix = qrWriter.encode(textoParaQr, BarcodeFormat.QR_CODE, 350, 350)
                    val stream = ByteArrayOutputStream()
                    MatrixToImageWriter.writeToStream(bitMatrix, "PNG", stream)
                    val imagenEnBytes = stream.toByteArray()
                    call.respondBytes(imagenEnBytes, ContentType.Image.PNG)

                } catch (e: Exception) {
                    call.respondText("Error generando QR: ${e.message}", status = HttpStatusCode.InternalServerError)
                }
            }
        }
    }.start(wait = true)
}