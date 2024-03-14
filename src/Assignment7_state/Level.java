package Assignment7_state;

public abstract class Level {
    private Character character;
    protected final int EXP_TRAIN = 5;
    protected final int EXP_FIGHT = 10;
    protected final int HP_MEDITATE = 5;
    protected final int HP_FIGHT = 10;

    public Level(Character character) {
        this.character = character;
    }

    public Character getCharacter() {
        return character;
    }

    abstract String getLevel();

    abstract void action();
}
