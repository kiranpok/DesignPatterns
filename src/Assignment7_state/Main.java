package Assignment7_state;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("==========================");
            System.out.println("Game Character Development");
            System.out.println("1. New character\n2. Quit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter name: ");
                String name = scanner.nextLine();

                new Character(name).play();
            } else if (choice == 2) {
                System.out.println("You quit the game");
                break;
            }
        }
    }
}
