package Assignment7_state;

public class IntermediateLevel extends Level {
    private final int EXP_NEXT_LVL = 30;

    public IntermediateLevel(Character character) {
        super(character);
    }

    @Override
    public String getLevel() {
        return "Intermediate";
    }

    @Override
    public void action() {
        String[] options = { "Train", "Meditate", "Back to menu" };
        switch (this.getCharacter().readPlayerChoice(options)) {
            case 1:
                this.getCharacter().setExp(this.getCharacter().getExp() + EXP_TRAIN);
                System.out.println("You train. Exp + " + EXP_TRAIN);
                break;
            case 2:
                this.getCharacter().setHp(this.getCharacter().getHp() + HP_MEDITATE);
                System.out.println("You meditate. HP + " + HP_MEDITATE);
                break;
            case 3:
                this.getCharacter().setIsPlaying(false);
                System.out.println("Return to main menu\n");
                break;
        }

        if (this.getCharacter().getExp() >= EXP_NEXT_LVL) {
            System.out.println("LEVEL UP!!!");
            this.getCharacter().setLevel(new ExpertLevel(this.getCharacter()));
        }
    }
}
