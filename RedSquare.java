import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class RedSquare extends Rectangle {
    private double offsetX, offsetY;

    RedSquare (int x, int y, int width, int height) {
        super(x, y, width, height);
        getStyleClass().add("red");

        setOnMousePressed(new EventHandler<MouseEvent> () {
            public void handle (MouseEvent event) {
                offsetX = (int)event.getSceneX() / Navigator.getScale() - (int)getX();
                offsetY = (int)event.getSceneY() / Navigator.getScale() - (int)getY();
            }
        });

        setOnMouseDragged(new EventHandler<MouseEvent> () {
            public void handle (MouseEvent event) {
                setX(event.getSceneX() / Navigator.getScale() - offsetX);
                setY(event.getSceneY() / Navigator.getScale() - offsetY);
            }
        });
    }
}