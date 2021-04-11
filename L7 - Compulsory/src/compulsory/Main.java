package compulsory;

import compulsory.game.Board;
import compulsory.game.Game;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Board board = new Board(10);
        board.initBoard();
//        board.printBoard();
        PlayerThread player1 = new PlayerThread(0, "Player 1", board, false);
        PlayerThread player2 = new PlayerThread(1, "Player 2", board, false);
        PlayerThread player3 = new PlayerThread(2, "Player 3", board, true);

        Game game = new Game(board, 15);
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        game.init();
    }
}

