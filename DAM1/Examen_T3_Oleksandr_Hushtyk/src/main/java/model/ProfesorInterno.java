package model;

public class ProfesorInterno extends Profesor{

    private int complemento;

    public ProfesorInterno() {

    }

    public ProfesorInterno(String nombre, String dni, double salario, int complemento) {
        super(nombre, dni, salario);
        this.complemento = complemento;
    }

    @Override
    public double calcularSalario() {
        return getSalario() + complemento * 12;
    }


    public int getComplemento() {
        return complemento;
    }

    public void setComplemento(int complemento) {
        this.complemento = complemento;
    }
}
