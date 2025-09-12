import model.LlamadaLocal;
import model.LlamadaNacional;
import model.LlamadaProvincial;
import controller.Centralita;

public class Entrada {


    public static void main(String[] args) {

        LlamadaLocal llamadaLocal = new LlamadaLocal(611530967,611530956, 120);
        LlamadaProvincial llamadaProvincial = new LlamadaProvincial(611530967,611530956,150);
        LlamadaNacional llamadaNacional = new LlamadaNacional(611530967,611530956,175,3);

        Centralita centralita = new Centralita();

        centralita.registrarLlamada(llamadaLocal);
        centralita.registrarLlamada(llamadaProvincial);
        centralita.registrarLlamada(llamadaNacional);

        centralita.mostrarCostes();
        centralita.mostrarLlamadas();
    }
}
