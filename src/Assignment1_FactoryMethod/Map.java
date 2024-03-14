package Assignment1_FactoryMethod;

// Map.java
import java.util.Random;

public abstract class Map {
    public abstract Tile createTile();
    public abstract void display();
}

