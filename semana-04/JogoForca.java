package semana_4;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class JogoForca {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();


        String[] palavras = {"lua", "Sol", "Luz", "Casa", "Amigo", "Escola", "Futebol", "Montanha", "Programar", "Biblioteca"};

        String palavraSecreta = palavras[random.nextInt(palavras.length)]; //o indice de "palavras" sera o numero aleatorio gerado que tem o tamanho do array "palavras"
        char[] letrasDescobertas = new char[palavraSecreta.length()]; //cria um array de caracteres do tamanho de "palavrasSequetas"

        //Arrays.fill(letras, '_');
        for (int i = 0; i < letrasDescobertas.length; i++) {  //adiciona ao letras o "_"
            letrasDescobertas[i] = '_';
        }

        //para controle
        int tentativasRestantes = 6;
        boolean venceu = false;

        while(tentativasRestantes > 0 && !venceu) {
            System.out.println("\nPalavra: " + mostrarEstado(letrasDescobertas));
            System.out.println("Tentativas restantes: " + tentativasRestantes);
            System.out.println("Digite uma letra: ");
            char tentativa = scan.nextLine().toLowerCase().charAt(0);  //tudo pra maiuscula e pega a primeira letra do string digitada

            boolean acertou = false;
            for (int i = 0; i < palavraSecreta.length(); i++) {
                if (palavraSecreta.charAt(i) == tentativa && letrasDescobertas[i] == '_') {
                    letrasDescobertas[i] = tentativa;
                    acertou = true;
                }
            }

            if (!acertou) {
                tentativasRestantes--;
                System.out.println("letra incorreta");
            } else {
                System.out.println("Boa, letra correta.");
            }

            // Verificar se venceu
            venceu = new String(letrasDescobertas).equals(palavraSecreta);
        }
        //resultado final
        if (venceu) {
            System.out.println("\nParabens, vc adivinhou a palavra: " + palavraSecreta);
        } else {
            System.out.println("\nGame over, a palavra era: " + palavraSecreta);
        }
        scan.close();

    }
    public static String mostrarEstado(char[] letras) {
        StringBuilder estado = new StringBuilder();
        for (char letra : letras) { //for melhorado pra percorrer o array letras
            estado.append(letra).append(' ');
        }
        return estado.toString().trim();
    }

}
