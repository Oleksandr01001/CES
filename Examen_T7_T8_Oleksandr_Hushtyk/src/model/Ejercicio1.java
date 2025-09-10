package model;

import java.io.*;

public class Ejercicio1 {
    public void lecturaFichero(String path) {
        File file = new File(path);
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String lectura;

            while ((lectura = bufferedReader.readLine()) != null) {
                String[] codigos = lectura.split(" ");
                for (String codigo : codigos) {
                    try {
                        int codigoDescifrado = Integer.parseInt(codigo);
                        System.out.print((char) codigoDescifrado);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: No se pudo convertir a número.");
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error al encontrar el fichero.");
        } catch (IOException e) {
            System.out.println("Error en la lectura del archivo.");
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo.");
            }
        }
    }
}