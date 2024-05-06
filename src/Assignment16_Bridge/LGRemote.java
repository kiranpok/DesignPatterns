package Assignment16_Bridge;

public class LGRemote extends AdvancedRemote {
    public LGRemote(Device device) {
        super(device);
    }

    public void voiceControl() {
        System.out.println("Remote: voice control activated, please speak into the mic");
    }
}

