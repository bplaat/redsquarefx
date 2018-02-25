import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
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
        return getLabel(text, fontSize, x, y, -1, Pos.BASELINE_LEFT);
    }

    public static Label getLabel (String text, int fontSize, int x, int y, int width, Pos alignment) {
        Label label = new Label(text);
        label.setLayoutX(x);
        label.setLayoutY(y);
        if (width != -1) label.setPrefWidth(width);
        label.setAlignment(alignment);
        label.setStyle("-fx-font-size: " + fontSize + "px; -fx-text-fill: white;");
        return label;
    }

    public static Rectangle getRectangle (int x, int y, int width, int height, Color color, Color stroke) {
        Rectangle rectangle = new Rectangle(x, y, width, height);
        rectangle.setFill(color);
        if (stroke != null) rectangle.setStroke(stroke);
        return rectangle;
    }
}