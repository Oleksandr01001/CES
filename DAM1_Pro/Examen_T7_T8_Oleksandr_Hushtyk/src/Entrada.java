import model.Ejercicio1;
import model.Ejercicio2;
import model.Ejercicio3;
import model.Inventario;

public class Entrada {

    public static void main(String[] args) {
        Ejercicio1 ejercicio1 = new Ejercicio1();
        //ejercicio1.ejercicio1();

        Ejercicio2 ejercicio2 = new Ejercicio2();
        //ejercicio2.descifrador("C:\\Users\\oleks\\Documents\\GitHub\\Oleksandr_Hushtyk_PRO\\Examen_T7_T8_Oleksandr_Hushtyk\\src\\recursos\\ejercicio2.txt");

        Ejercicio3 ejercicio3 = new Ejercicio3();
        ejercicio3.ejercicio4();
        ejercicio3.listarUsuarios();




       /* // Ejercicio 4
        Inventario inventario = new Inventario<>();
        Inventario.Producto producto = inventario.new Producto();

        inventario.agregar("Manzana");
        inventario.agregar("Platano");
        inventario.agregar("Cereza");

        inventario.mostrarInventario();

        */



    }
}
