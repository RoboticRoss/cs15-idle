package idle;

import idle.currency.Currency;
import idle.projects.Project;
import java.util.ArrayList;

public class Wallet {
  private Currency[] currencies;
  private ArrayList<Project> projects;
  private int clickPower;
  public Wallet(Currency[] currencies, ArrayList<Project> projects) {
    this.currencies = currencies;
    this.projects = projects;
    this.clickPower = 1;
    //this.addIncome(CurrencyType.CHARACTERS, 100000);
    //this.addIncome(CurrencyType.LINES, 1000);
    //this.addIncome(CurrencyType.METHODS, 10);
    //this.addIncome(CurrencyType.CLASSES, 0.1);
  }

  public void update(){
    this.produceIncome();
  }
  private void produceIncome(){
    for (Currency currency : this.currencies) {
      currency.updateAmount();
    }
  }

  public void updateIncome() {
    double[] income = new double[4];

    for (Project project: this.projects) {
      income[project.getIncomeType().ordinal()] += project.computeIncome();
    }

    for (int i = 0; i < this.currencies.length; i++) {
      this.currencies[i].setIncome(income[i]);
    }
  }

  public void clickAndy() {
    this.currencies[0].addAmount(this.clickPower);
  }


  public void addIncome(CurrencyType currencyType, double increase) {
    this.getCurrency(currencyType).addIncome(increase);
  }

  public void setIncome(CurrencyType currencyType, double increase) {
    this.getCurrency(currencyType).addIncome(increase);
  }

  public boolean canAfford(Price price) {
    return this.getCurrency(price.getType()).getAmount() >= price.getAmount();
  }


  public boolean makePurchase(Price price) {
    if(this.canAfford(price)) {
      this.getCurrency(price.getType()).addAmount(-price.getAmount());
      return true;
    }
    return false;
  }

  private Currency getCurrency(CurrencyType currencyType) {
    return this.currencies[currencyType.ordinal()];
  }
}
