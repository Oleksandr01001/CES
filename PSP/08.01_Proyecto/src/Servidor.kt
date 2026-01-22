import java.rmi.registry.LocateRegistry
import java.rmi.registry.Registry

fun main() {
    val sumaRemota = SumaRemotaImpl()

    try {
        val registro: Registry = LocateRegistry.createRegistry(2020)
        registro.bind("SumaRemota", sumaRemota)
        print("Esta arancado")
    }catch (e: Exception){
        e.printStackTrace()
    }
}