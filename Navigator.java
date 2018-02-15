import javafx.application.Platform;
import javafx.scene.Scene;

public class Navigator {
    private static Scene scene;

    public static Scene getScene () {
        return scene = new Scene(new HomePage(), 640, 480);
    }

    public static void goTo (Page page) {
        if (page == Page.HOME) scene.setRoot(new HomePage());
        if (page == Page.GAME) scene.setRoot(new GamePage());
        if (page == Page.HIGHSCORE) scene.setRoot(new HighScorePage());
        if (page == Page.HELP) scene.setRoot(new HelpPage());
        if (page == Page.SETTINGS) scene.setRoot(new SettingsPage());
        if (page == Page.CREDITS) scene.setRoot(new CreditsPage());
        if (page == Page.EXIT) Platform.exit();
    }
}