import java.rmi.Remote
import java.rmi.RemoteException

interface SumaRemota: Remote {
    @Throws(RemoteException::class)
    fun suma(a:Int, b:Int): Int
}