package Assignment1_FactoryMethod;

// SwampTile.java
public class SwampTile extends Tile {
    @Override
    public char getCharacter() {
        return 'S';
    }

    @Override
    public String getType() {
        return "swamp";
    }
}
