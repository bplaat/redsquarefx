import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class HighScorePage extends VBox {
    HighScorePage () {
        setSpacing(20);
        setAlignment(Pos.CENTER);
        getChildren().addAll(
            Factory.getTitle("High Score"),
            Factory.getLabel("Comming soon..."),
            Factory.getButton("Back", Page.HOME)
        );
    }
}