package Assignment14_Builder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ComputerDirector director;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Build:\n1.Pre-configured Office PC\n2.Pre-configured Gaming PC\n3.Custom PC");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                ComputerBuilder officePCBuilder = new OfficeComputerBuilder();
                director = new ComputerDirector(officePCBuilder);

                director.buildComputer();
                System.out.println("Office PC:\n" + officePCBuilder.getComputer());

                break;
            case 2:
                ComputerBuilder gamingPCBuilder = new GamingComputerBuilder();
                director = new ComputerDirector(gamingPCBuilder);

                director.buildComputer();
                System.out.println("Gaming PC:\n" + gamingPCBuilder.getComputer());

                break;
            case 3:
                ComputerBuilder customPCBuilder = new CustomComputerBuilder();
                director = new ComputerDirector(customPCBuilder);

                director.buildComputer();
                System.out.println("Custom build:\n" + customPCBuilder.getComputer());

                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
}
