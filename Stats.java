package idle;

public class Stats {
  private CurrencyLabel[] currencyLabels;

  private int clickPower;
  private double[] currency;
  private double[] income;
  public Stats(CurrencyLabel[] currencyLabels) {
    this.currencyLabels = currencyLabels;
    this.currency = new double[4];
    this.income = new double[4];
    this.income[0] = 1;

    this.clickPower = 1;
  }

  public void update(){
    this.updateIncome();
  }
  private void updateIncome(){
    for (int i = 0; i < this.income.length; i++) {
      this.currency[i] += this.income[i] / Constants.FPS;
      this.currencyLabels[i].updateValue((int)this.currency[i]);
    }
  }

  public void clickAndy() {
    this.currency[0] += this.clickPower;
    this.currencyLabels[0].updateValue((int)this.currency[0]);
  }
}
