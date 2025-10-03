package model

class Autonomo(nombre: String, apellido: String, dni: String, salario: Double, var seguro: Boolean, var cuota: Int)
    : Trabajador(nombre,apellido,dni,salario){


    fun pedirDescuento() {
        if (seguro) {
            cuota /= 2
            println("Tu cuota se ha dividido entre 2: $cuota")
        } else {
            println("No tienes seguro")
        }
    }


    override fun calcularSalarioNeto(): Double {
        return salario - (cuota * 12)
    }


    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Seguro: ${seguro}")
    }


}