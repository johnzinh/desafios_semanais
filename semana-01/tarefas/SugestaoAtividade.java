package semana_1.tarefas;

import java.util.Scanner;

public class SugestaoAtividade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("informe o tempo disponivel para tarefa: ");
        String entrada = scan.nextLine().toLowerCase().replace(" ", "");

        int min = converterTempo(entrada);

        if (min <= 0) {
            System.out.println("Tempo inválido. Tente novamente com um valor como '10min' ou '1h30'.");
            return;
        }

        System.out.println("Tempo disponível: " + min + " minutos");
        System.out.println("Sugestao de atividades: ");

        if (min <= 5) {
            sugerir("beber água", "levantar e alongar", "respirar fundo");
        } else if (min <= 10) {
            sugerir("ler um artigo curto", "revisar anotações", "meditar");
        } else if (min <= 20) {
            sugerir("assistir a uma videoaula", "fazer uma caminhada curta");
        } else if (min <= 45) {
            sugerir("estudar um módulo", "escrever um texto", "resolver exercícios");
        } else if (min > 90) {
            sugerir("projeto pessoal", "estudo aprofundado", "tarefa doméstica longa");
        } else {
            sugerir("continuar um estudo", "organizar documentos", "planejar a semana");
        }


    }

    public static int converterTempo(String entrada) {
        int totalMin = 0;
        try{
            if (entrada.contains("h")){
                String[] partes = entrada.split("h");
                int horas = Integer.parseInt(partes[0]);
                totalMin += horas * 60;

                if(partes.length > 1 && partes[1].contains("min")) {
                    partes[1] = partes[1].replace("min", "");
                    if (!partes[1].isEmpty()) {
                        totalMin += Integer.parseInt(partes[1]);
                    }
                }
            } else if (entrada.contains("min")) {
                entrada = entrada.replace("min", "");
                totalMin = Integer.parseInt(entrada);
            }
        } catch (Exception e) {
            totalMin = -1;
        }
        return totalMin;
    }

    private static void sugerir(String... atividades) {
        for (String atividade : atividades) {
            System.out.println("- " + atividade);
        }
    }

}

