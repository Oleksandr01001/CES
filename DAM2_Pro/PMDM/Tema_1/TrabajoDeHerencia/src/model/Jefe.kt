package model

import kotlin.random.Random
import kotlin.random.nextInt

class Jefe (nombre: String, apellido: String, dni: String, salario: Double, var nivelResponsabilidad: Int)
    : Trabajador(nombre,apellido,dni,salario) {


    override fun calcularSalarioNeto(): Double {
        nivelResponsabilidad = Random.nextInt(1,6)
        if (nivelResponsabilidad >= 3) {
            salario *= 1.03
            return salario
        } else {
            salario *= 0.97
            return salario
        }
    }


    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Nivel responsabilidad: $nivelResponsabilidad")
    }

}