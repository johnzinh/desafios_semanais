package br.com.quemsoueu;


import java.util.*;

public class Jogo {
    private List<Elemento> elementos;   // Lista de desafios (carregados do JSON)
    private Set<String> usados = new HashSet<>();   // Para não repetir

    public Jogo(List<Elemento> elementos) {
        this.elementos = elementos;
    }

    public void jogar(Scanner scanner) {
        Elemento elemento = sortearElemento();
        if (elemento == null) {
            System.out.println("Todos os elementos ja foram usados.");
            return;
        }

        System.out.println("\n🔎 Categoria: " + elemento.categoria);
        long inicio = System.currentTimeMillis();
        int pontos = 100;
        int dicaIndex = 0;

        while (dicaIndex < elemento.dicas.size()) {
            System.out.println("Dica " + (dicaIndex + 1) + ": " + elemento.dicas.get(dicaIndex));
            System.out.println("Quem sou eu? (ou 'desistir'): ");
            String tentativa = scanner.nextLine().trim().toLowerCase();

            if (tentativa.equals("Desistir")) {
                System.out.println("vc desistiu");
                return;
            } else if (tentativa.equals(elemento.resposta.toLowerCase())) {
                long minutos = (System.currentTimeMillis() - inicio) / 60000;
                pontos -= dicaIndex * 10 + minutos;
                pontos = Math.max(pontos, 0);
                System.out.println("Vc acertou! " + pontos);

                if (Leaderboard.carregar().size() < 10 || pontos > (double) Leaderboard.carregar().get(9).get("pontuacao")) {
                    System.out.print("Digite seu nome para o leaderboard: ");
                    String nome = scanner.nextLine();
                    Leaderboard.salvarPontuacao(nome, pontos);
                }
                return;
            } else {
                dicaIndex++;
            }
        }
        System.out.println("Todas as dicas foram usadas. A resposta era: " + elemento.resposta);

    }


    private Elemento sortearElemento() {
        List<Elemento> disponiveis = new ArrayList<>();
        for (Elemento e : elementos) {
            if (!usados.contains(e.resposta.toLowerCase())) {
                disponiveis.add(e);
            }
        }

        if (disponiveis.isEmpty()) return null;

        Elemento sorteado = disponiveis.get(new Random().nextInt(disponiveis.size()));
        usados.add(sorteado.resposta.toLowerCase());
        return sorteado;

    }


}
