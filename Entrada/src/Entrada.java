import java.util.Scanner;
import java.lang.*;
public class Entrada {
    static Scanner lectorTeclado = new Scanner(System.in);

    public static void main(String[] args) {
        //ejercicio1();
        //ejercicio2();
        //ejercicio3();
        //ejercicio4();
        //ejercicio5();
        //ejercicio6();
        //ejercicio7();
        //ejercicio8();
        //ejercicio9();
        //ejercicio10();
        //ejercicio11();
        //ejercicio12();
        //ejercicio13();
        //ejercicio14();
        //ejercicio15();
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
    public static void ejercicio7() {
        System.out.println("Escribe un radio entero: ");
        int radio = lectorTeclado.nextInt();
        //double longitud = valor * (Math.PI * 2);
        double longitud = 2 * Math.PI * radio;
        System.out.println("Longitud de la circunferencia: "+longitud);
        //double area = Math.PI * valor * 2;
        double area = Math.PI * Math.pow(radio, 2);
        System.out.println("Area de circulo: "+area);
    }
    public static void ejercicio8() {
        System.out.println("Escribe los grados centigrados: ");
        float c = lectorTeclado.nextFloat();
        float f = (9 * c) / 5 + 32;
        float k = c + 273.15f;
        System.out.printf("Grados centigrados: %.2f\nFarenheit: %.2f Kelvin: %.2f\n",c,f,k);
        System.out.println("Escribe los grados Farenheit: ");
        float f2 = lectorTeclado.nextFloat();
        float c2 = (float) (5 * (f2 - 32)) / 9;
        float k2 = (float)((double) (5 * (f2 - 32) / 9) + 273.15);
        System.out.printf("Grados Farenheit: %.2f\nCentigrados: %.2f Kelvin: %.2f\n",f2,c2,k2);
        System.out.println("Escribe los grados Kelvin: ");
        float k3 = lectorTeclado.nextFloat();
        float c3 = (float) (k3 - 273.15);
        float f3 = (float) ((9 * (k3 - 273.15) / 5) + 32);
        System.out.printf("Grados Kelvin: %.2f\nCentigrados: %.2f Farenheit: %.2f",k3,c3,f3);
    }
    public static void ejercicio9() {
        System.out.println("Introduce el precio de las bebidas:");
        float bebida = lectorTeclado.nextFloat();
        System.out.println("Introduce el presio de los bocadillos:");
        float bocadillo = lectorTeclado.nextFloat();
        System.out.println("Cuantas bebidas pedis?");
        int bebidas = lectorTeclado.nextInt();
        System.out.println("Cuantos bocadillos pedis?");
        int bocadillos = lectorTeclado.nextInt();
        float precioBebida = (float)bebida * bebidas;
        float precioBocadillos = (float)bocadillo * bocadillos;
        float precioTotal = precioBocadillos + precioBebida;
        System.out.println("ATRIBUTO\t\tCANTIDAD\tPRECIO\t\tCOSTE\n");
        System.out.println("============ =========== ============= ==============");
        System.out.printf("Bebida\t\t\t\t%d\t\t%.2f\t\t%.2f\n",bebidas,bebida,precioBebida);
        System.out.printf("Bocadillo\t\t\t%d\t\t%.2f\t\t%.2f\n",bocadillos,bocadillo,precioBocadillos);
        System.out.println("                                        ============");
        System.out.println("Precio total:                             "+precioTotal);
        System.out.println("________________________________________________________");
    }
    public static void ejercicio10() {
        System.out.println("Decenas de mil:");
        int decenas_Mil = lectorTeclado.nextInt();
        System.out.println("Unidades de mil:");
        int unidades_Mil = lectorTeclado.nextInt();
        System.out.println("Centenas:");
        int centenas = lectorTeclado.nextInt();
        System.out.println("Decenas:");
        int decenas = lectorTeclado.nextInt();
        System.out.println("Unidades:");
        int unidades = lectorTeclado.nextInt();
        System.out.printf("Decenas de mil: %d\nUnidades de mil: %d\nCentenas: %d\nDecenas: %d\nUnidades: %d\n",decenas_Mil,unidades_Mil,centenas,decenas,unidades);
        System.out.println("Numero introducido: "+decenas_Mil+unidades_Mil+centenas+decenas+unidades);
    }
    public static void ejercicio11() {
        System.out.println("Intoduce el numero:");
        int n = lectorTeclado.nextInt();
        boolean esPar = (n % 2 == 0);
        boolean mayor = (n > 50);
        System.out.printf("Es par: %b\nMayor que 50: %b",esPar,mayor);
    }
    public static void ejercicio12() {

        System.out.println("Escribe la primera cadena: ");
        String cadena1 = lectorTeclado.nextLine();

        System.out.println("Escribe la segunda cadena: ");
        String cadena2 = lectorTeclado.nextLine();

        boolean iguales = cadena1.equals(cadena2);;
        System.out.printf("Son iguales:%b\n",iguales);

        boolean menor = (cadena1.length()<cadena2.length());
        System.out.printf("La primera es menor que segunda:%b\n",menor);

        boolean distintas = !iguales;
        System.out.printf("Son distintas:%b",distintas);
    }
    public static void ejercicio13() {
        System.out.println("Escribe un numero entre 0 y 9:");
        int n1 = lectorTeclado.nextInt();
        System.out.println("Escribe un numero entre 0 y 9:");
        int n2 = lectorTeclado.nextInt();
        boolean a = (n1 % 2 == 0 && n2 % 2 != 0);
        boolean b = (n1 > n2 * 2 && n1 < 8);
        boolean c = (n1 == n2) || ((n1 - n2) < 2);
        System.out.printf("El primero es par y el segundo impar: %b\nEl primero es superior al doble del segundo e inferior a 8: %b\nSon iguales o la diferencia entre el primero y el segundo es menor que 2: %b",a,b,c);
    }
    public static void ejercicio14() {
        System.out.println("Introduzca su edad:");
        int edad = lectorTeclado.nextInt();
        System.out.println("Introduzca su nivel de estudios de 1 a 10:");
        int nivelEstudios = lectorTeclado.nextInt();
        System.out.println("Introduzca sus ingresos de 0 a 25000:");
        int ingresos = lectorTeclado.nextInt();

        boolean m = (edad > 40) && (5 <= nivelEstudios && nivelEstudios <= 8) && (ingresos >= 15000);
        System.out.printf("Mas de 40 años y estudios entre 5 y 8 y gana menos de 15000: %b",m);
    }
    public static void ejercicio15() {
        System.out.println("Introduzca un numero entero:");
        int numero = lectorTeclado.nextInt();
        int a = numero += 5;
        int b = numero -= 3;
        int c = numero *= 10;
        int d = numero /= 2;
        System.out.printf("Incrementar 5 unidades: %d\nDecrementar 3 unidades: %d\nMultiplicar por 10: %d\n" +
                                                                        "Dividir por 2: %d",a,b,c,d);
    }
}
