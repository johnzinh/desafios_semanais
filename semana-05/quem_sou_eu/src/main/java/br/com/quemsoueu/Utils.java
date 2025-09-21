package br.com.quemsoueu;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;

public class Utils {

    public static List<Elemento> carregarElemento() {
        try {
           FileReader reader = new FileReader("src/main/resources/elementos.json");
            return new Gson().fromJson(reader, new TypeToken<List<Elemento>>() {}.getType());
        } catch (Exception e) {
            System.out.println("Erro ao carregar elementos.");
            return Collections.emptyList();
        }
    }
}
