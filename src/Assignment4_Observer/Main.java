package Assignment4_Observer;

public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        WeatherObserver observer1 = new WeatherObserverImpl("Observer 1");
        WeatherObserver observer2 = new WeatherObserverImpl("Observer 2");

        weatherStation.registerObserver(observer1);
        weatherStation.registerObserver(observer2);

        weatherStation.start();

        try {
            Thread.sleep(10000); // Run simulation for 10 seconds
             // Stop the weather station thread
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        weatherStation.removeObserver(observer1);
    }
}
