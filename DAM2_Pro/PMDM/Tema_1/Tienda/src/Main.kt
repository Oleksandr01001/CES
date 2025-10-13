import model.*

fun main() {

    var tienda = Tienda("Tienda")
    var cliente: Cliente? = null
    var salir = false

    while (!salir) {
        println("1. Agregar producto")
        println("2. Mostrar almacen")
        println("3. Vender producto")
        println("4. Buscar por categoria")
        println("5. Buscar por id")
        println("6. Crear cliente")
        println("7. Agregar al carrito")
        println("8. Mostrar carrito")
        println("9. Ver producto del carrito")
        println("10. Borrar del carrito")
        println("11. Pedir factura")
        println("0. Salir")
        print("Opcion: ")

        var opcion = readln().toInt()

        when (opcion) {

            1 -> {
                print("id: ")
                var id = readln().toInt()
                print("precio: ")
                var precio = readln().toDouble()
                println("1. Tecnologia  2. Muebles  3. Ropa  4. Generica")
                print("elige categoria: ")
                var num = readln().toInt()
                var cat = if (num == 1) Categoria.Tecnologia
                else if (num == 2) Categoria.Muebles
                else if (num == 3) Categoria.Ropa
                else Categoria.Generica
                print("nombre: ")
                var nombre = readln()
                print("descripcion: ")
                var desc = readln()
                var p = Producto(id, precio, cat, nombre, desc)
                tienda.agregarProducto(p)
            }

            2 -> tienda.mostrarAlmacen()

            3 -> {
                print("id del producto a vender: ")
                var id = readln().toInt()
                tienda.venderProducto(id)
            }

            4 -> {
                println("1. Tecnologia  2. Muebles  3. Ropa  4. Generica")
                print("elige categoria: ")
                var num = readln().toInt()
                var cat = if (num == 1) Categoria.Tecnologia
                else if (num == 2) Categoria.Muebles
                else if (num == 3) Categoria.Ropa
                else Categoria.Generica
                tienda.buscarProductosCategoria(cat)
            }

            5 -> {
                print("id a buscar: ")
                var id = readln().toInt()
                tienda.buscarProductoId(id)
            }

            6 -> {
                print("id cliente: ")
                var id = readln().toInt()
                print("nombre: ")
                var nombre = readln()
                cliente = Cliente(id, nombre)
                println("cliente creado")
            }

            7 -> {
                if (cliente == null) {
                    println("crea un cliente primero")
                } else {
                    print("id del producto para agregar al carrito: ")
                    var id = readln().toInt()
                    var prod = tienda.almacen.find { it?.id == id }
                    if (prod != null) {
                        cliente!!.agregarProductoCarrito(prod)
                    } else {
                        println("producto no encontrado")
                    }
                }
            }

            8 -> {
                if (cliente == null) println("no hay cliente")
                else cliente!!.mostrarCarrito()
            }

            9 -> {
                if (cliente == null) println("no hay cliente")
                else {
                    print("posicion: ")
                    var pos = readln().toInt()
                    cliente!!.accesoPorPosicion(pos)
                }
            }

            10 -> {
                if (cliente == null) println("no hay cliente")
                else {
                    print("id del producto a borrar: ")
                    var id = readln().toInt()
                    cliente!!.borrarElementos(id)
                }
            }

            11 -> {
                if (cliente == null) println("no hay cliente")
                else cliente!!.pedirFactura()
            }

            0 -> {
                println("saliendo...")
                salir = true
            }

            else -> println("opcion no valida")
        }

        println()
    }
}
