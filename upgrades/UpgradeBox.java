package idle.upgrades;


import idle.Constants;
import idle.PurchaseBox;
import idle.Wallet;
import javafx.scene.layout.Pane;

public class UpgradeBox extends PurchaseBox {
  private final Upgrade upgrade;
  private boolean purchased;


  public UpgradeBox(Pane parent, Upgrade upgrade, Wallet wallet){
    super(parent,wallet, upgrade.getPrice(), 96, 96, upgrade.getImagePath());
    this.upgrade = upgrade;
    this.purchased = false;
    this.setupBox();
  }

  public void setX(int index) {
    super.setX(Constants.UPGRADE_BOX_X - index * Constants.UPGRADE_SIZE);
  }


  private void setupBox() {
    this.setPos(Constants.UPGRADE_BOX_X, Constants.UPGRADE_BOX_Y);
    this.initializeTooltip(
        this.upgrade.getName(),this.upgrade.getFlavorTxt(), this.upgrade.getPrice());
  }

  @Override
  public void onPurchase() {
    this.upgrade.apply();
    this.kill();
    this.purchased = true;
  }

  @Override
  public void canAfford() {

  }

  @Override
  public void cannotAfford() {

  }

  public boolean hasPurchased() {
    return this.purchased;
  }
}
