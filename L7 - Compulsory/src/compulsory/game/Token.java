package compulsory.game;

import java.util.Random;

public class Token {
    private int leftPairValue;
    private int rightPairValue;
    private int tokenValue;
    private int maxTokenValue;

    public Token(int maxTokenValue) {
        this.maxTokenValue = maxTokenValue;
    }

    public void generateToken() {
        Random rand = new Random();
        int leftPairValue = rand.nextInt(maxTokenValue) + 1;
        int rightPairValue = rand.nextInt(maxTokenValue - 1) + 1;
        int tokenValue = rand.nextInt(9) + 1;
        while (leftPairValue == rightPairValue)
            rightPairValue = rand.nextInt(maxTokenValue);
        this.leftPairValue = leftPairValue;
        this.rightPairValue = rightPairValue;
        this.tokenValue = tokenValue;
    }

    @Override
    public String toString() {
        return "(" + leftPairValue + ", " + rightPairValue + ")" + " value: " + tokenValue;
    }

    public int getLeftPairValue() {
        return leftPairValue;
    }

    public int getRightPairValue() {
        return rightPairValue;
    }

    public int getTokenValue() {
        return tokenValue;
    }

    public int getMaxTokenValue() {
        return maxTokenValue;
    }
}
