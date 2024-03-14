package Assignment4_Observer;

class WeatherObserverImpl implements WeatherObserver {
    private String name;

    public WeatherObserverImpl(String name) {
        this.name = name;
    }

    @Override
    public void update(int temperature) {
        System.out.println(name + " received notification: Current temperature is " + temperature + " degrees.");
    }
}
