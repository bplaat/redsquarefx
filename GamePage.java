import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GamePage extends Pane {
    private SimpleDateFormat dateFormatter;

    private Date startTime, levelTime;
    private int borderSize = 50, score = 0, level = 1;

    private Label scoreLabel, timeLabel, levelLabel;
    private Rectangle border;

    private RedSquare red;
    private BlueSquare blue1, blue2, blue3, blue4;

    private boolean collisionDetection () {
	    return red.getX() < borderSize || red.getX() + red.getWidth() > 640 - borderSize ||
            red.getY() < borderSize || red.getY() + red.getHeight() > 480 - borderSize ||
            blue1.collision(red) || blue2.collision(red) || blue3.collision(red) || blue4.collision(red);
    }

    GamePage () {
        setStyle("-fx-background-color: #29f;");

        dateFormatter = new SimpleDateFormat("HH:mm:ss");
        dateFormatter.setTimeZone(TimeZone.getTimeZone("GMT"));

        getChildren().addAll(
            scoreLabel = Factory.getLabel("Score: " + score, 20, borderSize, 8),
            timeLabel = Factory.getLabel("Time: " + dateFormatter.format(0), 20, borderSize, 8, 640 - borderSize * 2, Pos.BOTTOM_CENTER),
            levelLabel = Factory.getLabel("Level: " + level, 20, borderSize, 8, 640 - borderSize * 2, Pos.BASELINE_RIGHT),
            border = Factory.getRectangle(borderSize, borderSize, 640 - borderSize * 2, 480 - borderSize * 2, Color.rgb(255, 255, 255, 0.5), Color.WHITE),

            red = new RedSquare((640 - 50) / 2, (480 - 50) / 2, 50, 50),
            blue1 = new BlueSquare(0, 0, 75, 100, 1, 1),
            blue2 = new BlueSquare(640 - 150, 0, 150, 75, -1, 1),
            blue3 = new BlueSquare(0, 480 - 150, 75, 150, 1, -1),
            blue4 = new BlueSquare(640 - 100, 480 - 150, 100, 150, -1, -1)
        );

        AnimationTimer timer = new AnimationTimer() {
            public void handle (long now) {
                score += level;
                scoreLabel.setText("Score: " + score);

                Date current = new Date();
                timeLabel.setText("Time: " + dateFormatter.format(current.getTime() - startTime.getTime()));

                if (current.getTime() - levelTime.getTime() > 10 * 1000) {
                    levelTime = new Date();
                    levelLabel.setText("Level: " + (++level));
                }

                blue1.move(level);
                blue2.move(level);
                blue3.move(level);
                blue4.move(level);

                if (collisionDetection()) {
                    stop();
                    gameover();
                }
            }
        };

        startTime = levelTime = new Date();
        timer.start();
    }

    private void gameover () {
        getChildren().addAll(
            Factory.getRectangle(0, 0, 640, 480, Color.rgb(0, 0, 0, 0.8), null),
            Factory.getLabel("Game Over", 48, 0, 0, 640, Pos.BASELINE_CENTER),
            Factory.getLabel(scoreLabel.getText(), 24, 0, 75, 640, Pos.BASELINE_CENTER),
            Factory.getLabel(timeLabel.getText(), 24, 0, 125, 640, Pos.BASELINE_CENTER),
            Factory.getLabel(levelLabel.getText(), 24, 0, 175, 640, Pos.BASELINE_CENTER),
            Factory.getButton("Back", Page.HOME, (640 - 200) / 2, 225, 200, 50)
        );
    }
}