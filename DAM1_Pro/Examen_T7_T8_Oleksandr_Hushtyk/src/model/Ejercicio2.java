package model;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio2 {

    public void descifrador(String path){


        File file = new File(path);
        FileReader fileReader = null;

        try{
            fileReader = new FileReader(file);
            int codigolector = -1;
            int fase = 4;
            while ((codigolector = fileReader.read())!=-1){
                int codigoDescifrado = codigolector / fase;
                System.out.print((char)codigoDescifrado);

            }
        } catch (IOException e) {
            System.out.println("Error en entrada/salida");
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }finally {
            try{
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error en cerrado");
            }
        }




    }

}