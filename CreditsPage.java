import javafx.geometry.Pos;
import javafx.scene.layout.Pane;

public class CreditsPage extends Pane {
    CreditsPage () {
        getChildren().addAll(
            Factory.getLabel("Credits", 0, 20, "title", 640, Pos.BASELINE_CENTER),
            Factory.getLabel("Game Developer", 0, 90, "subtitle", 640, Pos.BASELINE_CENTER),
            Factory.getLabel("Bastiaan van der Plaat", 0, 130, 640, Pos.BASELINE_CENTER),
            Factory.getLabel("Game Designer", 0, 170, "subtitle", 640, Pos.BASELINE_CENTER),
            Factory.getLabel("Bastiaan van der Plaat", 0, 210, 640, Pos.BASELINE_CENTER),
            Factory.getLabel("Original Idea", 0, 250, "subtitle", 640, Pos.BASELINE_CENTER),
            Factory.getLabel("Willem van der Plaat", 0, 290, 640, Pos.BASELINE_CENTER),
            Factory.getButton("Back", Page.HOME, (640 - 200) / 2, 410, 200, 50)
        );
    }
}