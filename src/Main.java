import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        Jogo jogo = new Jogo();

        System.out.println("==================================");
        System.out.println("|        JOGO DA VELHA           |");
        System.out.println("==================================");
        System.out.println("|        Como quer jogar?        |");
        System.out.println("|                                |");
        System.out.println("|  1- 2 Players                  |");
        System.out.println("|  2- Bot                        |");
        System.out.println("==================================");
        System.out.print("Escolha: ");
        int escolha = scanner.nextInt();
        scanner.nextLine();
        System.out.println("==================================");
        jogo.estiloJogo(escolha);
        jogo.iniciar();
    }
}
