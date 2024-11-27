package idle.upgrades;


import idle.Constants;
import idle.Wallet;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class UpgradeBox {
  private Pane parent;
  private Rectangle upgradeBox;
  private Upgrade upgrade;
  private Wallet wallet;
  private Label nameLabel, flavorLabel;
  private boolean purchaseable;


  public UpgradeBox(Pane parent, Upgrade upgrade, Wallet wallet){
    this.parent = parent;
    this.upgrade = upgrade;
    this.wallet = wallet;
    this.setupBox();
  }


  private void setupBox() {
    this.upgradeBox = new Rectangle(
        Constants.UPGRADE_BOX_WIDTH, Constants.UPGRADE_BOX_HEIGHT);

    this.upgradeBox.setX(Constants.UPGRADE_BOX_X);

    this.nameLabel = new Label(this.upgrade.getName());
    this.flavorLabel = new Label(this.upgrade.getFlavorTxt());

    this.upgradeBox.setOnMouseClicked(event -> this.purchaseUpgrade());
    this.parent.getChildren().addAll(this.upgradeBox, this.nameLabel, this.flavorLabel);
  }


  public void update() {
   if(this.wallet.canAfford(this.upgrade)) {
     this.upgradeBox.setFill(Color.WHITE);
   }
  }

  private void purchaseUpgrade() {
    if(this.wallet.makePurchase(this.upgrade)) {
      this.kill();
    }
  }

  private void kill() {
    this.parent.getChildren().remove(this.upgradeBox);
  }

}
