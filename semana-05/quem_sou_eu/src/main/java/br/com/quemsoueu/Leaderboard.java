package br.com.quemsoueu;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leaderboard {
    private static final String PATH = "src/main/resources/leaderboard.json";
    private static final int MAX_ENTRADAS = 10;



    public static void salvarPontuacao(String nome, int pontuacao) { //metodo salvarPontuacao
        List<Map<String, Object>> leaderboard = carregar();

        Map<String, Object> entrada = new HashMap<>();//Cria nova entrada com nome e pontuação
        entrada.put("nome", nome);
        entrada.put("pontuacao", (double) pontuacao);
        leaderboard.add(entrada);
        leaderboard.sort((a, b) -> ((Double) b.get("pontuacao")).compareTo((Double) a.get("pontuacao"))); //Ordena a lista de forma decrescente com base na pontuação

        if (leaderboard.size() > MAX_ENTRADAS) {
            leaderboard = leaderboard.subList(0, MAX_ENTRADAS);
        }

        try (Writer writer = new FileWriter(PATH)) { //Salva tudo de volta no JSON
            new Gson().toJson(leaderboard, writer);
        } catch (IOException e) {
            System.out.println("Erro ao salvar leaderboard");
        }
    }


    /*
     * carregar, ler o arquivo leaderboard.json usando FileReader.
     * (usa o Gson para converter para JSON
     * se o arquivo n existir da erro
     */

    public static List<Map<String, Object>> carregar() {
        try (Reader reader = new FileReader(PATH)) {        //try-with-resources
            return new Gson().fromJson(reader, new TypeToken<List<Map<String, Object>>>() {
            }.getType()); //Gson para converter o JSON em uma List<Map<String, Object>>
        } catch (IOException e) {
            return new ArrayList<>(); //Se o arquivo não existir ou der erro, retorna uma lista vazia.
        }
    }


    //metodo exibir
    public static void exibir() {
        List<Map<String, Object>> leaderboard = carregar();

        System.out.println("\n===== LEADERBOARD =====");

        for (int i = 0; i < leaderboard.size(); i++) {
            Map<String, Object> entrada = leaderboard.get(i);
            System.out.printf("%dº - %s: %.0f pontos\n", i + 1, entrada.get("nome"), (Double) entrada.get("pontuacao"));
        }
    }


}
