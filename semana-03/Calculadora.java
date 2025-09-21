package semana_3;

import java.util.Arrays;
import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] allowedOperation = {"+", "-", "*", "/"};

        System.out.println("== CALCULADORA BÁSICA ==");
        System.out.print("""
                Digite uma operação!
                adição          +
                subtração       -
                multiplicação   *
                divisão         /
                >>>\s""");

        String operation = scanner.nextLine();

        if (!(Arrays.asList(allowedOperation).contains(operation))) {
            System.out.println("Operação inválida, reinicie o programa");
            return;
        }

        System.out.println("Digite o primeiro número: ");
        double firstNumber = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Digite o segundo número: ");
        double secondNumber = scanner.nextDouble();
        scanner.nextLine();  //Usa scanner.nextLine() após nextDouble() para limpar o buffer (evita bugs se o usuário der Enter depois do número).


        double resultado;

        switch (operation) {
            case "+":
                resultado = firstNumber + secondNumber;
                System.out.println("Resultado da Soma: " + resultado);
                break;
            case "-":
                resultado = firstNumber - secondNumber;
                System.out.println("Resultado da subtracao: " + resultado);
                break;
            case "*":
                resultado = firstNumber * secondNumber;
                System.out.println("Resultado da Multiplicação: " + resultado);
                break;
            case "/":
                if (secondNumber == 0) {
                    System.out.println("Erro divisao por zero!");
                    return;
                }
                resultado = firstNumber / secondNumber;
                System.out.println("Resultado da Divisão: " + resultado);
                break;
            default:
                System.out.println("Erro inesperado!");
                return;
        }


    }


}
