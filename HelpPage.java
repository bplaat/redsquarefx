import javafx.geometry.Pos;
import javafx.scene.layout.Pane;

public class HelpPage extends Pane {
    HelpPage () {
        getChildren().addAll(
            Factory.getLabel("Help", 0, 20, "title", 640, Pos.BASELINE_CENTER),
            Factory.getButton("Back", Page.HOME, (640 - 200) / 2, 410, 200, 50)
        );
    }
}