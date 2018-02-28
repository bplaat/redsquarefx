import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Factory {
    public static Button getButton (String text, Page page) {
        Button button = new Button(text);
        button.setPrefSize(200, 50);
        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Navigator.changePage(page);
            }
        });
        return button;
    }

    public static Label getTitle (String text) {
        Label title = new Label(text);
        title.getStyleClass().add("title");
        return title;
    }

    public static Label getSubTitle (String text) {
        Label subtitle = new Label(text);
        subtitle.getStyleClass().add("subtitle");
        return subtitle;
    }

    public static Label getLabel (String text) {
        return new Label(text);
    }
}