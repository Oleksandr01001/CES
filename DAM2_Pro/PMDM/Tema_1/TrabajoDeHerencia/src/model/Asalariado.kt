package model

import kotlin.random.Random

class Asalariado(nombre: String, apellido: String, dni: String, salario: Double, var nPagas: Int, var irof: Double)
    : Trabajador(nombre,apellido,dni,salario){


    fun pedirAumento() {
        var numRandom = Random.nextInt(1,11);
       if (numRandom < 5) {
           println("Aumentar no, loshara")
       } else {
           salario *= 1.1;
           println("Salario aumentado a 10 porciento")
       }
    }


    override fun calcularSalarioNeto(): Double {
        return salario - (salario * irof)
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("nPagas = ${nPagas}")
        println("irof = ${irof}")
    }
}