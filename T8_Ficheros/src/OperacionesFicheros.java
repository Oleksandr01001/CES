import java.io.*;

public class OperacionesFicheros {

    public void cifrarMensaje(String mensaje, int fase, String path) {

        File file = new File(path);
        FileWriter fileWriter = null;


        // Este mensaje sera cifrado

        try {
            fileWriter = new FileWriter(file, true);
            for (int i = 0; i < mensaje.length(); i++) {
                char letra = mensaje.charAt(i);
                int codigo = letra;
                int codigoCifrado = codigo * fase;
                //System.out.println(codigoCifrado);
                fileWriter.write(String.valueOf(codigoCifrado) + " ");
            }



           // fileWriter.write(mensaje);
        } catch (IOException e) {
            System.out.println("Error en la entrada/salida");
        } finally {
            try {
                fileWriter.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado");
            }
        }

    }

    public void descifrarMensaje(int fase, String path) {

        File file = new File(path);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;


        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String lectura = null;
            while ((lectura = bufferedReader.readLine())!=null) {
                String[] codigos = lectura.split(" ");
                for (String codigo : codigos) {
                    int codigoDescifrado = Integer.valueOf(codigo)/fase;
                    System.out.println((char) codigoDescifrado);
                }
            }



        } catch (FileNotFoundException e) {
            System.out.println("Error en la lectura");
        } catch (IOException e) {
            System.out.println("No tienes permisos de lectura");
        } finally {
            try {
                fileReader.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en la entrada/salida");
            }
        }


    }
}
