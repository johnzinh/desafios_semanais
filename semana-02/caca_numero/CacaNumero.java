package semana_2.caca_numero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CacaNumero {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        int pontuacao = 0;
        String opcao = "";

        System.out.println("CAÇA AO NUMERO");
        int dificuldade = escolherDificuldade(scan);  //mostra menu e escolhe opcao por entrada

        //variaveis pra alterar a dificuldade
        int numeroMaximo = 0;  //vai ser o tamanho Random
        int  numeroTentativas = 0;

        switch (dificuldade) {  //um switch que usa a "dificuldade" pra aumentar os atributos.
            case 1:
                numeroMaximo = 100;
                numeroTentativas = 10;
                break;
            case 2:
                numeroMaximo = 300;
                numeroTentativas = 8;
                break;
            case 3:
                numeroMaximo = 500;
                numeroTentativas = 6;
                break;
        }

        do {
            int numeroAleatorio = random.nextInt(numeroMaximo);
            List<Integer> numerosChutados = new ArrayList<>(); //pra armazenar os numeros chutados
            int tentativas = numeroTentativas;   //recebe a escolha feita no switch
            boolean acertou = false;

            System.out.println("Número Gerado! - Entre 1 e " + numeroMaximo + " Boa Sorte!");
            System.out.println("Nivel de Dificuldade: " + getNomeDificuldade(dificuldade) +
                                "\nTentaivas: " + numeroTentativas);

            try {
                while (tentativas > 0 && !acertou) {
                    System.out.println("\ntentativas restantes: " + tentativas);
                    System.out.println("seu chute: ");
                    int chute = scan.nextInt();

                    if (numerosChutados.contains(chute)) {  //checa se o numero chutado ta no array
                        System.out.println("vc ja tentou esse numero! tente outro.");
                        tentativas--;
                        continue;
                    }

                    numerosChutados.add(chute); //adiciona ao array o ultimo chute

                    if (chute == numeroAleatorio) { //verifica se numero chutado é igual ao aleatorio
                        System.out.println("vc acertou! o numero era: " + numeroAleatorio);
                        pontuacao++;
                        acertou = true;
                    } else if (chute < numeroAleatorio) {
                        System.out.println("o numero secreto é maior!");
                    } else {
                        System.out.println("o numero secreto é menor!");
                    }

                    System.out.println("Numeros chutados: " + numerosChutados);
                    tentativas--;
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida! Por favor, digite um número.");
                System.out.println(e.getMessage());
                scan.next(); // Limpa o valor inválido do buffer (interessante)
            }


            if (!acertou) {
                System.out.println("vc acertou o numero secreto " + numeroAleatorio + ",parabens!");
            }


            try {
                System.out.println("pontuacao atual: " + pontuacao);
                System.out.println("\nDeseja jogar novamente? (sim/sair): ");
                opcao = scan.next();
            } catch (Exception e) {
                System.out.println("erro ao sair..");
                System.out.println(e.getMessage());
            }

        } while (opcao.equalsIgnoreCase("sim"));

        System.out.println("vc terminou o jogo com " + pontuacao + " ponto(s)");
        scan.close();


    }

    public static int escolherDificuldade(Scanner scan) { //metodo pra escoler dificuldade (menuzinho)
        int dificuldade = 0;

        while (dificuldade < 1 || dificuldade > 3) {
            try {
                System.out.println("\nSelecione a dificuldade: ");
                System.out.println("1 - Fácil (1-50, 12 tentativas, dicas precisas)");
                System.out.println("2 - Médio (1-100, 8 tentativas, dicas moderadas)");
                System.out.println("3 - Difícil (1-200, 5 tentativas, poucas dicas)");
                System.out.println("opção: ");
                dificuldade = scan.nextInt();

                if (dificuldade < 1 || dificuldade > 3) {
                    System.out.println("Opção inválida! Digite 1, 2 ou 3.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida! Digite um número.");
                scan.next(); // Limpa o buffer
            }

        }
        return dificuldade;
    }

    public static String getNomeDificuldade(int nivel) {
        switch (nivel){
            case 1: return "Fácil";
            case 2: return "Médio";
            case 3: return "Difícil";
            default:return "Desconhecida";
        }
    }


}
