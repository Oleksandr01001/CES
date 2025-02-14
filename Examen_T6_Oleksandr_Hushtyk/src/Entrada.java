import controller.Stock;
import model.Bicicletas;
import model.Coche;
import model.Motos;
import model.Patinete;

import java.util.Scanner;

public class Entrada {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String numSerie, marca, modelo, estado, transmision,  tipo;
        int precio, autonomia, cv, cc, peso;
        String tipoVehiculo;


        Stock stock = new Stock();



        int opcion = 0;

        do {
            System.out.println("1.Agregar vehículo para stock");
            System.out.println("2.Buscar en stock");
            System.out.println("3.Vender vehículo");
            System.out.println("4.Reparar vehículo y agregarlo al stock");
            System.out.println("5.Ver resultado caja");
            System.out.println("0.Salir de la aplicacion");

            System.out.println("Elige la opcion: ");
            opcion = scanner.nextInt();


            switch (opcion) {
                case 1:
                    System.out.println("Que vehiculo quiere agregar?");
                    tipoVehiculo = scanner.next();

                    switch (tipoVehiculo.toLowerCase()) {
                        case "patinete":
                            System.out.println("Introduce numero de serie: ");
                            numSerie = scanner.next();
                            System.out.println("Introduce marca: ");
                            marca = scanner.next();
                            System.out.println("Introduce modelo: ");
                            modelo = scanner.next();
                            System.out.println("Introduce estado: ");
                            estado = scanner.next();
                            System.out.println("Introduce precio: ");
                            precio = scanner.nextInt();
                            System.out.println("Introduce autonomia: ");
                            autonomia = scanner.nextInt();

                            stock.agragarVehculo(new Patinete(numSerie,marca,modelo,estado,precio,autonomia));
                            break;
                        case "coche":
                            System.out.println("Introduce numero de serie: ");
                            numSerie = scanner.next();
                            System.out.println("Introduce marca: ");
                            marca = scanner.next();
                            System.out.println("Introduce modelo: ");
                            modelo = scanner.next();
                            System.out.println("Introduce estado: ");
                            estado = scanner.next();
                            System.out.println("Introduce precio: ");
                            precio = scanner.nextInt();
                            System.out.println("Introduce caballos: ");
                            cv = scanner.nextInt();
                            System.out.println("Introduce centimetros cubicos: ");
                            cc = scanner.nextInt();

                            stock.agragarVehculo(new Coche(numSerie,marca,modelo,estado,precio,cv,cc));
                            break;
                        case "moto":
                            System.out.println("Introduce numero de serie: ");
                            numSerie = scanner.next();
                            System.out.println("Introduce marca: ");
                            marca = scanner.next();
                            System.out.println("Introduce modelo: ");
                            modelo = scanner.next();
                            System.out.println("Introduce estado: ");
                            estado = scanner.next();
                            System.out.println("Introduce precio: ");
                            precio = scanner.nextInt();
                            System.out.println("Introduce transmicion: ");
                            transmision = scanner.next();
                            System.out.println("Introduce peso: ");
                            peso = scanner.nextInt();

                            stock.agragarVehculo(new Motos(numSerie,marca,modelo,estado,precio,transmision,peso));
                            break;
                        case "bicicleta":
                            System.out.println("Introduce numero de serie: ");
                            numSerie = scanner.next();
                            System.out.println("Introduce marca: ");
                            marca = scanner.next();
                            System.out.println("Introduce modelo: ");
                            modelo = scanner.next();
                            System.out.println("Introduce estado: ");
                            estado = scanner.next();
                            System.out.println("Introduce precio: ");
                            precio = scanner.nextInt();
                            System.out.println("Introduce tipo de la bici: ");
                            tipo = scanner.next();

                            stock.agragarVehculo(new Bicicletas(numSerie,marca,modelo,estado,precio,tipo));
                            break;
                        default:
                            System.out.println("Error...");
                    }
                    break;
                case 2:
                    stock.mostrarVehiculos();
                    break;
                case 3:
                    System.out.println("Que vehiculo quiere vender?");
                    tipoVehiculo = scanner.next();

                    switch (tipoVehiculo.toLowerCase()) {
                        case "patinete":
                            System.out.println("Introduce numero de serie: ");
                            numSerie = scanner.next();
                            System.out.println("Introduce marca: ");
                            marca = scanner.next();
                            System.out.println("Introduce modelo: ");
                            modelo = scanner.next();
                            System.out.println("Introduce estado: ");
                            estado = scanner.next();
                            System.out.println("Introduce precio: ");
                            precio = scanner.nextInt();
                            System.out.println("Introduce autonomia: ");
                            autonomia = scanner.nextInt();

                            stock.venderVehiculo(new Patinete(numSerie, marca, modelo, estado, precio, autonomia));
                            break;
                        case "coche":
                            System.out.println("Introduce numero de serie: ");
                            numSerie = scanner.next();
                            System.out.println("Introduce marca: ");
                            marca = scanner.next();
                            System.out.println("Introduce modelo: ");
                            modelo = scanner.next();
                            System.out.println("Introduce estado: ");
                            estado = scanner.next();
                            System.out.println("Introduce precio: ");
                            precio = scanner.nextInt();
                            System.out.println("Introduce caballos: ");
                            cv = scanner.nextInt();
                            System.out.println("Introduce centimetros cubicos: ");
                            cc = scanner.nextInt();

                            stock.venderVehiculo(new Coche(numSerie, marca, modelo, estado, precio, cv, cc));
                            break;
                        case "moto":
                            System.out.println("Introduce numero de serie: ");
                            numSerie = scanner.next();
                            System.out.println("Introduce marca: ");
                            marca = scanner.next();
                            System.out.println("Introduce modelo: ");
                            modelo = scanner.next();
                            System.out.println("Introduce estado: ");
                            estado = scanner.next();
                            System.out.println("Introduce precio: ");
                            precio = scanner.nextInt();
                            System.out.println("Introduce transmicion: ");
                            transmision = scanner.next();
                            System.out.println("Introduce peso: ");
                            peso = scanner.nextInt();

                            stock.venderVehiculo(new Motos(numSerie, marca, modelo, estado, precio, transmision, peso));
                            break;
                        case "bicicleta":
                            System.out.println("Introduce numero de serie: ");
                            numSerie = scanner.next();
                            System.out.println("Introduce marca: ");
                            marca = scanner.next();
                            System.out.println("Introduce modelo: ");
                            modelo = scanner.next();
                            System.out.println("Introduce estado: ");
                            estado = scanner.next();
                            System.out.println("Introduce precio: ");
                            precio = scanner.nextInt();
                            System.out.println("Introduce tipo de la bici: ");
                            tipo = scanner.next();

                            stock.venderVehiculo(new Bicicletas(numSerie, marca, modelo, estado, precio, tipo));
                            break;
                        default:
                            System.out.println("Error...");
                    }
                    break;
                case 4:
                    System.out.println("Que vehiculo quieres reparar?");
                    tipoVehiculo = scanner.next();

                    switch (tipoVehiculo.toLowerCase()) {
                        case "bici":
                            System.out.println("Introduce numero de serie: ");
                            numSerie = scanner.next();
                            System.out.println("Introduce marca: ");
                            marca = scanner.next();
                            System.out.println("Introduce modelo: ");
                            modelo = scanner.next();
                            System.out.println("Introduce estado: ");
                            estado = scanner.next();
                            System.out.println("Introduce precio: ");
                            precio = scanner.nextInt();
                            System.out.println("Introduce tipo de la bici: ");
                            tipo = scanner.next();

                            stock.repararVehiculo(new Bicicletas(numSerie, marca, modelo, estado, precio, tipo), "bici");
                            break;
                        case "patinete":
                            System.out.println("Introduce numero de serie: ");
                            numSerie = scanner.next();
                            System.out.println("Introduce marca: ");
                            marca = scanner.next();
                            System.out.println("Introduce modelo: ");
                            modelo = scanner.next();
                            System.out.println("Introduce estado: ");
                            estado = scanner.next();
                            System.out.println("Introduce precio: ");
                            precio = scanner.nextInt();
                            System.out.println("Introduce autonomia: ");
                            autonomia = scanner.nextInt();

                            stock.repararVehiculo(new Patinete(numSerie,marca,modelo,estado,precio,autonomia),"patinete");
                            break;
                    }
                case 5:
                    stock.mostrarCaja();
                    break;
                case 0:
                    System.out.println("Saliendo de la aplicacion...");
                    break;
                default:
                    System.out.println("Error...");
            }


        } while (opcion != 0);


    }
}
