package Assignment7_state;

public class NoviceLevel extends Level {
    private final int EXP_NEXT_LVL = 20;

    public NoviceLevel(Character character) {
        super(character);
    }

    @Override
    public String getLevel() {
        return "Novice";
    }

    @Override
    public void action() {
        String[] options = { "Train", "Back to menu" };
        switch (this.getCharacter().readPlayerChoice(options)) {
            case 1:
                this.getCharacter().setExp(this.getCharacter().getExp() + EXP_TRAIN);
                System.out.println("You train. Exp + " + EXP_TRAIN);
                break;
            case 2:
                this.getCharacter().setIsPlaying(false);
                System.out.println("Return to main menu\n");
                break;
        }

        if (this.getCharacter().getExp() >= EXP_NEXT_LVL) {
            System.out.println("LEVEL UP!!!");
            this.getCharacter().setLevel(new IntermediateLevel(this.getCharacter()));
        }
    }
}
