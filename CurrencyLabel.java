package idle;

import idle.currency.Currency;
import java.text.DecimalFormat;
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
    this.valueLabel.setText(formatDouble(this.currency.getAmount(), false));
    this.incomeLabel.setText(
        !(this.currency.getIncome()==0)?
            formatDouble(this.currency.getIncome(), true)+" per second": "");
  }

  public static String formatDouble(double value, boolean precise) {
    String pattern; // Define the pattern dynamically
    double divisor;
    String suffix;

    if (value >= 1_000_000) { // Millions
      divisor = 1_000_000;
      suffix = "M";
    } else if (value >= 1_000) { // Thousands
      divisor = 1_000;
      suffix = "K";
    } else { // Small numbers
      divisor = 1;
      suffix = "";
    }

    // Choose pattern dynamically based on value magnitude
    if (value / divisor >= 100) { // 100 and above -> XXX
      pattern = "#,##0";
    } else if (value / divisor >= 10) { // 10 to 99.9 -> XX.X
      pattern = "#,##0.0";
    } else { // 0 to 9.99 -> X.XX
      pattern = "#,##0.00";
    }
    if(divisor == 1 && !precise) pattern = "#,##0";

    DecimalFormat decimalFormat = new DecimalFormat(pattern);
    return decimalFormat.format(value / divisor) + suffix;
    }

}
