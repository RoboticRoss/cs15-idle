package idle;

public class Project {
  private ProjectType type;
  private int projectCount;
  private int typeIndex;
  private int projectPower;
  private double projectPrice;

  public Project(ProjectType type) {
    this.type = type;
    this.typeIndex = type.ordinal();
    this.projectPrice = this.computePrice();
    this.projectPower = 1;
  }

  public String upgradeFilename() {
    return this.type.toString().toLowerCase();
  }
  public boolean hasTowers(int count) {
    return this.projectCount >= count;
  }

  public void addTower() {
    this.projectCount++;
    this.projectPrice = this.computePrice();
  }

  public void purchaseUpgrade(int tier) {
    this.projectPower *=  Constants.UPGRADE_VALS[this.typeIndex][tier][2];
  }

  public int computePrice() {
    return Constants.BASE_PROJECT_PRICES[this.type.ordinal()] * (this.projectCount+1);
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
