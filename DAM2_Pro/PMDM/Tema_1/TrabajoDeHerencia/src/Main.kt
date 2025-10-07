import model.Asalariado
import model.Autonomo
import model.Directivo
import model.Jefe
import model.Persona
import model.Sindicato
import model.Trabajador
import kotlin.reflect.typeOf

fun main() {
    // var persona = Persona("Borja", "Martin","123A")
    // persona.mostrarDatos()
    // var trabajador = Trabajador("Borja","Martin","1234A",40000,12,true,91111111,"borja@gmail.com")
    val asalariado = Asalariado("BorjaAs","Martin","1234A",40000.0,12,0.10)
    val autonomo = Autonomo("BorjaAu","Martin","1234A",40000.0,true,300)
    val jefe = Jefe("BorjaJe","Martin","1234A",40000.0,1)
    val directivo = Directivo("BorjaDr","Martin","1234A",622530945,"Borja@gmail.com",2)
    val trabajadores = arrayListOf<Persona>(asalariado,autonomo,jefe,directivo)
    /*trabajadores.forEach {
        if (it is Trabajador) {
            println("Calculando salario del trabajador: ${it.calcularSalarioNeto()}")
        }
        it.mostrarDatos()
        println()
    }
     */

    trabajadores.forEach {
        if (it is Sindicato) {
            it.calcularBeneficios()
        }
    }












}