public class Opereciones extends RuntimeException {
    public Opereciones(String message) {
        super(message);
    }
}

class LongitudDNINoValidaException extends Exception {
    public LongitudDNINoValidaException(String mensaje) {
        super(mensaje);
    }
}

class UltimoDigitoNoLetraException extends Exception {
    public UltimoDigitoNoLetraException(String mensaje) {
        super(mensaje);
    }
}
