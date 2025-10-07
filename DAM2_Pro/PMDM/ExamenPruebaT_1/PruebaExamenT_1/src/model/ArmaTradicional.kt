package model

class ArmaTradicional(
    id: Int, nombre: String, nivelPotencia: Int, nivelDano: Int, var peso: Double
) : Arma(id, nombre, nivelPotencia, nivelDano) {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Peso: ${peso}")
    }
}