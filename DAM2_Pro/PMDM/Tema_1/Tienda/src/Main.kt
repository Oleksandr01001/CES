import model.Producto
import model.Tienda

fun main() {

    var camiseta: Producto = Producto(id = 1, precio = 14.99)
    var zapatillas: Producto = Producto(2,20.0)
    var pantalones = Producto(3,30.0,"Pantalones")
    var gorra = Producto(4,20.0, descripcion = "Gorra molona")
    var cartera = Producto(5, 5.0, "Cartera", "Catrera...")


    var tienda: Tienda = Tienda("Tienda")
    tienda.agregarProducto(gorra)
    tienda.mostrarAlmacen()
    tienda.venderProducto(4)
    tienda.mostrarAlmacen()

    /*
    val listaProductos: Array<Producto?> = arrayOf(camiseta, zapatillas, pantalones, gorra, cartera)
    val listaProductosVasio: Array<Producto?> = arrayOfNulls(5)
    val listaClientes: Array<String> = arrayOf("Borja","Artur")

    listaProductos[0]?.mostrarDatos()
    listaProductos.last()?.precio=20.0
    listaProductos[listaProductos.size-1]?.mostrarDatos()
    listaProductos[2] = null
     */




    /*
    for (i in listaProductos) {
        i?.mostrarDatos()
    }
     */

    /*
    listaProductos.forEach {
        it?.mostrarDatos()
    }
     */

    /*
    listaProductos.forEachIndexed { index, producto ->
        println("Mostrando producto en posicion $index")
        producto?.mostrarDatos()
    }
     */






}