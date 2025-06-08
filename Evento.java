package com.sistema;

import java.time.LocalDateTime;

public class Evento {
    private String titulo;
    private String local;
    private String tipo;
    private LocalDateTime dataHora;
    private String detalhes;

    public Evento(String titulo, String local, String tipo, LocalDateTime dataHora, String detalhes) {
        this.titulo = titulo;
        this.local = local;
        this.tipo = tipo;
        this.dataHora = dataHora;
        this.detalhes = detalhes;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getLocal() {
        return local;
    }

    public String getTipo() {
        return tipo;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String getDetalhes() {
        return detalhes;
    }
}