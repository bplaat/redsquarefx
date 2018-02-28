import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class RedSquare extends Rectangle {
    private double offsetX, offsetY;

    private boolean gameover = false;
    public void gameover () { this.gameover = true; }

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
                if (!gameover) {
                    setX(event.getSceneX() / Navigator.getScale() - offsetX);
                    setY(event.getSceneY() / Navigator.getScale() - offsetY);
                }
            }
        });
    }
}