import model.Asalariado;

public class Entrada {

    public static void main(String[] args) {
        Asalariado asalariado = new Asalariado(20000.0,12345,"hush","olek",0.21,14);
        asalariado.calcularSalarioMes();
    }
}
