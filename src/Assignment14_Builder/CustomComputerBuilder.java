package Assignment14_Builder;

import java.util.Scanner;

public class CustomComputerBuilder implements ComputerBuilder {
    private Computer computer;
    private Scanner scanner;

    public CustomComputerBuilder() {
        this.computer = new Computer();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void buildMotherboard() {
        System.out.println("Choose motherboard:");
        String motherboard = scanner.nextLine() + " motherboard";
        computer.addComponent(new Component(motherboard));
    }

    @Override
    public void buildProcessor() {
        System.out.println("Choose processor:");
        String cpu = scanner.nextLine() + " processor";
        computer.addComponent(new Component(cpu));
    }

    @Override
    public void buildRAM() {
        System.out.println("Choose RAM capacity (GB):");
        String ram = scanner.nextInt() + "GB RAM";
        computer.addComponent(new Component(ram));
        scanner.nextLine();
    }

    @Override
    public void buildGraphicCard() {
        System.out.println("Choose graphic card:");
        String graphicCard = scanner.nextLine() + " graphic card";
        computer.addComponent(new Component(graphicCard));
    }

    @Override
    public void buildHardDrive() {
        System.out.println("Choose hard drive capacity (GB):");
        String hardDrive = scanner.nextInt() + "GB SSD";
        computer.addComponent(new Component(hardDrive));
        scanner.nextLine();
    }

    @Override
    public void buildPSU() {
        System.out.println("Choose PSU wattage (W):");
        String psu = scanner.nextInt() + "W PSU";
        computer.addComponent(new Component(psu));
        scanner.nextLine();
    }

    @Override
    public void buildOS() {
        System.out.println("Choose operating system:");
        String os = scanner.nextLine() + " OS";
        computer.addComponent(new Component(os));
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
