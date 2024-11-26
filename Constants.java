package idle;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Constants {

  //Screen properties
  public static double SCREEN_WIDTH = 1000;
  public static double SCREEN_HEIGHT = 600;
  public static int FPS = 100;
  public static double DURATION = 1000.0/FPS;



  public static double CURRENCY_WIDTH = SCREEN_WIDTH*2/7;
  public static double CURRENCY_HEIGHT = SCREEN_HEIGHT;

  public static double GAME_WIDTH = SCREEN_WIDTH*3/7;
  public static double GAME_HEIGHT = SCREEN_HEIGHT;


  public static double UPGRADE_WIDTH = SCREEN_WIDTH-GAME_WIDTH-CURRENCY_WIDTH;
  public static double UPGRADE_HEIGHT = SCREEN_HEIGHT;

  public static int LABEL_FONT_SIZE = 24;

  public static double PARTICLE_Y = -100;
  public static double PARTICLE_DESPAWN_Y = SCREEN_HEIGHT+100;
  public static double LABEL_X = 30;
  public static double LABEL_Y = 100;
  public static double LABEL_PADDING = 100;
  public static double ANDY_X = 150;
  public static double ANDY_Y = 200;
  public static double SHADOW_RADIUS = 30;
  public static double GLOW_RADIUS = 60;


  public static String ANDY_PARTICLE = "idle/images/particles/andy.png";

  public static Color ANDY_SHADOW = new Color(0.2,0.2,0,1);
  public static Color ANDY_GLOW = Color.web("D0A131FF");
  public static Color ANDY_CLICK = Color.web("5FB244FF");


  public static final String GAME_PANE_STYLE =
      "-fx-background-color: #FFEDB6;"+
          "-fx-border-color: #FDBF68;" +
          "-fx-border-width: 20;";

  public static final String UPGRADE_PANE_STYLE =
      "-fx-background-color: #A4C48B;"+
          "-fx-border-color: #758E62;" +
          "-fx-border-width: 20;";

  public static final String CURRENCY_PANE_STYLE =
      "-fx-background-color: #FEA277;"+
          "-fx-border-color: #DC8D67;" +
          "-fx-border-width: 20;";
}
