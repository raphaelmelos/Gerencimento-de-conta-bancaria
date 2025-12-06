package com.example.trabalho3.exception;

public class RegistroNaoEncontradoException extends RuntimeException {
    public RegistroNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
