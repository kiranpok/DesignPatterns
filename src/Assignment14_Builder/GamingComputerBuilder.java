package Assignment14_Builder;

public class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildMotherboard() {
        computer.addComponent(new Component("Gaming computer motherboard"));
    }

    @Override
    public void buildProcessor() {
        computer.addComponent(new Component("8-core CPU"));
    }

    @Override
    public void buildRAM() {
        computer.addComponent(new Component("16GB RAM"));
    }

    @Override
    public void buildGraphicCard() {
        computer.addComponent(new Component("Radeon RX Graphic Card"));
    }

    @Override
    public void buildHardDrive() {
        computer.addComponent(new Component("2TB SSD"));
    }

    @Override
    public void buildPSU() {
        computer.addComponent(new Component("700W PSU"));
    }

    @Override
    public void buildOS() {
        computer.addComponent(new Component("Windows 11 Pro"));
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
