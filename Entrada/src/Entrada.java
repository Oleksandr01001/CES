import java.util.Scanner;
public class Entrada {
    static Scanner lectorTeclado = new Scanner(System.in);

    public static void main(String[] args) {
        //ejercicio1();
        //ejercicio2();
        //ejercicio3();
        //ejercicio4();
        //ejercicio5();
        ejercicio6();
    }
    public static void ejercicio1() {
        final String NOMRE = "Oleksand Hushtyk";
        final String DIRECCION = "Calle Rio Segre";
        final int PORTAL = 6;
        final int PISO = 5;
        final char LETRA = 'C';
        final int CODIGO = 28923;
        final String POBLACION = "Alcorcon";
        final String PROVINCIA = "Madrid";
        final String PAIS = "España";

        System.out.println(NOMRE);
        System.out.printf("%s n%d %d%c\n",DIRECCION,PORTAL,PISO,LETRA);
        System.out.printf("%d, %s, %s\n", CODIGO, POBLACION, PROVINCIA);
        System.out.println(PAIS);
    }
    public static void ejercicio2() {
        System.out.println("Escribe tu nombre completo: ");
        String nombreCompleto = lectorTeclado.nextLine();
        System.out.println("Escribe tu edad: ");
        int edad = lectorTeclado.nextInt();
        System.out.println("Te llamas "+nombreCompleto);
        System.out.println("Tienes "+edad+" años");
        System.out.println("Pulsa enter para continuar");

    }
    public static void ejercicio3() {
        System.out.println("Escribe primer numero:");
        int numero1 = lectorTeclado.nextInt();
        System.out.println("Escribe segundo numero");
        int numero2 = lectorTeclado.nextInt();
        int suma = numero1 + numero2;
        int resta = numero1 - numero2;
        int multiplicacion = numero1 * numero2;
        int divisionEntera = numero1 / numero2;
        float resto = (float)numero1 % numero2;
        float divisionReal = (float)numero1 / numero2;
        float restoReal = (float)numero1 % numero2;
        System.out.printf("Suma = %d\nResta = %d\nMultiplicacion = %d\nDivision = %d\nResto = %3f\nDivision Real = " +
                "%3f\nResto Real = %3f",suma,resta,multiplicacion,divisionEntera,resto,divisionReal,restoReal);
    }
    public static void ejercicio4() {
        float bebida = 1.25f;
        float bocadillo = 2.05f;
        System.out.println("Cuantas bebidas pedis?");
        int bebidas = lectorTeclado.nextInt();
        System.out.println("Cuantos bocadillos pedis?");
        int bocadillos = lectorTeclado.nextInt();
        float precioBebida = (float)bebida * bebidas;
        float precioBocadillos = (float)bocadillo * bocadillos;
        float precioTotal = precioBocadillos + precioBebida;


        System.out.printf("Numero de bebidas: %d\nNumero de bocadillos: %d\nCoste de lsa bebidas: %.2f\nCoste de los bocadillos %.2f\nCoste consumicion: %.2f", bebidas,bocadillos,precioBebida,precioBocadillos,precioTotal);

    }
    public static void ejercicio5() {
        System.out.println("Por favor escribe los segundos:");
        int segundos = lectorTeclado.nextInt();
        int horas = segundos/3600;
        segundos = segundos%3600;
        int minutos = segundos/60;
        segundos = segundos%60;
        System.out.println("horas: "+horas);
        System.out.println("minutos: "+minutos);
        System.out.println("segundos: "+segundos);

    }
    public static void ejercicio6() {
        System.out.println("Por favor escribe el numero:");
        float valor = lectorTeclado.nextFloat();
        System.out.printf("Valor de la compra (entre 0.00 y 500.00):%.2f",valor);
        System.out.println("Por favor escribe IVA:");
        int IVA = lectorTeclado.nextInt();
        System.out.printf("IVA (entre 0 y 25): %d\n",IVA);
        float compra = valor-(valor*IVA/100);
        System.out.println("Compra:"+compra);
        float valorIVA = valor - compra;
        System.out.println("IVA:"+valorIVA);
        System.out.println("========");
        float total = compra + valorIVA;
        System.out.println(total);


    }
}
