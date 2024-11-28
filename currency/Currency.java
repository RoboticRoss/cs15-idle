package idle.currency;

import idle.Constants;
import idle.CurrencyLabel;

public class Currency {
  private CurrencyLabel label;
  private String name;
  private int towerCount;
  private double amount;
  private double income;

  public Currency(String name, double amount, double income) {
    this.name = name;
    this.amount = amount;
    this.income = income;
  }

  public void updateAmount() {
    this.amount += this.income / Constants.FPS;
    this.updateLabel();
  }

  public void setLabel(CurrencyLabel label) {
    this.label = label;
  }

  public void updateLabel() {
    this.label.updateLabel();
  }

  public String getName() {
    return this.name;
  }

  public double getIncome() {
    return this.income;
  }

  public void setIncome(double income) {
    this.income = income;
    this.updateLabel();
  }

  public void addIncome(double increase) {
    this.income += increase;
    this.updateLabel();
  }

  public int getAmount() {
    return (int)this.amount;
  }

  public void addAmount(double amount) {
    this.amount += amount;
    this.updateLabel();
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }
}
