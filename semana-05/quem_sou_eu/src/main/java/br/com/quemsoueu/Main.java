package br.com.quemsoueu;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Elemento> elementos = Utils.carregarElemento();
        Jogo jogo = new Jogo(elementos);

        Scanner scanner = new Scanner(System.in);
        String opcao;

        while(true) {
            System.out.println("\n===== QUEM SOU EU? =====");
            System.out.println("1. Jogar");
            System.out.println("2. Ajuda");
            System.out.println("3. Ver leaderboard");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1" -> jogo.jogar(scanner);
                case "2" -> System.out.println("Adivinhe quem você é com o menor número de dicas possível!");
                case "3" -> Leaderboard.exibir();
                case"4" -> {
                    System.out.println("Até a proxima");
                    return;
                }
                default -> System.out.println("opcao invalida");
            }
        }
    }
}