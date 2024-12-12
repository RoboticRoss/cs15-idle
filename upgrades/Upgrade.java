package idle.upgrades;

import idle.CurrencyType;
import idle.Price;

public abstract class Upgrade {

  private UpgradeEffect upgradeEffect;
  private final String imagePath;
  private final String name, flavorTxt;
  private final Price price;


  public Upgrade(CurrencyType currencyType, int price, String name, String flavorTxt, String imageName){
    this.price = new Price(currencyType, price);
    this.upgradeEffect = () -> System.out.println("PROBLEM");
    this.flavorTxt = flavorTxt;
    this.name = name;
    this.imagePath = "idle/images/upgrades/"+imageName+ ".png";
  }

  public void setUpgradeEffect(UpgradeEffect effect) {
    this.upgradeEffect = effect;
  }


  public abstract boolean isUnlocked();
  public void apply() {
    this.upgradeEffect.apply();
  }

  public String getImagePath() {
    return this.imagePath;
  }

  public Price getPrice() {
    return this.price;
  }

  public String getName() {
    return this.name;
  }

  public String getFlavorTxt() {
    return this.flavorTxt;
  }
}
