import java.rmi.RemoteException
import java.rmi.server.UnicastRemoteObject

class SumaRemotaImpl: UnicastRemoteObject(), SumaRemota{
    @Throws(RemoteException::class)
    override fun suma(a: Int, b: Int): Int {
        return a+b
    }

}