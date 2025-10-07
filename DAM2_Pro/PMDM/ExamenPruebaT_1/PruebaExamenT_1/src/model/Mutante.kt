package model

class Mutante(
    id: Int, nombre: String, nivel: Int, var arma: ArmaBiologica
) : Superheroe(id, nombre, nivel) {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Arma: ${arma.mostrarDatos()}")
    }

}