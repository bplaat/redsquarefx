import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class CreditsPage extends VBox {
    CreditsPage () {
        setSpacing(20);
        setAlignment(Pos.CENTER);
        getChildren().addAll(
            Factory.getTitle("Credits"),
            Factory.getSubTitle("Game Developer"),
            Factory.getLabel("Bastiaan van der Plaat"),
            Factory.getSubTitle("Game Designer"),
            Factory.getLabel("Bastiaan van der Plaat"),
            Factory.getSubTitle("Original Idea"),
            Factory.getLabel("Willem van der Plaat"),
            Factory.getButton("Back", Page.HOME)
        );
    }
}