import javafx.scene.layout.Pane;

public class HomePage extends Pane {
    HomePage () {
        setStyle("-fx-background-color: #222;");
        getChildren().add(Factory.getLabel("RedSquareFX", 32,               10, 1 * 10 + 0 * 50));
        getChildren().add(Factory.getButton("Play", Page.GAME,            10, 2 * 10 + 1 * 50, 200, 50));
        getChildren().add(Factory.getButton("High Score", Page.HIGHSCORE, 10, 3 * 10 + 2 * 50, 200, 50));
        getChildren().add(Factory.getButton("Help", Page.HELP,            10, 4 * 10 + 3 * 50, 200, 50));
        getChildren().add(Factory.getButton("Settings", Page.SETTINGS,    10, 5 * 10 + 4 * 50, 200, 50));
        getChildren().add(Factory.getButton("Credits", Page.CREDITS,      10, 6 * 10 + 5 * 50, 200, 50));
        getChildren().add(Factory.getButton("Exit", Page.EXIT,            10, 7 * 10 + 6 * 50, 200, 50));
    }
}