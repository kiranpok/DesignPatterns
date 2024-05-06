package Assignment14_Builder;

public interface ComputerBuilder {
    void buildMotherboard();
    void buildProcessor();
    void buildRAM();
    void buildHardDrive();
    void buildGraphicCard();
    void buildPSU();
    void buildOS();
    Computer getComputer();
}
