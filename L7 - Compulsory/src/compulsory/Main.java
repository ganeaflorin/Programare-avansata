package compulsory;

import compulsory.game.Board;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Board board = new Board(10);
        board.initBoard();
//        board.printBoard();
        PlayerThread thread = new PlayerThread("Flo", board);
        thread.start();
        PlayerThread thread1 = new PlayerThread("Gogo", board);
        thread1.start();
        int turn = 1;
        while (!board.gameFinished()) {
            board.printBoard();
            synchronized (thread) {
                if (turn == 2)
                    try {
                        thread.wait(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
            synchronized (thread1) {
                if (turn == 1)
                    try {
                        thread1.wait(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
            if (turn == 1) turn = 2;
            else turn = 1;
        }
    }
}

