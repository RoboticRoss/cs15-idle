package idle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Constants {

  //Screen properties
  public static double SCREEN_WIDTH = 1050;
  public static double SCREEN_HEIGHT = 850;
  public static int FPS = 100;
  public static double DURATION = 1000.0/FPS;

  public static double UPGRADE_PANE_WIDTH = SCREEN_WIDTH;
  public static double UPGRADE_PANE_HEIGHT = 150;

  public static double CURRENCY_WIDTH = 300;
  public static double CURRENCY_HEIGHT = SCREEN_HEIGHT-UPGRADE_PANE_HEIGHT;

  public static double GAME_WIDTH = 400;
  public static double GAME_HEIGHT = CURRENCY_HEIGHT;


  public static double PROEJCT_PANE_WIDTH = 350;
  public static double PROEJCT_PANE_HEIGHT = CURRENCY_HEIGHT;

  public static double UPGRADE_BOX_WIDTH = 150;
  public static double UPGRADE_BOX_HEIGHT = 50;
  public static double UPGRADE_BOX_X = 870;
  public static double UPGRADE_BOX_Y = 26;


  public static double PROJECT_BOX_WIDTH = 290;
  public static double PROJECT_BOX_HEIGHT = 60;
  public static double PROJECT_BOX_X = 30;
  public static double PROJECT_BOX_Y = 26;
  public static double PROJECT_BOX_PADDING = 80;



  public static int LABEL_FONT_SIZE = 24;

  public static double PARTICLE_Y = -100;
  public static double PARTICLE_DESPAWN_Y = SCREEN_HEIGHT+100;
  public static double LABEL_X = 30;
  public static double LABEL_Y = 90;
  public static double LABEL_PADDING = 120;
  public static double LABEL_NAME_SPACING = 50;
  public static double LABEL_INCOME_SPACING = 70;


  public static double TOOLTIP_TEXT_X = 20;
  public static double TOOLTIP_TEXT_Y = 40;
  public static double UPGRADE_SIZE = 96; //px


  public static double ANDY_X = 130;
  public static double ANDY_Y = 200;
  public static double SHADOW_RADIUS = 20;
  public static double GLOW_RADIUS = 60;

  public static String FONT = "Comic Sans MS Bold";

  public static Font VALUE_TEXT,INCOME_TEXT, NAME_TEXT
,TOOLTIP_TITLE
,TOOLTIP_TEXT
,TOOLTIP_COST
,PROJECT_NAME
,PROJECT_COST
,TOOLTIP_BUY;


  static {
    try {
      VALUE_TEXT = Font.loadFont(new FileInputStream("src/idle/fonts/joystix.ttf"), 50);
      INCOME_TEXT = Font.loadFont(new FileInputStream("src/idle/fonts/pixel.ttf"), 16);
      NAME_TEXT = Font.loadFont(new FileInputStream("src/idle/fonts/pixel.ttf"), 20);
      TOOLTIP_TITLE = Font.loadFont(new FileInputStream("src/idle/fonts/pixel.ttf"), 22);
      TOOLTIP_TEXT = Font.loadFont(new FileInputStream("src/idle/fonts/pixel.ttf"), 14);
      TOOLTIP_COST = Font.loadFont(new FileInputStream("src/idle/fonts/pixel.ttf"), 16);
      PROJECT_NAME = Font.loadFont(new FileInputStream("src/idle/fonts/pixel.ttf"), 35);
      TOOLTIP_BUY = Font.loadFont(new FileInputStream("src/idle/fonts/pixel.ttf"), 18);

    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }





  public static String ANDY_PARTICLE = "idle/images/particles/andy.png";

  public static Color PROECT_BORDER_READY = Color.MEDIUMPURPLE;
  public static Color PROECT_BACKGROUND_READY = Color.LAVENDER;
  public static Color PROECT_BACKGROUND_LOCKED = Color.GRAY;
  public static Color PROECT_BORDER_LOCKED = Color.DARKGRAY;
  public static Color PROECT_BORDER2 = new Color(0.2,0.2,0,0.6);

  public static Color ANDY_SHADOW = new Color(0.2,0.2,0,0.6);
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



  public static int[][][] UPGRADE_VALS = new int[][][]{
      {{0,10,2},{0,15,2}, {0,50,3}, {2,25,3}, {3,10,5}}, //Prices for rattytouille
      {{0,100,2},{1,15,2}, {1,50,3}, {2,25,3}, {3,10,5}}, //Prices for andybot
  };
  public static String[][][] upgradeText = new String[][][]{
      { //Rattytouille
        {"Bigger Kitchen", "Doubles the efficiency of Rattytouille Rats!"},
        {"Non-Stick Pans","Doubles the efficiency of Rattytouille Rats!"},
        {"Swiss Cheese","Triples the efficiency of Rattytouille Rats!"},
        {"Chef Kevin","Triples the efficiency of Rattytouille Rats!"},
        {"Linguini","5x efficiency of Rattytouille Rats!"}
      },
      { //Andybot
        {"",""},
        {"BFS",""},
        {"",""},
        {"",""},
        {"",""}
      },
      { //Pong
          {"",""},
          {"",""},
          {"",""},
          {"",""},
          {"",""}
      },
      { //Tictactoe
          {"",""},
          {"",""},
          {"",""},
          {"",""},
          {"",""}
      },
      { //Fruit ninja
          {"",""},
          {"",""},
          {"",""},
          {"",""},
          {"",""}
      },
      { //Cartoon
          {"",""},
          {"",""},
          {"",""},
          {"",""},
          {"",""}
      },
      { //DoodleJump
          {"",""},
          {"",""},
          {"",""},
          {"",""},
          {"",""}
      },
      { //Tetris
          {"",""},
          {"",""},
          {"",""},
          {"",""},
          {"",""}
      },
  };


  public static String[][] PROJECT_DISPLAY = {
      {"Rattytouille", ""},
      {"Andybot", "BEEP BOOP [ENTER PASSWORD]"},
      {"Pong", ""},
      {"Tic-Tac-Toe", ""},
      {"Fruit Ninja", ""},
      {"Cartoon", "Alienmover? I hardly know her!"},
      {"Doodle Jump", ""},
      {"Tetris", ""},
      {"Pac-Man", ""}
  };

  public static int[] BASE_PROJECT_PRICES = new int[]{
      10,40,2
  };
  public static double[] BASE_PROJECT_INCOMES = new double[]{
      0.1,1,5,10
  };

  public static CurrencyType[] PROJECT_INCOME_TYPES = new CurrencyType[]{
      CurrencyType.CHARACTERS,
      CurrencyType.CHARACTERS,
      CurrencyType.CHARACTERS,
      CurrencyType.CHARACTERS,

  };

  public static int[] UNLOCK_INCREMENTS = new int[]{
      1,5,10,25,50
  };


}
