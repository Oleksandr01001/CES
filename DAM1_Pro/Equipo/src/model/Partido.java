package model;

public class Partido {

    private boolean jugado;
    private String equipoLocal, equipoVisitante;
    private int golesLocales, golesVisitantes;

    private Partido() {}
    public Partido(Equipo equipoLocal, Equipo equipoVisitante) {

    }

    public void iniciarPartido() {
        if (equipoLocal != null && equipoVisitante != null) {

        }
    }


    public boolean isJugado() {
        return jugado;
    }

    public void setJugado(boolean jugado) {
        this.jugado = jugado;
    }

    public int getGolesLocales() {
        return golesLocales;
    }

    public void setGolesLocales(int golesLocales) {
        this.golesLocales = golesLocales;
    }

    public int getGolesVisitantes() {
        return golesVisitantes;
    }

    public void setGolesVisitantes(int golesVisitantes) {
        this.golesVisitantes = golesVisitantes;
    }
}
