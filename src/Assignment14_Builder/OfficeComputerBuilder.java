package Assignment14_Builder;

public class OfficeComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public OfficeComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildMotherboard() {
        computer.addComponent(new Component("Office computer motherboard"));
    }

    @Override
    public void buildProcessor() {
        computer.addComponent(new Component("4-core CPU"));
    }

    @Override
    public void buildRAM() {
        computer.addComponent(new Component("8GB RAM"));
    }

    @Override
    public void buildGraphicCard() {}

    @Override
    public void buildHardDrive() {
        computer.addComponent(new Component("512GB SSD"));
    }

    @Override
    public void buildPSU() {
        computer.addComponent(new Component("300W PSU"));
    }

    @Override
    public void buildOS() {
        computer.addComponent(new Component("Windows 11 Home"));
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}