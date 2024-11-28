package idle;

import idle.currency.Currency;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class CurrencyLabel {
  private Currency currency;
  private Label valueLabel;
  private Label nameLabel;
  private Label incomeLabel;
  private final String name;
  private static int numLabels = 0;

  public CurrencyLabel(Pane parent, Currency currency) {
    this.currency = currency;
    this.name = currency.getName();
    this.setupLabels();
    parent.getChildren().addAll(this.valueLabel, this.incomeLabel, this.nameLabel);
  }

  private void setupLabels(){
    this.valueLabel = new Label();
    this.incomeLabel = new Label();
    this.nameLabel = new Label(this.currency.getName());
    this.setPos(Constants.LABEL_X, Constants.LABEL_Y + numLabels*Constants.LABEL_PADDING);
    this.valueLabel.setFont(Constants.VALUE_TEXT);
    this.nameLabel.setFont(Constants.NAME_TEXT);
    this.incomeLabel.setFont(Constants.INCOME_TEXT);
    this.updateLabel();
    numLabels++;
  }


  private void setPos(double x, double y) {
    this.valueLabel.setTranslateX(x);
    this.valueLabel.setTranslateY(y);
    this.nameLabel.setTranslateX(x);
    this.nameLabel.setTranslateY(y+Constants.LABEL_NAME_SPACING);
    this.incomeLabel.setTranslateX(x);
    this.incomeLabel.setTranslateY(y+Constants.LABEL_INCOME_SPACING);
  }

  public void updateLabel() {
    this.valueLabel.setText(String.valueOf(this.currency.getAmount()));
    this.incomeLabel.setText(
        !(this.currency.getIncome()==0)? this.currency.getIncome()+" per second": "");
  }
}
