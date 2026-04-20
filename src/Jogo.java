import java.util.Random;
import java.util.Scanner;

public class Jogo {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    private Tabuleiro tabuleiro;
    private char jogadorAtual;
    private boolean contraBot;


    public Jogo() {
        this.tabuleiro = new Tabuleiro();
        jogadorAtual = 'X';
    }

    public void estiloJogo(int escolha){
        contraBot = (escolha == 2);
    }

    public void iniciar(){
        while (true) {
            System.out.println("\n==============================");

            tabuleiro.exibir();

            boolean jogou = false;

            if (jogadorAtual == 'O' && contraBot){
                
                while (!jogou){
                    int linha = random.nextInt(3);
                    int coluna = random.nextInt(3);

                    jogou = tabuleiro.jogar(linha, coluna, jogadorAtual);
                }
                System.out.println("\nBot jogou...");
            }else{
                while (!jogou){
                    System.out.println("Jogador " + jogadorAtual + ", sua vez.");
                    System.out.print("Qual linha será a jogada? (entre 0 e 2): ");
                    int linha = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Qual coluna será a jogada? (entre 0 e 2): ");
                    int coluna = scanner.nextInt();
                    scanner.nextLine();

                    if (linha >= 0 && linha <= 2 && coluna >= 0 && coluna <= 2) {
                        jogou = tabuleiro.jogar(linha, coluna, jogadorAtual);
                        if (!jogou){
                            System.out.println("\nMensagem...");
                            System.out.println("Posição ocupada.");
                        }
                    }else {
                        System.out.println("\nMensagem...");
                        System.out.println("Jogada inválida.");
                    }
                }
            }
            if (verificarFimDeJogo()) break;
            jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
        }
    }

    private boolean verificarFimDeJogo(){
        if (tabuleiro.temVencedor()) {
            System.out.println();
            tabuleiro.exibir();
            System.out.println("Vencedor: " + jogadorAtual + "!");
            return true;
        } else if (tabuleiro.estaCheio()) {
            System.out.println();
            tabuleiro.exibir();
            System.out.println("Empate!");
            return true;
        }
        return false;
    }




}
