package semana_1.senhas;

public class UtilString {

    public String inverter(String texto) {
        return new StringBuilder(texto).reverse().toString();
    }

    public String removerVogais(String texto) {
        return texto.replaceAll("(?i)[aeiou]", "");
    }

    public String cifrar(String texto) {
        return texto
                .replaceAll("a", "@")
                .replaceAll("A", "@")
                .replaceAll("e", "3")
                .replaceAll("E", "3")
                .replaceAll("i", "!")
                .replaceAll("I", "!")
                .replaceAll("o", "0")
                .replaceAll("O", "0")
                .replaceAll("s", "$")
                .replaceAll("S", "$")
                .replaceAll("h", "#")
                .replaceAll("H", "#");
    }


}
