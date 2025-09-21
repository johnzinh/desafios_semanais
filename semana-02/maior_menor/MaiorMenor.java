package semana_2.maior_menor;


import java.util.Random;
import java.util.Scanner;

public class MaiorMenor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        int pts = 0;
        int numAleatorio = random.nextInt(100) + 1;

        System.out.println("*** JOGO MAIOR MENOR ****\n");

        while (true) {
            try {

                System.out.println("Numero atual: " + numAleatorio);
                System.out.println("o proximo numero sera maior ou menor? - (digite 'sair' para encerrar!)");
                String opcao = scan.nextLine().toLowerCase().trim();

                if (opcao.equals("sair")) {
                    System.out.println("Pontuação total: " + pts);
                    System.out.println("Encerrando jogo...");
                    break;

                } else if (!opcao.equals("maior") && !opcao.equals("menor")) {
                    System.out.println("Escolha inválida! Tente novamente");
                    continue;
                }

                int novoNumero = random.nextInt(100) + 1;
                System.out.println("Novo numero é: " + novoNumero);

                boolean acertou = (opcao.equals("maior") && novoNumero > numAleatorio) ||
                        (opcao.equals("menor") && novoNumero < numAleatorio);

                if (acertou) {
                    pts++;
                    System.out.println("Acertou! pontuação: " + pts);
                } else {
                    System.out.println("Errou! pontuação: " + pts);
                }

                numAleatorio = novoNumero;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getCause());
            }
        }
    }
}