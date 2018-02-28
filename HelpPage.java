import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class HelpPage extends VBox {
    HelpPage () {
        setSpacing(20);
        setAlignment(Pos.CENTER);
        getChildren().addAll(
            Factory.getTitle("Help"),
            Factory.getLabel("RedSquareFX is an classic 2D action game."),
            Factory.getLabel("Click and hold the red square."),
            Factory.getLabel("Now move so that you neither touch the wall"),
            Factory.getLabel("nor get hit by any of the blue squares."),
            Factory.getLabel("If you make it to 40 seconds, you are doing"),
            Factory.getLabel("it brilliantly!"),
            Factory.getButton("Back", Page.HOME)
        );
    }
}