public class Tabuleiro {
    private char[][] grade;

    public Tabuleiro(){
        grade = new char[3][3];
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                grade[i][j] = ' ';
            }
        }
    }

    public void exibir(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                System.out.print(" " + grade[i][j] + " ");
                if (j < 2){
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2){
                System.out.println("-----------");
            }
        }
    }

    public boolean jogar(int linha, int coluna, char simbolo){
        if (grade[linha][coluna] == ' '){
            grade[linha][coluna] = simbolo;
            return true;
        }
        return false;
    }

    public boolean estaCheio(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (grade[i][j] == ' '){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean temVencedor(){
        for (int i = 0; i < 3; i++){
            if (grade[i][0] == grade[i][1] && grade[i][1] == grade[i][2] && grade[i][0] != ' '){
                return true;
            }
        }

        for (int j = 0; j < 3; j++){
            if (grade[0][j] == grade[1][j] && grade[1][j] == grade[2][j] && grade[0][j] != ' '){
                return true;
            }
        }

        if (grade[0][0] == grade[1][1] && grade[1][1] == grade[2][2] && grade[0][0] != ' '){
            return true;

        }else if (grade[0][2] == grade[1][1] && grade[1][1] == grade[2][0] && grade[0][2] != ' '){
            return true;
        }
        return false;
    }
}
