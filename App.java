package idle;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Welcome to DoodleJump!
 * Bounce around and ascend on a variety of platforms
 * Change the difficulty or even play multiplayer!
 */
public class App extends Application {

    /**
     * Starts the game by sending a setup screen
     * @param stage the primary stage for this application, onto which
     * the application scene can be set. The primary stage will be embedded in
     * the browser if the application was launched as an applet.
     * Applications may create other stages, if needed, but they will not be
     * primary stages and will not be embedded in the browser.
     */
    @Override
    public void start(Stage stage) {
        //Creates the start screen where the player selects the difficulty
        PainOrganizer organizer = new PainOrganizer(stage);
        Scene scene = new Scene(organizer.getRoot(), Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        stage.setScene(scene);
        stage.setTitle("CS15 IDLE");
        stage.setResizable(false);
        stage.show();
    }


    public static void main(String[] argv) {
        // launch is a static method inherited from Application.
        launch(argv);
    }
}
