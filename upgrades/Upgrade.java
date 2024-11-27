package idle.upgrades;

import idle.CurrencyType;

public class Upgrade {

  private final CurrencyType currencyType;
  private final UpgradeEffect upgradeEffect;
  private final String name, flavorTxt;
  private final int price;



  public Upgrade(CurrencyType currencyType, int price, String name, String flavorTxt, UpgradeEffect upgradeEffect){
    this.price = price;
    this.currencyType = currencyType;
    this.upgradeEffect = upgradeEffect;
    this.flavorTxt = flavorTxt;
    this.name = name;
  }

  public void apply() {
    this.upgradeEffect.apply();
  }

  public int getPrice() {
    return this.price;
  }

  public CurrencyType getCurrencyType() {
    return this.currencyType;
  }

  public String getName() {
    return this.name;
  }

  public String getFlavorTxt() {
    return this.flavorTxt;
  }
}
