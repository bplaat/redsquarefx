import javafx.geometry.Pos;
import javafx.scene.layout.Pane;

public class SettingsPage extends Pane {
    SettingsPage () {
        getChildren().addAll(
            Factory.getLabel("Settings", 0, 20, "title", 640, Pos.BASELINE_CENTER),
            Factory.getButton("Back", Page.HOME, (640 - 200) / 2, 410, 200, 50)
        );
    }
}