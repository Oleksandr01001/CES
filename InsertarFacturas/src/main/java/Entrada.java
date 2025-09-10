import controller.ExcelReader;
import model.Factura;
import model.FacturaDTO;

import java.util.List;

public class Entrada {
    public static void main(String[] args) {
        String rutaArchivo = "C:\\Users\\artur\\Facturas.xlsx";


        List<Factura> listaFacturas = ExcelReader.leerFacturasDesdeExcel(rutaArchivo);


        FacturaDTO facturaDTO = new FacturaDTO();

        
        for (Factura factura : listaFacturas) {
            facturaDTO.insertarFactura(factura);
        }

        System.out.println("Proceso completado. Todas las facturas han sido guardadas en la base de datos.");
    }
}
