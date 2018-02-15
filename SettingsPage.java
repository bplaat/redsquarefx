import javafx.scene.layout.Pane;

public class SettingsPage extends Pane {
    SettingsPage () {
        setStyle("-fx-background-color: #4a4;");
        getChildren().add(Factory.getLabel("Settings", 32,     10, 1 * 10 + 0 * 50));
        getChildren().add(Factory.getButton("Back", Page.HOME, 10, 2 * 10 + 1 * 50, 200, 50));
    }
}