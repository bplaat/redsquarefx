import javafx.geometry.Pos;
import javafx.scene.layout.Pane;

public class HelpPage extends Pane {
    HelpPage () {
        getChildren().addAll(
            Factory.getLabel("Help", 0, 20, "title", 640, Pos.BASELINE_CENTER),
            Factory.getLabel("RedSquareFX is an classic 2D action game.", 0, 90, 640, Pos.BASELINE_CENTER),
            Factory.getLabel("Click and hold the red square.", 0, 130, 640, Pos.BASELINE_CENTER),
            Factory.getLabel("Now move so that you neither touch the wall", 0, 170, 640, Pos.BASELINE_CENTER),
            Factory.getLabel("nor get hit by any of the blue squares.", 0, 210, 640, Pos.BASELINE_CENTER),
            Factory.getLabel("If you make it to 40 seconds, you are doing.", 0, 250, 640, Pos.BASELINE_CENTER),
            Factory.getLabel("brilliantly!", 0, 290, 640, Pos.BASELINE_CENTER),
            Factory.getButton("Back", Page.HOME, (640 - 200) / 2, 410, 200, 50)
        );
    }
}