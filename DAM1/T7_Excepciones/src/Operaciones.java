import java.io.File;
import java.io.IOException;

public class Operaciones {



    public void divicionEntre0(int numero) throws ArithmeticException {
        System.out.println("Procedemos a divider un numero entre 0");
        System.out.println("La divicion del numro es "+numero/0);
    }

    public void crearFichero(String path) throws IOException{
        File file = new File(path);
        file.createNewFile();
    }
}
