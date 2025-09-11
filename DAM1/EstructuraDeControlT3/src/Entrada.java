public class Entrada {

    public static void main(String[] args) {
        int nota = 6;

        if (nota >= 0 && nota <=10){
            System.out.println("La nota es correcta");
            // decido que tipo de nota es
            // ss -> 0-4.99
            // ap -> 5-6.99
            // nt -> 7-8.99
            // sb -> 9-9.99
            // mt -> 10
            if (nota<5){
                System.out.println("SS");
            } else if (nota<7) {
                System.out.println("AP");
            } else if (nota<9) {
                System.out.println("NT");
            } else if (nota<10) {
                System.out.println("SB");
            } else {
                System.out.println("MT");
            }
        } else {
            System.out.println("La nota no es correcta");
        }

        System.out.println("Terminando la ejecucion");
    }
}
