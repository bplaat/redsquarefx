import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class GamePage extends Pane {
    private SimpleDateFormat dateFormatter;

    private Date startTime, levelTime;
    private int borderSize = 50, score = 0, level = 1;

    private Label scoreLabel, timeLabel, levelLabel;

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

        scoreLabel = Factory.getLabel("Score: " + score, 18, 32, 4);
        timeLabel = Factory.getLabel("Time: " + dateFormatter.format(0), 18, 200, 4);
        levelLabel = Factory.getLabel("Level: " + level, 18, 400, 4);
        getChildren().addAll(Factory.getBorder(borderSize), scoreLabel, timeLabel, levelLabel);

        red = new RedSquare((640 - 75) / 2, (480 - 75) / 2, 75, 75);
        blue1 = new BlueSquare(0, 0, 75, 100, 1, 1);
        blue2 = new BlueSquare(640 - 150, 0, 150, 75, -1, 1);
        blue3 = new BlueSquare(0, 480 - 150, 75, 150, 1, -1);
        blue4 = new BlueSquare(640 - 100, 480 - 150, 100, 150, -1, -1);
        getChildren().addAll(red, blue1, blue2, blue3, blue4);

        AnimationTimer timer = new AnimationTimer() {
            public void handle (long now) {
                score += level;
                scoreLabel.setText("Score: " + score);

                Date current = new Date();
                timeLabel.setText(dateFormatter.format(current.getTime() - startTime.getTime()));

                if (current.getTime() - levelTime.getTime() > 10 * 1000) {
                    levelTime = new Date();
                    level++;
                    levelLabel.setText("Level: " + level);
                }

                blue1.move(level);
                blue2.move(level);
                blue3.move(level);
                blue4.move(level);

                if (collisionDetection()) {
                    stop();
                    getChildren().add(Factory.getButton("Back", Page.HOME, 10, 1 * 10 + 0 * 50, 200, 50));
                }
            }
        };

        startTime = levelTime = new Date();
        timer.start();
    }
}