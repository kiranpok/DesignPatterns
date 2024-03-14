package Assignment7_state;

import java.util.Scanner;

public class Character {
    private static Scanner scanner = new Scanner(System.in);
    private String name;
    private Level level;
    private int exp = 0;
    private int hp = 10;
    private boolean isPlaying = true;

    public Character(String name) {
        this.name = name;
        level = new NoviceLevel(this);
    }

    public void play() {
        while (isPlaying) {
            printInfo();

            level.action();
        }
    }

    public void printInfo() {
        System.out.println("\n###############");
        System.out.println("Name: " + name);
        System.out.println("Level: " + getLevel());
        System.out.println("HP: " + hp);
        System.out.println("EXP: " + exp);
        System.out.println("###############");
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level.getLevel();
    }

    public int getHp() {
        return hp;
    }

    public int getExp() {
        return exp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setIsPlaying(boolean playing) {
        isPlaying = playing;
    }

    public int readPlayerChoice(String[] options) {
        System.out.println("Select an action:");
        for (int i = 1; i <= options.length; i++) {
            System.out.println(i + ". " + options[i - 1]);
        }

        return scanner.nextInt();
    }
}
