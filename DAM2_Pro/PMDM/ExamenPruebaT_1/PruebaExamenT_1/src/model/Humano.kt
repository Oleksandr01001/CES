package model


class Humano(
    id: Int, nombre: String, nivel: Int, var resistencia: Int, var arma: ArmaTradicional
) : Superheroe(id, nombre, nivel) {

    override fun calcularPoder(): Int {
        return (nivel + (arma.nivelPotencia*arma.nivelDano))
    }


    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Resistencia: ${resistencia}")
        println("Arma: ${arma.nombre}")
    }

}