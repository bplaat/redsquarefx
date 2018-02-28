import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class GamePage extends Pane {
    private SimpleDateFormat dateFormatter;
    private Date startTime, levelTime;
    private int score = 0, level = 1, borderSize = 50;
    private Label scoreLabel, timeLabel, levelLabel;
    private RedSquare red;
    private BlueSquare blue1, blue2, blue3, blue4;
    private AnimationTimer timer;

    GamePage () {
        dateFormatter = new SimpleDateFormat("HH:mm:ss");
        dateFormatter.setTimeZone(TimeZone.getTimeZone("GMT"));

        HBox container = new HBox();
        container.setPadding(new Insets(10, 50, 10, 50));
        container.setPrefWidth(640);

        container.getChildren().addAll(
            scoreLabel = Factory.getLabel("Score: " + score),
            timeLabel = Factory.getLabel("Time: " + dateFormatter.format(0)),
            levelLabel = Factory.getLabel("Level: " + level)
        );

        timeLabel.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(timeLabel, Priority.ALWAYS);
        timeLabel.setAlignment(Pos.CENTER);

        Rectangle border = new Rectangle(borderSize, borderSize, 640 - borderSize * 2, 480 - borderSize * 2);
        border.getStyleClass().add("border");

        getChildren().addAll(
            container, border,
            red = new RedSquare((640 - 50) / 2, (480 - 50) / 2, 50, 50),
            blue1 = new BlueSquare(0, 0, 75, 100, 1, 1),
            blue2 = new BlueSquare(640 - 150, 0, 150, 75, -1, 1),
            blue3 = new BlueSquare(0, 480 - 150, 75, 150, 1, -1),
            blue4 = new BlueSquare(640 - 100, 480 - 150, 100, 150, -1, -1)
        );

        timer = new AnimationTimer() {
            public void handle (long now) {
                score += level;
                scoreLabel.setText("Score: " + score);

                Date current = new Date();
                timeLabel.setText("Time: " + dateFormatter.format(current.getTime() - startTime.getTime()));

                if (current.getTime() - levelTime.getTime() > 10 * 1000) {
                    levelTime = new Date();
                    level += 1;
                    levelLabel.setText("Level: " + level);
                }

                blue1.move(level);
                blue2.move(level);
                blue3.move(level);
                blue4.move(level);

                if (collisionDetection()) gameover();
            }
        };
        startTime = levelTime = new Date();
        timer.start();
    }

    private boolean collisionDetection () {
	    return red.getX() < borderSize || red.getX() + red.getWidth() > 640 - borderSize ||
            red.getY() < borderSize || red.getY() + red.getHeight() > 480 - borderSize ||
            blue1.collision(red) || blue2.collision(red) || blue3.collision(red) || blue4.collision(red);
    }

    private void gameover () {
        timer.stop();
        red.gameover();
        VBox container = new VBox(20);
        container.setPrefSize(640, 480);
        container.getStyleClass().add("gameover");
        container.setAlignment(Pos.CENTER);
        container.getChildren().addAll(
            Factory.getTitle("Game Over"),
            Factory.getLabel(scoreLabel.getText()),
            Factory.getLabel(timeLabel.getText()),
            Factory.getLabel(levelLabel.getText()),
            Factory.getButton("Back", Page.HOME)
        );
        getChildren().add(container);
    }
}