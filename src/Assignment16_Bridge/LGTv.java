package Assignment16_Bridge;

public class LGTv extends Tv {
    @Override
    public void printStatus() {
        System.out.println("------------------------------------");
        System.out.println("| I'm LG Smart TV");
        System.out.println("| I'm " + (on ? "enabled" : "disabled"));
        System.out.println("| Current volume is " + volume + "%");
        System.out.println("| Current channel is " + channel);
        System.out.println("------------------------------------\n");
    }

    public void browseInternet() {
        System.out.println("| LG Smart Tv: open Internet browser");
    }
}

