package model

class Mutante(
    id: Int, nombre: String, nivel: Int, var arma: ArmaBiologica
) : Superheroe(id, nombre, nivel) {


    override fun calcularPoder(): Int {
        return (nivel + (arma.nivelPotencia*arma.nivelDano))
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Arma: ${arma.nombre}")
    }

}