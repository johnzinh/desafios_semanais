package semana_1.senhas;

import java.util.Scanner;

public class GeradorDeSenhas {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        UtilString s = new UtilString();

        System.out.println("Digite uma senha: ");
        String senha = scan.nextLine();
        mostrar(senha);

        System.out.println("Senha invertida: " + s.inverter(senha));
        System.out.println("Senha sem vogais: " + s.removerVogais(senha));
        System.out.println("cifrada: " + s.cifrar(senha));



    }

    public static void mostrar(String senha) {
        System.out.println("senha: " + senha);
    }




}
