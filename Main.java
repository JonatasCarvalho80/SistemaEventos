package com.sistema;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        SistemaEventos sistema = new SistemaEventos();

        sistema.carregarEventos();

        while (true) {
            System.out.println("\n=== Gerenciador de Eventos ===");
            System.out.println("1. Adicionar novo evento");
            System.out.println("2. Mostrar eventos cadastrados");
            System.out.println("3. Encerrar");
            System.out.print("Escolha: ");
            int escolha = entrada.nextInt();
            entrada.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Título do evento: ");
                    String titulo = entrada.nextLine();
                    System.out.print("Local do evento: ");
                    String local = entrada.nextLine();
                    System.out.print("Tipo (ex: festa, show, esporte): ");
                    String tipo = entrada.nextLine();
                    System.out.print("Data e hora (yyyy-MM-ddTHH:mm): ");
                    String dataHoraStr = entrada.nextLine();
                    LocalDateTime dataHora = LocalDateTime.parse(dataHoraStr);
                    System.out.print("Detalhes do evento: ");
                    String detalhes = entrada.nextLine();

                    Evento novoEvento = new Evento(titulo, local, tipo, dataHora, detalhes);
                    sistema.adicionarEvento(novoEvento);
                    System.out.println("Evento registrado com sucesso!");
                    break;

                case 2:
                    List<Evento> listaEventos = sistema.obterEventos();
                    if (listaEventos.isEmpty()) {
                        System.out.println("Nenhum evento foi encontrado.");
                    } else {
                        System.out.println("\n--- Eventos Cadastrados ---");
                        for (int i = 0; i < listaEventos.size(); i++) {
                            Evento ev = listaEventos.get(i);
                            System.out.println((i + 1) + ". " + ev.getTitulo() + " - " + ev.getDataHora());
                        }
                    }
                    break;

                case 3:
                    sistema.salvarEventos();
                    System.out.println("Saindo... Eventos salvos.");
                    entrada.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}