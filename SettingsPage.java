import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class SettingsPage extends VBox {
    SettingsPage () {
        setSpacing(20);
        setAlignment(Pos.CENTER);
        getChildren().addAll(
            Factory.getTitle("Settings"),
            Factory.getButton("Back", Page.HOME)
        );
    }
}