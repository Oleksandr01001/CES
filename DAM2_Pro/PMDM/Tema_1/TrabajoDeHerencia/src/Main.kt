import model.Persona
import model.Trabajador

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    //var persona1 = Persona("Borja","Martin","123A",123,"borja@gmail.com")
    //var persona2 = Persona("Borja","Martin","123A")

    //persona2.mostrarDatos()

    var tabajador = Trabajador("Borja","Martin","1234A",
        40000,12,9111111,"borja@gmail.com",true)
    tabajador.mostrarDatos()

}