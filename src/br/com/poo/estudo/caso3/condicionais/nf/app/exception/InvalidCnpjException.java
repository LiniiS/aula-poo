package br.com.poo.estudo.caso3.condicionais.nf.app.exception;

public class InvalidCnpjException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public InvalidCnpjException(String msg) {
        super(msg);
    }
}
