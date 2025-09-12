package controller;

import model.Factura;
import model.FacturaDTO;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class LeerExcel {

    public void leerYInsertarFacturas(String rutaArchivo) {
        try (FileInputStream fis = new FileInputStream(rutaArchivo);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                String numeroFactura = getCellValue(row.getCell(0));
                String nombre = getCellValue(row.getCell(1));
                String direccion = getCellValue(row.getCell(2));
                String email = getCellValue(row.getCell(3));
                String productos = getCellValue(row.getCell(4));
                String precioStr = getCellValue(row.getCell(5)).replace(",", ".");

                double precio = 0.0;
                try {
                    precio = Double.parseDouble(precioStr);
                } catch (NumberFormatException e) {
                    System.out.println("Atención: formato de precio incorrecto en fila " + i + " → se usará 0.0");
                }

                Factura factura = new Factura(numeroFactura, nombre, direccion, email, productos, precio);

                FacturaDTO facturaDTO = new FacturaDTO();
                facturaDTO.insertarFactura(factura);
            }

            System.out.println("Lectura finalizada y facturas insertadas correctamente.");

        } catch (IOException e) {
            System.err.println("Error al leer el archivo Excel: " + e.getMessage());
        }
    }

    // ✅ Допоміжний метод для отримання значення клітинки
    private String getCellValue(Cell cell) {
        if (cell == null) return "";
        return switch (cell.getCellType()) {
            case NUMERIC -> String.valueOf(cell.getNumericCellValue());
            case STRING -> cell.getStringCellValue();
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            case FORMULA -> cell.getCellFormula();
            default -> "";
        };
    }
}
