package model

class Tienda(var nombreTienda: String) {

    var caja: Double = 0.0
    lateinit var almacen: Array<Producto?>

    init {
        almacen = arrayOfNulls(6)
    }

    fun mostrarAlmacen() {
        var nulos = 0
        almacen.forEach {
            it?.mostrarDatos() ?: nulos++
        }
        if (nulos == almacen.size)
            println("No hay productos en el almacen")

        println("En la caja hay: $caja")
    }

    fun agregarProducto(producto: Producto) {
        for (i in 0.. almacen.size-1) {
            if (almacen[i] == null) {
                almacen[i] = producto
                println("Producto agregado")
                return
            }
        }
        println("No hay espacio en el almacen")
    }

    fun venderProducto(id: Int) {
        for (i in 0..almacen.size-1) {
            if(almacen[i]?.id == id) {
                caja += almacen[i]!!.precio
                almacen[i] = null
                println("Producto vendido")
                return
            }
        }
        println("El id indicado no esta en la lista")
    }






}