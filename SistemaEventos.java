package com.sistema;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class SistemaEventos {
    private List<Evento> eventosRegistrados = new ArrayList<>();

    public void carregarEventos() {
        try (BufferedReader leitor = new BufferedReader(new FileReader("events.data"))) {
            String linhaLida;
            while ((linhaLida = leitor.readLine()) != null) {
                String[] partes = linhaLida.split(",");
                String titulo = partes[0];
                String local = partes[1];
                String tipo = partes[2];
                LocalDateTime dataHora = LocalDateTime.parse(partes[3]);
                String detalhes = partes[4];
                Evento evento = new Evento(titulo, local, tipo, dataHora, detalhes);
                eventosRegistrados.add(evento);
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void salvarEventos() {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter("events.data"))) {
            for (Evento evento : eventosRegistrados) {
                String linha = evento.getTitulo() + "," + evento.getLocal() + "," + evento.getTipo() + "," +
                        evento.getDataHora().toString() + "," + evento.getDetalhes();
                escritor.write(linha);
                escritor.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adicionarEvento(Evento novoEvento) {
        eventosRegistrados.add(novoEvento);
    }

    public List<Evento> obterEventos() {
        return eventosRegistrados;
    }
}