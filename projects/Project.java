package idle.projects;

import idle.Constants;
import idle.CurrencyType;
import idle.Price;
import javafx.scene.text.Text;

public class Project {
  private final ProjectType projectType;
  private final CurrencyType incomeType;
  private final int typeIndex;
  private int projectCount;
  private int projectPower;
  private Price projectPrice;

  public Project(ProjectType projectType) {
    this.projectType = projectType;
    this.typeIndex = projectType.ordinal();
    this.incomeType = Constants.PROJECT_INCOME_TYPES[this.typeIndex];
    this.projectPrice = this.computePrice();
    this.projectPower = 1;
    this.projectCount = 0;
  }

  public String upgradeFilename() {
    return this.projectType.toString().toLowerCase();
  }
  public String displayName() {
    return this.projectType.displayName();
  }
  public boolean hasTowers(int count) {
    return this.projectCount >= count;
  }

  public void addTower(Text priceLabel) {
    this.projectCount++;
    this.projectPrice = this.computePrice();
    priceLabel.setText(String.valueOf(this.projectPrice));
  }

  public void purchaseUpgrade(int tier) {
    this.projectPower *=  Constants.UPGRADE_VALS[this.typeIndex][tier][2];
  }

  public Price computePrice() {
    return
        new Price( CurrencyType.CHARACTERS,
            Constants.BASE_PROJECT_PRICES[this.projectType.ordinal()] * (this.projectCount+1));
  }


  public CurrencyType getIncomeType() {
    return this.incomeType;
  }

  public double computeIncome() {
    return Constants.BASE_PROJECT_INCOMES[this.typeIndex]*this.projectCount*this.projectPower;
  }

  public String getUpgradeName(int tier) {
    return Constants.upgradeText[this.typeIndex][tier][0];
  }

  public String getUpgradeDescription(int tier) {
    return Constants.upgradeText[this.typeIndex][tier][1];
  }

  public int getUpgradeCost(int tier) {
    return Constants.UPGRADE_VALS[this.typeIndex][tier][1];
  }
  public CurrencyType getUpgradeCostType(int tier) {
    return CurrencyType.class.getEnumConstants()
        [Constants.UPGRADE_VALS[this.typeIndex][tier][0]];
  }
}
