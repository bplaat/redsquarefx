import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class Navigator {
    private static StackPane container;
    private static double scale;

    public static Scene getScene () {
        container = new StackPane(new HomePage());
        container.getStyleClass().add("container");
        container.setMinSize(640, 480);
        container.setMaxSize(640, 480);

        Scene scene = new Scene(new StackPane(container));
        scene.getStylesheets().add("style.css");
        ChangeListener<Number> sceneSizeListener = new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) {
                scale = scene.getWidth() < 640 * scene.getHeight() / 480
                    ? scene.getWidth() / 640
                    : scene.getHeight() / 480;
                container.setScaleX(scale);
                container.setScaleY(scale);
            }
        };
        scene.widthProperty().addListener(sceneSizeListener);
        scene.heightProperty().addListener(sceneSizeListener); 
        return scene;
    }

    public static double getScale () { return scale; }

    public static void changePage (Page page) {
        if (page == Page.HOME) container.getChildren().setAll(new HomePage());
        if (page == Page.GAME) container.getChildren().setAll(new GamePage());
        if (page == Page.HELP) container.getChildren().setAll(new HelpPage());
        if (page == Page.CREDITS) container.getChildren().setAll(new CreditsPage());
        if (page == Page.EXIT) Platform.exit();
    }
}