package Assignment1_FactoryMethod;

public class RoadTile extends Tile {
    @Override
    public char getCharacter() {
        return 'R';
    }

    @Override
    public String getType() {
        return "road";
    }
}
