package compulsory;

import compulsory.game.Board;

import java.util.Scanner;

public class PlayerThread extends Thread {
    private String name;
    private Board board;

    public PlayerThread(String name, Board board) {
        this.name = name;
        this.board = board;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(name + "'s turn.");
        System.out.print("Pick a token: ");
        int input = scanner.nextInt();
        board.removeToken(input);
    }
}
