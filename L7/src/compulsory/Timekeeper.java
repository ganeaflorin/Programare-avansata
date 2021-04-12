package compulsory;

public class Timekeeper implements Runnable {
    private int gameLength;
    private int currentGameLength = 0;
    private volatile boolean gameOver = false;

    public Timekeeper(int gameLength) {
        this.gameLength = gameLength;
    }

    @Override
    public void run() {
        while (currentGameLength < gameLength) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentGameLength++;
            if (currentGameLength % 5 == 0)
                System.out.println("The game has started " + currentGameLength + " second(s) ago.");
        }
        gameOver = true;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public int getGameLength() {
        return gameLength;
    }
}
