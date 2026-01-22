import java.rmi.registry.LocateRegistry
import java.rmi.registry.Registry

fun main() {
    try {
        // AQUI PONEMOS LA IP DE NAZAR (EL SERVIDOR)
        val ipDelServidor = "192.168.2.218"
        val puerto = 2020

        println("Intentando conectar a $ipDelServidor:$puerto ...")

        val registro: Registry = LocateRegistry.getRegistry(ipDelServidor, puerto)
        val sumaRemota = registro.lookup("SumaRemota") as SumaRemota

        // Probamos la suma
        val resultado = sumaRemota.suma(3, 20)
        println("✅ ¡CONEXIÓN EXITOSA!")
        println("Resultado recibido del servidor: $resultado")

    } catch (e: Exception){
        println("❌ Error conectando al servidor.")
        println("Asegúrate de que Nazar tenga el firewall desactivado y estéis en la misma WiFi.")
        e.printStackTrace()
    }
}