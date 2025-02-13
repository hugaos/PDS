package lab03;

public class JGaloImplementer implements JGaloInterface {
    private char[][] board = new char[3][3];
    private char currentPlayer = 'X';
    private boolean flag = false;

    public char getActualPlayer() {
        return currentPlayer;
    }

    public boolean setJogada(int lin, int col) {
        boolean jogada = false;
        lin--;
        col--;

        // check if the cell is valid
        if (lin < 0 || lin >= 3 || col < 0 || col >= 3 || flag)
            return jogada; // jogada invalida

        // check if the cell is empty
        if (board[lin][col] == '\0') {
            board[lin][col] = currentPlayer;
            jogada = true;

            // check if the game is finished
            if (isFinished())
                return jogada;

            // mudar player
            if (currentPlayer == 'X') {
                currentPlayer = 'O';
            } else {
                currentPlayer = 'X';
            }
        }

        return jogada;
    }

    public boolean isFinished() {
        // horizontal e vertical
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '\0')
                return true;
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != '\0')
                return true;
        }

        // diagonais
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '\0')
            return true;
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '\0')
            return true;

        // check for stalemate
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '\0') {
                    return false; // game is not finished, there are still empty cells
                }
            }
        }

        return true; // ainda ninguem ganhou ou empatou
    }

    public char checkResult() {
        // check winner
        if (isFinished()) {
            for (int i = 0; i < 3; i++) {
                if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '\0')
                    return board[i][0];
                if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != '\0')
                    return board[0][i];
            }
            if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '\0')
                return board[0][0];
            if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '\0')
                return board[0][2];

            return ' '; // stalemate
        }

        return currentPlayer;
    }
}