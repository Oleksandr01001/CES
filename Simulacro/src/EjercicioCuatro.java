public class EjercicioCuatro {
    public static void main(String[] args) {

        int precio = 30000;
        int mesReduccion = 5000;
        float interes = 3.5f;

        float mes1 = precio * (interes / 100);
        System.out.printf("El interés pagado (%.1f) en el primer mes es de %.0f -> %.1f de %d\n",interes,mes1,interes,precio);
        interes += 3.5;
        precio -= mesReduccion;

        float mes2 = precio * (interes / 100);
        System.out.printf("El interés pagado (%.1f) en el segundo mes es de %.0f -> %.1f de %d\n",interes,mes2,interes,precio);
        interes += 3.5;
        precio -= mesReduccion;

        float mes3 = precio * (interes / 100);
        System.out.printf("El interés pagado (%.1f) en el segundo mes es de %.0f -> %.1f de %d\n",interes,mes3,interes,precio);
        interes += 3.5;
        precio -= mesReduccion;

        float mes4 = precio * (interes / 100);
        System.out.printf("El interés pagado (%.1f) en el segundo mes es de %.0f -> %.1f de %d\n",interes,mes4,interes,precio);
        interes += 3.5;
        precio -= mesReduccion;

        float mes5 = precio * (interes / 100);
        System.out.printf("El interés pagado (%.1f) en el segundo mes es de %.0f -> %.1f de %d\n",interes,mes5,interes,precio);
        interes += 3.5;
        precio -= mesReduccion;

        float mes6 = precio * (interes / 100);
        System.out.printf("El interés pagado (%.1f) en el segundo mes es de %.0f -> %.1f de %d\n",interes,mes6,interes,precio);
        interes += 3.5;
        precio -= mesReduccion;

    }
}
