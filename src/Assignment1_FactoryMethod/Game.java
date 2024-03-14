package Assignment1_FactoryMethod;

import java.util.Random;

// Game.java
public class Game {
    public static void main(String[] args) {
        Map map = createMap(); // Use the factory method
        map.display(); // Display the generated map
    }

    public static Map createMap() {
        // Implement logic to create either a CityMap or a WildernessMap
        Random random = new Random();
        int rand = random.nextInt(2); // 0 or 1

        switch (rand) {
            case 0:
                return new CityMap();
            case 1:
                return new WildernessMap();
            default:
                throw new IllegalStateException("Unexpected value: " + rand);
        }
    }
}

