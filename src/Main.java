import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        Game game = new Game();

        showMenu();
        int choice = scanner.nextInt();

        game.setGameMode(choice);
        game.start();
    }

    private static void showMenu(){
        System.out.println("==================================");
        System.out.println("|         TIC-TAC-TOE            |");
        System.out.println("==================================");
        System.out.println("|        Choose game mode        |");
        System.out.println("|                                |");
        System.out.println("|  1- Two Players                |");
        System.out.println("|  2- Vs Bot                     |");
        System.out.println("==================================");
        System.out.print("Choice: ");
    }






}
