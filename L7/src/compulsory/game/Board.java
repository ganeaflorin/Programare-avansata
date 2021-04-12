package compulsory.game;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private Token tokenGenerator;
    private List<Token> board;
    private int noTokens;
    private boolean gameFinished = false;

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
        return gameFinished;
    }

    public Token removeToken(int index) {
        Token pickedToken = board.get(index - 1);
        board.remove(pickedToken);
        noTokens--;
        return pickedToken;
    }

    public void handleGameOver() {
        if (boardSize() == 0)
            gameFinished = true;
    }

    public int boardSize() {
        return board.size();
    }
}
