package controller;

import model.Factura;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReader {

    public static List<Factura> leerFacturasDesdeExcel(String rutaArchivo) {
        List<Factura> facturas = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(rutaArchivo);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet hoja = workbook.getSheetAt(0);
            Iterator<Row> filas = hoja.iterator();

            if (filas.hasNext()) {
                filas.next(); // saltar la cabecera
            }

            while (filas.hasNext()) {
                Row fila = filas.next();
                Factura factura = new Factura();

                factura.setNumero(getCellString(fila.getCell(0)));
                factura.setNombre(getCellString(fila.getCell(1)));
                factura.setDireccion(getCellString(fila.getCell(2)));
                factura.setEmail(getCellString(fila.getCell(3)));
                factura.setProductos(getCellString(fila.getCell(4)));

                Cell cellPrecio = fila.getCell(5);
                if (cellPrecio != null && cellPrecio.getCellType() == CellType.NUMERIC) {
                    factura.setPrecio(cellPrecio.getNumericCellValue());
                } else if (cellPrecio != null && cellPrecio.getCellType() == CellType.STRING) {
                    factura.setPrecio(Double.parseDouble(cellPrecio.getStringCellValue().replace(",", ".")));
                } else {
                    factura.setPrecio(0.0);
                }

                facturas.add(factura);
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo Excel: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }

        return facturas;
    }

    private static String getCellString(Cell cell) {
        if (cell == null) return "";
        switch (cell.getCellType()) {
            case STRING: return cell.getStringCellValue();
            case NUMERIC: return String.valueOf((int) cell.getNumericCellValue());
            case BOOLEAN: return String.valueOf(cell.getBooleanCellValue());
            default: return "";
        }
    }
}
