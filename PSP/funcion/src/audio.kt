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
import java.io.File

fun main() {
    embeddedServer(Netty, port = 8080) {
        routing {

            get("/generar-qr") {
                val texto = call.request.queryParameters["texto"] ?: "Sin texto"
                try {
                    val qrWriter = QRCodeWriter()
                    val bitMatrix = qrWriter.encode(texto, BarcodeFormat.QR_CODE, 350, 350)
                    val stream = ByteArrayOutputStream()
                    MatrixToImageWriter.writeToStream(bitMatrix, "PNG", stream)
                    call.respondBytes(stream.toByteArray(), ContentType.Image.PNG)
                } catch (e: Exception) {
                    call.respondText("Error QR: ${e.message}")
                }
            }

            get("/texto-a-voz") {
                val texto = call.request.queryParameters["texto"] ?: "Hola Maquina Windows"
                val textoSeguro = texto.replace("\"", "").replace("'", "")

                println("Procesando audio para: $textoSeguro")

                try {
                    val tempFile = File.createTempFile("audio_kotlin", ".wav")

                    val scriptPs = """
                        Add-Type -AssemblyName System.Speech;
                        ${'$'}synth = New-Object System.Speech.Synthesis.SpeechSynthesizer;
                        
                        # Buscamos una voz que sea Español (es-*) y Femenina
                        ${'$'}voz = ${'$'}synth.GetInstalledVoices() | Where-Object { 
                            ${'$'}_.VoiceInfo.Culture.Name -like 'es-*' -and ${'$'}_.VoiceInfo.Gender -eq 'Female' 
                        } | Select-Object -First 1;
                        
                        # Si la encontramos, la seleccionamos. Si no, usará la por defecto.
                        if (${'$'}voz) { 
                            ${'$'}synth.SelectVoice(${'$'}voz.VoiceInfo.Name); 
                        }

                        ${'$'}synth.SetOutputToWaveFile('${tempFile.absolutePath}');
                        ${'$'}synth.Speak('$textoSeguro');
                        ${'$'}synth.Dispose();
                    """.trimIndent()

                    val process = ProcessBuilder("powershell", "-Command", scriptPs).start()
                    process.waitFor()

                    if (tempFile.exists() && tempFile.length() > 0) {
                        call.respondBytes(tempFile.readBytes(), ContentType("audio", "wav"))
                        tempFile.delete()
                    } else {
                        call.respondText("Error: No se generó audio", status = HttpStatusCode.InternalServerError)
                    }

                } catch (e: Exception) {
                    e.printStackTrace()
                    call.respondText("Error Audio: ${e.message}")
                }
            }
        }
    }.start(wait = true)
}