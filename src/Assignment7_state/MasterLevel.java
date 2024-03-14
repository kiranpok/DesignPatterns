package Assignment7_state;

public class MasterLevel extends Level {
    public MasterLevel(Character character) {
        super(character);
    }

    @Override
    public String getLevel() {
        return "Master";
    }

    @Override
    public void action() {
        System.out.println("You are a Master. Return to main menu.\n");
        this.getCharacter().setIsPlaying(false);
    }
}
