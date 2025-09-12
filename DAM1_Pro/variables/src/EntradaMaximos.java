public class EntradaMaximos {


    public static void main(String[]args){
        maximos();



    }
    public static void maximos(){
        System.out.println("Short max ="+ Short.MAX_VALUE );
        System.out.println("Short min ="+ Short.MIN_VALUE);
        System.out.println("Int max ="+ Integer.MAX_VALUE );
        System.out.println("Int min ="+ Integer.MIN_VALUE);
        System.out.println("Char max ="+ Character.MAX_VALUE);
        System.out.println("Char min ="+ Character.MIN_VALUE);
        System.out.println("Double max ="+ Double.MAX_VALUE);
        System.out.println("Double min ="+ Double.MIN_VALUE);
        System.out.println("Float max ="+ Float.MAX_VALUE);
        System.out.println("Float min ="+ Float.MIN_VALUE);

        System.out.printf("El valor minimo del Byte es %d y el maximo es %d\n", Byte.MIN_VALUE, Byte.MAX_VALUE);



    }
}
