package Assignment14_Builder;

public class ComputerDirector {
    private ComputerBuilder builder;

    public  ComputerDirector(ComputerBuilder builder) {
        this.builder = builder;
    }

    public void buildComputer() {
        builder.buildMotherboard();
        builder.buildProcessor();
        builder.buildRAM();
        builder.buildHardDrive();
        builder.buildGraphicCard();
        builder.buildPSU();
        builder.buildOS();
    }
}
