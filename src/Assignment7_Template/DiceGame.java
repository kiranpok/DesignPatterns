import java.util.Arrays;
import java.util.Random;

public class DiceGame extends Game {
    private final int NUMBER_OF_DICE = 2;
    private int winner = -1;
    private Random random = new Random();

    @Override
    public void initializeGame(int numberOfPlayers) {
        System.out.println("Dice game initiated. Number of dice: " + NUMBER_OF_DICE + ". "
                            + numberOfPlayers + " players join the game.");
    }

    @Override
    public boolean endOfGame() {
        return (winner != -1);
    }

    @Override
    public void playSingleTurn(int player) {
        int[] dice = new int[NUMBER_OF_DICE];
        for (int i = 0; i < dice.length; i++) {
            dice[i] = random.nextInt(1, 7);
        }

        System.out.println("Player no. " + (player + 1) + " rolls the dice: "
                            + Arrays.stream(dice)
                                .mapToObj(String::valueOf)
                                .reduce((s1, s2) -> s1 + " " + s2)
                                .orElse(" "));

        if (Arrays.stream(dice).sum() == NUMBER_OF_DICE * 6) winner = player;
    }

    @Override
    public void displayWinner() {
        System.out.println("Game stopped. The winner is Player no. " + (winner + 1));
    }
}