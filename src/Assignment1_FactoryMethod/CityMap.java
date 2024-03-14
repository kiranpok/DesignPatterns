package Assignment1_FactoryMethod;

import java.util.Random;

public class CityMap extends Map {
    private Tile[][] map;

    public CityMap() {
        this.map = new Tile[5][5]; // Adjust the size as needed
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = createTile();
            }
        }
    }
    @Override
    public Tile createTile() {
        // Implement logic to create a random tile for a CityMap
        Random random = new Random();
        int rand = random.nextInt(3); // 0, 1, or 2

        switch (rand) {
            case 0:
                return new RoadTile();
            case 1:
                return new ForestTile();
            case 2:
                return new BuildingTile();
            default:
                throw new IllegalStateException("Unexpected value: " + rand);
        }
    }

    @Override
    public void display() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j].getCharacter() + " ");
            }
            System.out.println(); // Move to the next line for the next row
        }
    }
}
