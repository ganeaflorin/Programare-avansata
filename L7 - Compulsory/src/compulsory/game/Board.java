package compulsory.game;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private Token tokenGenerator;
    private List<Token> board;
    private int noTokens;

    public Board(int noTokens) {
        this.noTokens = noTokens;
        board = new ArrayList<>();
    }

    public void initBoard() {
        for (int currentTokenNum = 0; currentTokenNum < noTokens; currentTokenNum++) {
            tokenGenerator = new Token(noTokens);
            tokenGenerator.generateToken();
            board.add(tokenGenerator);
        }
    }

    public void printBoard() {
        System.out.println("Tokens:");
        for (int iterator = 0; iterator < noTokens; iterator++) {
            System.out.println((iterator + 1) + ". " + board.get(iterator));
        }
    }

    public boolean gameFinished() {
        return board.size() == 0;
    }

    public synchronized void removeToken(int index) {
        board.remove(board.get(index));
    }
}
