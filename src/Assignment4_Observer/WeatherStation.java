package Assignment4_Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



class WeatherStation extends Thread {
    private List<WeatherObserver> observers = new ArrayList<>();
    private int temperature;
    private final int MIN_TEMPERATURE = -10;
    private final int MAX_TEMPERATURE = 40;

    public WeatherStation() {
        this.temperature = generateRandomTemperature();
    }
    private boolean running = true;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(generateRandomTimeInterval());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int newTemperature = temperature + generateRandomChange();
            if (newTemperature < MIN_TEMPERATURE)
                newTemperature = MIN_TEMPERATURE;
            else if (newTemperature > MAX_TEMPERATURE)
                newTemperature = MAX_TEMPERATURE;
            temperature = newTemperature;
            notifyObservers();
        }
    }

    private int generateRandomTemperature() {
        return new Random().nextInt(MAX_TEMPERATURE - MIN_TEMPERATURE + 1) + MIN_TEMPERATURE;
    }

    private int generateRandomChange() {
        return new Random().nextBoolean() ? 1 : -1;
    }

    private long generateRandomTimeInterval() {
        return (long) (Math.random() * 5000) + 1000; // Random interval between 1 to 5 seconds
    }

    public synchronized void registerObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public synchronized void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    private synchronized void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature);
        }
    }
}
