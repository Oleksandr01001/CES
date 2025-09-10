import controller.LeerExcel;

public class Entrada {
    public static void main(String[] args) {
        LeerExcel lector = new LeerExcel();
        lector.leerYInsertarFacturas("C:\\Users\\oleks\\Documents\\Facturas\\Facturas.xlsx"); // постав свій шлях!
    }
}
