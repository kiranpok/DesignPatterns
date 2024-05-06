package Assignment16_Bridge;

public class Main {
    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());

        LGTv lgtv = new LGTv();
        testDevice(lgtv);
        lgtv.browseInternet();
    }

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();

        System.out.println("Test with lg remote.");
        LGRemote lgRemote = new LGRemote(device);
        lgRemote.power();
        lgRemote.mute();
        lgRemote.voiceControl();
        device.printStatus();
    }
}
