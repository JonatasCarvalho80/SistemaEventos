package com.sistema;

public class Usuario {
    private String nomeCompleto;
    private String emailUsuario;
    private String numeroContato;

    public Usuario(String nomeCompleto, String emailUsuario, String numeroContato) {
        this.nomeCompleto = nomeCompleto;
        this.emailUsuario = emailUsuario;
        this.numeroContato = numeroContato;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public String getNumeroContato() {
        return numeroContato;
    }
}