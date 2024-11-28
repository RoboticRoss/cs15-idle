package idle;

import idle.currency.Currency;
import idle.upgrades.Upgrade;

public class Wallet {
  private Currency[] currencies;
  private int[] projectCount;
  private int clickPower;
  public Wallet(Currency[] currencies) {
    this.currencies = currencies;
    this.projectCount = new int[8];
    this.addIncome(CurrencyType.CHARACTERS, 1);

    this.clickPower = 1;
  }

  public void update(){
    this.updateIncome();
  }
  private void updateIncome(){
    for (Currency currency : this.currencies) {
      currency.updateAmount();
    }
  }

  public void clickAndy() {
    this.currencies[0].addAmount(this.clickPower);
  }


  public void addIncome(CurrencyType currencyType, double increase) {
    this.getCurrency(currencyType).addIncome(increase);
  }

  public boolean canAfford(CurrencyType currencyType, int amount) {
    return this.getCurrency(currencyType).getAmount() >= amount;
  }

  public boolean canAfford(Upgrade upgrade) {
    return this.getCurrency(upgrade.getCurrencyType()).getAmount() >= upgrade.getPrice();
  }


  public boolean makePurchase(CurrencyType currencyType, int amount) {
    if(this.canAfford(currencyType,amount)) {
      this.getCurrency(currencyType).addAmount(-amount);
      return true;
    }
    return false;
  }

  public boolean makePurchase(Upgrade upgrade) {
    if(this.canAfford(upgrade)) {
      this.getCurrency(upgrade.getCurrencyType()).addAmount(-upgrade.getPrice());
      upgrade.apply();
      return true;
    }
    return false;
  }

  private Currency getCurrency(CurrencyType currencyType) {
    return this.currencies[currencyType.ordinal()];
  }
}
