package model

class ArmaBiologica(
    id: Int, nombre: String, nivelPotencia: Int, nivelDano: Int, var descripcion: String
) : Arma(id, nombre, nivelPotencia, nivelDano) {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Descripcion: ${descripcion}")
    }
}