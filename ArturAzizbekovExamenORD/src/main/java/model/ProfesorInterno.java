package model;

public class ProfesorInterno extends Profesor {
    private int complemento;

    public ProfesorInterno(String nombre, String dni, int salarioAnual, int complemento) {
        super(nombre, dni, salarioAnual);
        this.complemento = complemento;
    }

    public int getComplemento() {
        return complemento;
    }

    public void setComplemento(int complemento) {
        this.complemento = complemento;
    }
    @Override
    public double calcularSalarioTotal(){
        return getSalarioAnual() + complemento * 12;
    }
}
