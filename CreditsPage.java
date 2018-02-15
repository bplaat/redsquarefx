import javafx.scene.layout.Pane;

public class CreditsPage extends Pane {
    CreditsPage () {
        setStyle("-fx-background-color: #f44;");
        getChildren().add(Factory.getLabel("Credits", 32,      10, 1 * 10 + 0 * 50));
        getChildren().add(Factory.getButton("Back", Page.HOME, 10, 2 * 10 + 1 * 50, 200, 50));
    }
}