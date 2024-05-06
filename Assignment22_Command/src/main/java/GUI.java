import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

public class GUI extends Application {
    private final int TILE_SIZE = 32;
    private GridPane gridPane;
    private Rectangle currentPixel = new Rectangle();
    private PixelGrid pixelGrid;

    private int[][] pixelArt = {
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 1, 0, 1, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 0, 0},
            {0, 0, 0, 1, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 1, 0, 0, 1, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
    };

    @Override
    public void start(Stage primaryStage) {
        pixelGrid = new PixelGrid(this);
        //pixelGrid = new PixelGrid(pixelArt, this);

        Command moveUp = new MoveCursorUpCommand(pixelGrid);
        Command moveDown = new MoveCursorDownCommand(pixelGrid);
        Command moveLeft = new MoveCursorLeftCommand(pixelGrid);
        Command moveRight = new MoveCursorRightCommand(pixelGrid);
        Command togglePixel = new TogglePixelCommand(pixelGrid);
        Command generateCode = new GenerateCodeCommand(pixelGrid);

        Controller controller = new Controller(moveUp, moveDown, moveLeft, moveRight, togglePixel, generateCode);

        gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(1);
        gridPane.setVgap(1);

        int[][] grid = pixelGrid.getGrid();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                Rectangle pixel = new Rectangle(TILE_SIZE, TILE_SIZE);
                pixel.setFill(grid[i][j] == 1 ? Color.BLACK : Color.WHITE);
                gridPane.add(pixel, j, i);
            }
        }

        setCursor();

        Button generateCodeBtn = new Button("Generate Code");
        generateCodeBtn.setAlignment(Pos.CENTER);

        VBox btnContainer = new VBox();
        btnContainer.getChildren().add(generateCodeBtn);
        btnContainer.setPadding(new Insets(5));
        btnContainer.setAlignment(Pos.CENTER);

        VBox root = new VBox();
        root.getChildren().addAll(gridPane, btnContainer);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root);

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP -> controller.moveUp();
                case DOWN -> controller.moveDown();
                case LEFT -> controller.moveLeft();
                case RIGHT -> controller.moveRight();
                case SPACE -> controller.togglePixel();
            }
        });
        generateCodeBtn.setOnAction(e -> {
            controller.generateCode();
            root.requestFocus();
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("Pixel Art Editor");
        primaryStage.show();

        root.requestFocus();
    }

    public void setCursor() {
        currentPixel.setStroke(null);

        int row = pixelGrid.getX();
        int column = pixelGrid.getY();

        for (Node node : gridPane.getChildren()) {
            if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
                currentPixel = (Rectangle) node;
            }
        }

        currentPixel.setStroke(Color.ROYALBLUE);
        currentPixel.setStrokeType(StrokeType.INSIDE);
        currentPixel.setStrokeWidth(2);
    }

    public void togglePixel() {
        if (currentPixel.getFill() == Color.BLACK) {
            currentPixel.setFill(Color.WHITE);
        } else {
            currentPixel.setFill(Color.BLACK);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}