package compulsory.game;

import compulsory.PlayerThread;
import compulsory.Timekeeper;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<PlayerThread> players = new ArrayList<>();
    private Board board;
    private int maxScore;
    private String winnerName;
    private Timekeeper timeKeeper;
    private List<PlayerThread> threadList = new ArrayList<>();

    public Game(Board board, int seconds) {
        this.board = board;
        timeKeeper = new Timekeeper(seconds);
    }

    public void addPlayer(PlayerThread player) {
        players.add(player);
    }

    public void init() {
        System.out.println("The game will go on for: " + timeKeeper.getGameLength() + " seconds. Good luck!");
        Thread timeThread = new Thread(timeKeeper);
        timeThread.setDaemon(true);
        timeThread.start();
        for (PlayerThread player : players) {
            player.setNoPlayers(players.size());
            Thread playerThread = new Thread(player);
            threadList.add(player);
            playerThread.start();
        }
        while (!timeKeeper.isGameOver() && !board.gameFinished()) {
            //do nothing cat timp mai sunt tokeni si timpul nu s-a scurs
        }
        if (timeKeeper.isGameOver()) {
            System.out.println("\nTIME'S UP!!!!");
            for (PlayerThread thread : threadList)
                thread.setRunning(false);
            System.exit(0);
        } else {
            determineWinner(players);
            printWinner();
        }
    }

    public void determineWinner(List<PlayerThread> players) {
        for (PlayerThread player : players) {
            int currentPlayerScore = 0;
            for (Token token : player.getPlayerTokens()) {
                currentPlayerScore += token.getTokenValue();
            }
            if (currentPlayerScore > maxScore) {
                maxScore = currentPlayerScore;
                winnerName = player.getName();
            }
        }
    }

    public void printWinner() {
        if (!timeKeeper.isGameOver())
            System.out.println("The game is over!\nThe winner is: " + winnerName + " with a score of: " + maxScore);
    }
}


