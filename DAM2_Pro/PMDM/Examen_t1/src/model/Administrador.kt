package model

class Administrador(
    id: Int, nombre: String, var clave: Int
) : Persona(id, nombre){

    var clavePermanente : Int = 1111

    fun inciarLiga() {

    }

    fun autorizacion(clave: Int) : Boolean{
        if (clave == clavePermanente) {
            return true
        } else {
            return false
        }
    }
}