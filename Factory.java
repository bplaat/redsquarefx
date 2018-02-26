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
        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                Navigator.goTo(page);
            }
        });
        return button;
    }

    public static Label getLabel (String text, int x, int y) {
        return getLabel(text, x, y, null, -1, null);
    }

    public static Label getLabel (String text, int x, int y, String style) {
        return getLabel(text, x, y, style, -1, null);
    }

    public static Label getLabel (String text, int x, int y, int width, Pos alignment) {
        return getLabel(text, x, y, null, width, alignment);
    }

    public static Label getLabel (String text, int x, int y, String style, int width, Pos alignment) {
        Label label = new Label(text);
        label.setLayoutX(x);
        label.setLayoutY(y);
        if (style != null) label.getStyleClass().add(style);
        if (width != -1) label.setPrefWidth(width);
        if (alignment != null) label.setAlignment(alignment);
        return label;
    }
    
    public static Rectangle getRectangle (int x, int y, int width, int height, Color color) {
        Rectangle rectangle = new Rectangle(x, y, width, height);
        rectangle.setFill(color);
        return rectangle;
    }
}