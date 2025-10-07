package controller

import model.Arma
import model.ArmaBiologica
import model.ArmaTradicional
import model.Humano
import model.Mutante
import model.Superheroe

class Combate {
    var listaHeroes = arrayListOf<Superheroe>()
    var listaArmas = arrayListOf<Arma>()

    fun agregarHeroe() {
        println("Elige que tipo de heroe quieres agregar (1.Humano / 2. Mutante): ")
        var tipo = readln().toInt()
        println("Introduce id: ")
        val id = readln().toInt()
        println("Introduce nombre: ")
        var nombre = readln()
        println("Introduce nivel: ")
        var nivel = readln().toInt()

        when(tipo) {
            1->{
                println("Introduce la resisencia: ")
                var resistencia = readln().toInt()

                println("Creando la arma tradicional para heroe humano...")
                println("Introduce id: ")
                var idTradicional = readln().toInt()
                println("Introduce nombre: ")
                var nombreTradicional = readln()
                println("Introduce nivel de Potencia: ")
                var nivelPotenciaTradicional = readln().toInt()
                println("Introduce nivel de daño: ")
                var nivelDanoTradicional = readln().toInt()
                println("Introduce peso: ")
                var peso = readln().toDouble()

                var armaTradicional = ArmaTradicional(idTradicional,nombreTradicional,nivelPotenciaTradicional,nivelDanoTradicional,peso)
                listaArmas.add(armaTradicional)
                var humano = Humano(id,nombre,nivel,resistencia,armaTradicional)

                listaHeroes.add(humano)

            }
            2->{
                println("Creando la arma biologica para heroe mutante...")
                println("Introduce id: ")
                var idBiologica = readln().toInt()
                println("Introduce nombre: ")
                var nombreBiologica = readln()
                println("Introduce nivel de Potencia: ")
                var nivelPotenciaBiologica = readln().toInt()
                println("Introduce nivel de daño: ")
                var nivelDanoBiologica = readln().toInt()
                println("Introduce descripcion: ")
                var descripcion = readln()

                var armaBiologica = ArmaBiologica(idBiologica,nombreBiologica,nivelPotenciaBiologica,nivelDanoBiologica,descripcion)
                listaArmas.add(armaBiologica)
                var mutante = Mutante(id,nombre,nivel,armaBiologica)

                listaHeroes.add(mutante)
            }
        }
    }

    fun listarHeroes() {
        listaHeroes.forEach {
            it.mostrarDatos()
        }
    }

    fun listarArmas() {
        listaArmas.forEach {
            it.mostrarDatos()
        }
    }

    fun enfrentarHeroes() {
        if(listaHeroes.size <2) {
            println("No hay suficiente heroes para combate")
            return
        } else {
            println("Introduce id de primer heroe: ")
            var id1 = readln().toInt()
            var heroe1 = listaHeroes.find { it.id == id1 } ?: return println("No existe este id")


            println("Introduce id de segundo heroe: ")
            var id2 = readln().toInt()
            var heroe2 = listaHeroes.find { it.id == id2 } ?: return println("No existe este id")

            var poder1 = heroe1.calcularPoder()
            var poder2 = heroe2.calcularPoder()


            when{
                poder1>poder2-> println("El ganador es ${heroe1.nombre}")
                poder1<poder2-> println("El ganador es ${heroe2.nombre}")
                else -> println("Es un empate")
            }






        }
    }


}