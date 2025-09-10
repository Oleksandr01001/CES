public class Entrada {

    public static void main(String[] args) {

        OperacionesFicheros operacionesFicheros = new OperacionesFicheros();
       // operacionesFicheros.cifrarMensaje("Este mensaje sera cifrado",3,"C:\\Users\\oleks\\Documents\\GitHub\\Oleksandr_Hushtyk_PRO\\T8_Ficheros\\src\\recursos\\cifrado.txt");

        operacionesFicheros.descifrarMensaje(3, "src/recursos/cifrado.txt");
    }
}
