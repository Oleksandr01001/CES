public class Entrada {

    static int edadClace = 50;

    // mod_acc mod_adional mod_ret nombre (argumentos) {cuerpo}

    public static void main (String[] args){

        miMetodo();
        edadClace = 20;
        System.out.println("Proyecto de variables");

        // Tipo nombre = valor (el valor es opcional)
        String nombre = "Oleksandr";
        final String CIF = "B12345"; // la variable final se escribe todo en mayuscula
        char letra = 'A';


        short numeroPequenio = 23; // numero pequeño (-255,255)
        int edad = 17;  // numeros sin decimal (-65.435, 65.435)
        System.out.println("Mi edad es " +edad);
        edad = 18;
        System.out.println("Cambiando edad");
        System.out.println("Mi edad es " +edad);
        long telefono = 123456789;

        float altura = 3.14f;
        double decimalesDetalle = 3.1415163456;

        boolean carnet = true; // false


    }

    public static void miMetodo(){
        String nombre = "Julia";
        int edad = 40;
        edadClace = 30;
        System.out.println(edadClace);

        //System.out.println(this.edadClace);
    }

    public static void otroMetodo(){

    }
}
