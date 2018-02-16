import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Factory {
    public static Button getButton (String text, Page page, int x, int y, int width, int height) {
        Button button = new Button(text);
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.setPrefWidth(width);
        button.setPrefHeight(height);
        button.setStyle("-fx-font-size: 18px;");
        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                Navigator.goTo(page);
            }
        });
        return button;
    }

    public static Label getLabel (String text, int fontSize, int x, int y) {
        Label label = new Label(text);
        label.setLayoutX(x);
        label.setLayoutY(y);
        label.setStyle("-fx-font-size: " + fontSize + "px; -fx-text-fill: white;");
        return label;
    }

    public static Rectangle getBorder (int borderSize) {
        Rectangle border = new Rectangle(borderSize, borderSize, 640 - borderSize * 2, 480 - borderSize * 2);
        border.setFill(Color.rgb(255, 255, 255, 0.5));
        border.setStroke(Color.WHITE);
        return border;
    }
}