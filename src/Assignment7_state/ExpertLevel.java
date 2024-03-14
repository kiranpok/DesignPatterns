package Assignment7_state;

public class ExpertLevel extends Level {
    private final int EXP_NEXT_LVL = 50;

    public ExpertLevel(Character character) {
        super(character);
    }

    @Override
    public String getLevel() {
        return "Expert";
    }

    @Override
    public void action() {
        String[] options = { "Train", "Meditate", "Fight", "Back to menu" };
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
                if (this.getCharacter().getHp() >= HP_FIGHT) {
                    this.getCharacter().setExp(this.getCharacter().getExp() + EXP_FIGHT);
                    this.getCharacter().setHp(this.getCharacter().getHp() - HP_FIGHT);
                    System.out.println("You fight. Exp + " + EXP_FIGHT + ". HP - " + HP_FIGHT);
                } else {
                    System.out.println("Your HP is not sufficient to fight.");
                }
                break;
            case 4:
                this.getCharacter().setIsPlaying(false);
                System.out.println("Return to main menu\n");
                break;
        }

        if (this.getCharacter().getExp() >= EXP_NEXT_LVL) {
            System.out.println("LEVEL UP!!!");
            this.getCharacter().setLevel(new MasterLevel(this.getCharacter()));
        }
    }
}
