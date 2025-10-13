package model

class Cliente(var id: Int, var nombre: String) {
    lateinit var carrito: ArrayList<Producto>
    var factura: Double = 0.0

    init {
        // carrito = ArrayList()
        carrito = arrayListOf()
    }

    fun agregarProductoCarrito(producto: Producto) {

        carrito.add(producto)
        println("Producto agregado al carrito correctamente")
    }

    // mostrar todos los elementos del carrito
    fun mostrarCarrito() {
        if (carrito.isEmpty()) {
            println("No hay nada en el carrito")
        } else {
            carrito.forEach { it.mostrarDatos() }
        }
    }


    fun accesoPorPosicion(posicon: Int) {
        if (posicon > carrito.size - 1) {
            println("ID fuera de rango")
        } else {
            carrito[posicon].mostrarDatos()
        }
    }

    fun borrarElementos(id: Int) {

        var listaFiltrada = carrito.filter {
            return@filter it.id == id
        }

        if (listaFiltrada.isEmpty()) {
            println("el numero de resultado es ${listaFiltrada.size} por lo que no se puede borrar")
        } else if (listaFiltrada.size == 1) {
            carrito.remove(listaFiltrada.first())
            // carrito.removeFirst()
            println("Borrado correctamente")
        } else {
            println(
                "Se han encontrado varias coincidencias, " +
                        "cual quieres borrar: (1 para el primero / n para todos)"
            )
            val opcion: String = readln()
            if (opcion.equals("1", true)) {
                carrito.remove(listaFiltrada.first())
            } else if (opcion.equals("n", true)) {
                carrito.removeAll(listaFiltrada.toSet())
            }
        }
    }

    fun pedirFactura() {
        if (carrito.isEmpty()){
            println("No puedes pedir, no hay productos en carrito")
        } else{
            carrito.forEach {
                factura+=it.precio
            }
            println("Debes un total de $factura")
            carrito.clear()
            factura = 0.0
        }
    }

}