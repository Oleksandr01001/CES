package model


class Producto(
    var id: Int,
    var precio: Double=10.0,
    var categoria: Categoria = Categoria.Generica,
    var nombre: String?=null,
    var descripcion : String?=null ) {




    /*
    constructor(id: Int, precio: Double, nombre: String): this(id,precio) {
        this.nombre = nombre
    }

    constructor(id: Int, precio: Double, descripcion: String?): this(id, precio) {
        this.descripcion = descripcion
    }

    constructor(id: Int, precio: Double, nombre: String, descripcion: String?): this(id, precio) {
        this.nombre = nombre
        this.descripcion = descripcion
    }
     */

    fun mostrarDatos() {
        println("ID: $id")
        println("Precio: $precio")
        println("Nombre: ${nombre ?: "SIN DEFINIR"}")
        println("Categoria: ${categoria}")
        println("Descripcion: ${descripcion ?: "SIN DEFINIR"}")
        println()
    }




}