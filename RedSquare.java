import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RedSquare extends Rectangle {
    private int offsetX, offsetY;

    RedSquare (int x, int y, int width, int height) {
        super(x, y, width, height);
        setFill(Color.rgb(255, 0, 0, 0.8));

        setOnMousePressed(new EventHandler<MouseEvent> () {
            public void handle (MouseEvent e) {
                offsetX = (int)e.getSceneX() - (int)getX();
                offsetY = (int)e.getSceneY() - (int)getY();
            }
        });

        setOnMouseDragged(new EventHandler<MouseEvent> () {
            public void handle (MouseEvent e) {
                setX(e.getSceneX() - offsetX);
                setY(e.getSceneY() - offsetY);
            }
        });
    }
}