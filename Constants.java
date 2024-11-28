package idle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Constants {

  //Screen properties
  public static double SCREEN_WIDTH = 1000;
  public static double SCREEN_HEIGHT = 750;
  public static int FPS = 100;
  public static double DURATION = 1000.0/FPS;

  public static double UPGRADE_PANE_WIDTH = SCREEN_WIDTH;
  public static double UPGRADE_PANE_HEIGHT = 150;

  public static double CURRENCY_WIDTH = 300;
  public static double CURRENCY_HEIGHT = SCREEN_HEIGHT-UPGRADE_PANE_HEIGHT;

  public static double GAME_WIDTH = 400;
  public static double GAME_HEIGHT = CURRENCY_HEIGHT;


  public static double PROEJCT_PANE_WIDTH = 300;
  public static double PROEJCT_PANE_HEIGHT = CURRENCY_HEIGHT;

  public static double UPGRADE_BOX_WIDTH = 150;
  public static double UPGRADE_BOX_HEIGHT = 50;
  public static double UPGRADE_BOX_X = 900;



  public static int LABEL_FONT_SIZE = 24;

  public static double PARTICLE_Y = -100;
  public static double PARTICLE_DESPAWN_Y = SCREEN_HEIGHT+100;
  public static double LABEL_X = 30;
  public static double LABEL_Y = 90;
  public static double LABEL_PADDING = 120;
  public static double LABEL_NAME_SPACING = 50;
  public static double LABEL_INCOME_SPACING = 70;


  public static double TOOLTIP_TEXT_X = 30;
  public static double TOOLTIP_TEXT_Y = 45;


  public static double ANDY_X = 150;
  public static double ANDY_Y = 200;
  public static double SHADOW_RADIUS = 30;
  public static double GLOW_RADIUS = 60;

  public static String FONT = "Comic Sans MS Bold";

  public static Font VALUE_TEXT;
  public static Font INCOME_TEXT;
  public static Font NAME_TEXT;
  public static Font TOOLTIP_TITLE;
  public static Font TOOLTIP_TEXT;
  public static Font TOOLTIP_COST;
  public static Font TOOLTIP_BUY;


  static {
    try {
      VALUE_TEXT = Font.loadFont(new FileInputStream("src/idle/fonts/pixel.ttf"), 50);
      INCOME_TEXT = Font.loadFont(new FileInputStream("src/idle/fonts/pixel.ttf"), 16);
      NAME_TEXT = Font.loadFont(new FileInputStream("src/idle/fonts/pixel.ttf"), 20);
      TOOLTIP_TITLE = Font.loadFont(new FileInputStream("src/idle/fonts/pixel.ttf"), 22);
      TOOLTIP_TEXT = Font.loadFont(new FileInputStream("src/idle/fonts/pixel.ttf"), 14);
      TOOLTIP_COST = Font.loadFont(new FileInputStream("src/idle/fonts/pixel.ttf"), 16);
      TOOLTIP_BUY = Font.loadFont(new FileInputStream("src/idle/fonts/pixel.ttf"), 12);

    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }





  public static String ANDY_PARTICLE = "idle/images/particles/andy.png";

  public static Color ANDY_SHADOW = new Color(0.2,0.2,0,1);
  public static Color ANDY_GLOW = Color.web("D0A131FF");
  public static Color ANDY_CLICK = Color.web("5FB244FF");


  public static final String GAME_PANE_STYLE =
      "-fx-background-color: #FFEDB6;"+
          "-fx-border-color: #FDBF68;" +
          "-fx-border-width: 20;";

  public static final String UPGRADE_PANE_STYLE =
      "-fx-background-color: #B6E8FF;"+
          "-fx-border-color: #68C2FD;" +
          "-fx-border-width: 20;";

  public static final String PROJECT_PANE_STYLE =
      "-fx-background-color: #CFFFBD;"+
          "-fx-border-color: #A8D768;" +
          "-fx-border-width: 20;";

  public static final String CURRENCY_PANE_STYLE =
      "-fx-background-color: #FFC9C9;"+
          "-fx-border-color: #FD8A68;" +
          "-fx-border-width: 20;";
}
