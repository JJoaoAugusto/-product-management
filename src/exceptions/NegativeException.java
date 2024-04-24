package exceptions;

public class NegativeException extends Exception {
    public NegativeException () {
        super("O preço deve ser positivo!");
    }
}

