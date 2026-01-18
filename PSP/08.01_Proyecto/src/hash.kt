import java.security.MessageDigest
import kotlin.system.exitProcess

fun main() {
    // =========================================================================
    // 1. AQUÍ PEGAS EL HASH DE TU AMIGO
    // Borra lo que hay entre comillas y pon el hash largo (hexadecimal)
    // Ejemplo: val hashObjetivo = "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855"
    // =========================================================================

    val hashObjetivo = "d6d7b375032af3a302449cf23fa45d882b4a6a7f86cb36517f35839b8fc245de"


    // =========================================================================
    // 2. CONFIGURA EL DICCIONARIO (EL ALFABETO)
    // IMPORTANTE: Si la contraseña de tu amigo tiene mayúsculas o números y
    // no los pones aquí, el programa NUNCA la encontrará.
    // =========================================================================

    // Opción A: Solo letras minúsculas (Muy rápido)
    // val alfabeto = "abcdefghijklmnopqrstuvwxyz"

    // Opción B: Letras y números (Más lento, úsalo si crees que tiene números)
    // val alfabeto = "abcdefghijklmnopqrstuvwxyz0123456789"

    // Opción C: Completo (Extremadamente lento, solo para contraseñas cortas)
    val alfabeto = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"


    println("--- HACKEANDO HASH DE UN AMIGO ---")
    println("Objetivo: $hashObjetivo")
    println("Usando caracteres: $alfabeto")

    val digest = MessageDigest.getInstance("SHA-256")
    var intentos: Long = 0
    val tiempoInicio = System.currentTimeMillis()

    // Probamos longitud de 1 a 6 caracteres (más de 6 tardará mucho tiempo)
    for (longitud in 1..6) {
        println("\n[INFO] Probando todas las combinaciones de longitud: $longitud")

        romperHash(
            prefijo = "",
            longitudRestante = longitud,
            alfabeto = alfabeto,
            digest = digest,
            target = hashObjetivo
        )
    }

    println("\n[-] No se encontró la contraseña con una longitud máxima de 6 caracteres.")
}

fun romperHash(
    prefijo: String,
    longitudRestante: Int,
    alfabeto: String,
    digest: MessageDigest,
    target: String
) {
    if (longitudRestante == 0) {
        // Hasheamos el intento
        val hashIntento = digest.digest(prefijo.toByteArray())
            .joinToString("") { "%02x".format(it) }

        // Comparamos
        if (hashIntento.equals(target, ignoreCase = true)) {
            println("\n" + "=".repeat(40))
            println("[!] ¡ÉXITO! CONTRASEÑA ENCONTRADA")
            println("[!] La contraseña es: $prefijo")
            println("=".repeat(40))
            exitProcess(0)
        }
        return
    }

    for (char in alfabeto) {
        romperHash(prefijo + char, longitudRestante - 1, alfabeto, digest, target)
    }
}