import javafx.scene.layout.Pane;

public class HighScorePage extends Pane {
    HighScorePage () {
        setStyle("-fx-background-color: #088;");
        getChildren().add(Factory.getLabel("High Score", 32,   10, 1 * 10 + 0 * 50));
        getChildren().add(Factory.getButton("Back", Page.HOME, 10, 2 * 10 + 1 * 50, 200, 50));
    }
}