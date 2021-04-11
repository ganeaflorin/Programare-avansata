package compulsory;

import compulsory.game.Board;
import compulsory.game.Token;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PlayerThread implements Runnable {
    private String name;
    private Board board;
    private List<Token> playerTokens;
    private static volatile int turn = 0;
    private int id;
    private int noPlayers;
    private boolean isRandom = false;
    private boolean running = true;

    public PlayerThread(int id, String name, Board board, boolean isRandom) {
        this.name = name;
        this.id = id;
        this.board = board;
        playerTokens = new ArrayList<>();
        this.isRandom = isRandom;
    }

    public void setNoPlayers(int noPlayers) {
        this.noPlayers = noPlayers;
    }

    @Override
    public void run() {
        while (!board.gameFinished() && running) {
            while (turn != id) {
                //do nothing
            }

            takeToken();
        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public static void setTurn(int turn) {
        PlayerThread.turn = turn;
    }

    public static int getTurn() {
        return turn;
    }

    public synchronized void takeToken() {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        if (!board.gameFinished()) {
            board.printBoard();
            System.out.println(name + "'s turn.");
            if (isRandom == false) {
                int input = getUserInput(scanner);
                handleInput(input);
            } else {
                int input = rand.nextInt(board.boardSize() - 1) + 1;
                System.out.println("INPUT: " + input);
                handleInput(input);
            }
        }
    }

    public void handleInput(int input) {
        Token pickedToken = board.removeToken(input);
        board.handleGameOver();
        playerTokens.add(pickedToken);
        setTurn((id + 1) % noPlayers);
    }

    public int getUserInput(Scanner scanner) {
        boolean badInput = true;
        int input = -1;
        while (badInput) {
            System.out.print("Pick a token: ");
            input = scanner.nextInt();
            if (input <= board.boardSize() && input >= 1)
                badInput = false;
            else System.out.println("Ops! Wrong input! Try again!");
        }
        return input;
    }

    public List<Token> getPlayerTokens() {
        return playerTokens;
    }

    public String getName() {
        return name;
    }
}
