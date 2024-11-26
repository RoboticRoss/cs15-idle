package idle;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PainOrganizer {
  private BorderPane root;
  private Stage stage;

  public PainOrganizer(Stage stage) {
    this.stage = stage;
    this.root = new BorderPane();
    this.setupCurrencyPane();
    this.setupUpgradePane();
  }


  private void setupCurrencyPane() {
    Pane currencyPane = new Pane();
    currencyPane.setStyle(Constants.CURRENCY_PANE_STYLE);
    currencyPane.setPrefSize(Constants.CURRENCY_WIDTH,Constants.CURRENCY_HEIGHT);

    CurrencyLabel[] labels = new CurrencyLabel[]{
        new CurrencyLabel(currencyPane, "Characters", 0),
        new CurrencyLabel(currencyPane, "Lines", 0),
        new CurrencyLabel(currencyPane, "Methods", 0),
        new CurrencyLabel(currencyPane, "Classes", 0)
    };
    this.setupGamePane(labels);
    this.root.setLeft(currencyPane);
  }
  private void setupGamePane(CurrencyLabel[] labels) {
    Pane gamePane = new Pane();
    gamePane.setStyle(Constants.GAME_PANE_STYLE);
    gamePane.setPrefSize(Constants.GAME_WIDTH,Constants.GAME_HEIGHT);

    Pane particles = new Pane();
    gamePane.getChildren().add(particles);

    Stats stats = new Stats(labels);
    new Game(stats, gamePane, particles);
    this.root.setCenter(gamePane);
  }

  private void setupUpgradePane() {
    Pane upgradePane = new StackPane();
    upgradePane.setStyle(Constants.UPGRADE_PANE_STYLE);
    upgradePane.setPrefSize(Constants.UPGRADE_WIDTH,Constants.UPGRADE_HEIGHT);

    this.root.setRight(upgradePane);
  }

  public BorderPane getRoot() {
    return this.root;
  }
}
