package idle;

import idle.currency.Currency;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PainOrganizer {
  private BorderPane root;
  private Stage stage;

  public PainOrganizer(Stage stage) {
    this.stage = stage;
    this.root = new BorderPane();
    this.setupCurrencyPane();
  }


  private void setupCurrencyPane() {
    Pane currencyPane = new Pane();
    currencyPane.setStyle(Constants.CURRENCY_PANE_STYLE);
    currencyPane.setPrefSize(Constants.CURRENCY_WIDTH,Constants.CURRENCY_HEIGHT);

    Currency[] currencies = new Currency[] {
        new Currency("Characters", 0,0),
        new Currency("Lines",0,0),
        new Currency("Methods",0,0),
        new Currency("Classes",0,0)
    };

    CurrencyLabel[] labels = new CurrencyLabel[]{
        new CurrencyLabel(currencyPane, currencies[0]),
        new CurrencyLabel(currencyPane, currencies[1]),
        new CurrencyLabel(currencyPane, currencies[2]),
        new CurrencyLabel(currencyPane, currencies[3])
    };

    for (int i = 0; i < labels.length; i++) {
      currencies[i].setLabel(labels[i]);
    }

    this.setupGamePane(currencies);
    this.root.setLeft(currencyPane);
  }
  private void setupGamePane(Currency[] currencies) {
    Pane projectPane = new Pane();
    projectPane.setStyle(Constants.PROJECT_PANE_STYLE);
    projectPane.setPrefSize(Constants.PROEJCT_PANE_WIDTH,Constants.PROEJCT_PANE_HEIGHT);


    Pane gamePane = new Pane();
    gamePane.setStyle(Constants.GAME_PANE_STYLE);
    gamePane.setPrefSize(Constants.GAME_WIDTH,Constants.GAME_HEIGHT);

    Pane particles = new Pane();
    gamePane.getChildren().add(particles);






    Pane upgradePane = new Pane();
    upgradePane.setPrefSize(Constants.UPGRADE_PANE_WIDTH, Constants.UPGRADE_PANE_HEIGHT);
    upgradePane.setStyle(Constants.UPGRADE_PANE_STYLE);

    new Game(currencies, gamePane, particles, upgradePane, projectPane);
    this.root.setCenter(gamePane);
    this.root.setRight(projectPane);
    this.root.setBottom(upgradePane);



  }

  public BorderPane getRoot() {
    return this.root;
  }
}
