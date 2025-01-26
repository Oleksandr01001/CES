package model;

public class Persona {

    private String nombre, apellido, dni, genero;
    private int edad;
    private double peso, altura, imc;

    public Persona(String nombre, String apellido, String dni, int edad, double peso, double altura, String genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        this.genero = genero.toLowerCase();
        this.imc = calcularIMC();
    }

    public Persona(String nombre, String apellido, String dni, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
    }

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = "111111111X";
    }

    public Persona() {
        this.nombre = "Sin definir";
        this.apellido = "Sin definir";
        this.dni = "Sin definir";
        this.edad = 0;
        this.peso = 0;
        this.altura = 0;
    }


    public void mostrarDatos() {
        System.out.printf("\nNombre: %s" +
                        "\nApellido: %s" +
                        "\nDNI: %s" +
                        "\nEdad: %d" +
                        "\nPeso: %.2f" +
                        "\nAltura: %.2f" +
                        "\nIMC: %.2f" +
                        "\nEstado ficico: %s",
                nombre,apellido,dni,edad,peso,altura,imc,estadoFicico());
        System.out.println();
    }

    public void incrementarEdad(int edad) {
        setEdad(edad + getEdad());
    }

    public double calcularIMC() {
        this.imc = peso/Math.pow(altura/100,2);
        return imc;
    }

    public String estadoFicico() {
        if (genero == null || genero.isEmpty()) {
            return "Género no especificado";
        }
        if (genero.equals("h")) {
            if (imc < 20) {
                return "Bajo peso";
            }
            if (imc < 27) {
                return "Normopeso";
            }
            if (imc < 30) {
                return "Sobrepeso";
            }
            if (imc <= 40) {
                return "Obesidad";
            }
            return "Obesidad mórbida";
        } else if (genero.equals("m")) {
            if (imc < 20) {
                return "Bajo peso";
            }
            if (imc < 25) {
                return "Normopeso";
            }
            if (imc < 30) {
                return "Sobrepeso";
            }
            if (imc <= 40) {
                return "Obesidad";
            }
            return "Obesidad mórbida";
        }
        return "Error";
    }





    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}
