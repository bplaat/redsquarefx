import javafx.scene.layout.Pane;

public class HelpPage extends Pane {
    HelpPage () {
        setStyle("-fx-background-color: #4a4;");
        getChildren().add(Factory.getLabel("Help", 32,        10, 1 * 10 + 0 * 50));
        getChildren().add(Factory.getButton("Back", Page.HOME, 10, 2 * 10 + 1 * 50, 200, 50));
    }
}