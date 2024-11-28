package idle.upgrades;


import idle.Constants;
import idle.Wallet;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class UpgradeBox {
  private Pane parent;
  private ImageView upgradeBox;
  private Rectangle lock;
  private ImageView toolTipbox;
  private Upgrade upgrade;
  private Wallet wallet;
  private Text nameLabel, flavorLabel, priceLabel, buyLabel;


  public UpgradeBox(Pane parent, Upgrade upgrade, Wallet wallet){
    this.parent = parent;
    this.upgrade = upgrade;
    this.wallet = wallet;
    try {
      this.upgradeBox = new ImageView(upgrade.getImagePath());
    } catch (Exception e) {
      this.upgradeBox = new ImageView("idle/images/upgrades/error.png");
    }
    this.setupBox();
  }




  private void setupBox() {
    this.lock = new Rectangle(96, 96);
    // Add hover effects
    this.lock.setOnMouseEntered(this::showTooltip);
    this.lock.setOnMouseMoved(this::moveTooltip);
    this.lock.setOnMouseExited(event -> this.hideTooltip());
    this.lock.setOnMouseClicked(event -> this.purchaseUpgrade());

    this.upgradeBox.setX(Constants.UPGRADE_BOX_X);
    this.lock.setX(Constants.UPGRADE_BOX_X);

    this.upgradeBox.setY(Constants.UPGRADE_BOX_Y);
    this.lock.setY(Constants.UPGRADE_BOX_Y);

    this.lock.setFill(Color.WHITE);

    this.nameLabel = new Text(this.upgrade.getName());
    this.flavorLabel = new Text(this.upgrade.getFlavorTxt());
    this.priceLabel = new Text("COST: "+ this.upgrade.getPrice() + " " + this.upgrade.getCurrencyType());
    this.buyLabel = new Text("(CLICK TO BUY)");
    this.buyLabel.setFill(Color.GREEN);

    this.nameLabel.setFont(Constants.TOOLTIP_TITLE);
    this.flavorLabel.setFont(Constants.TOOLTIP_TEXT);
    this.priceLabel.setFont(Constants.TOOLTIP_COST);
    this.buyLabel.setFont(Constants.TOOLTIP_BUY);
    this.flavorLabel.setWrappingWidth(200);
    this.toolTipbox = new ImageView("idle/images/tooltip_locked.png");

    this.showBox(false);

    this.parent.getChildren().addAll(
        this.upgradeBox, this.lock, this.toolTipbox,
        this.nameLabel, this.flavorLabel, this.priceLabel, this.buyLabel);
  }

  private void showTooltip(MouseEvent mouseEvent) {
    this.setTooltipPos(
        mouseEvent.getSceneX(),
        mouseEvent.getSceneY() - this.parent.getLayoutY()
    );
    this.showBox(true);
  }

  private void moveTooltip(MouseEvent mouseEvent) {
    this.setTooltipPos(
        mouseEvent.getSceneX(),
        mouseEvent.getSceneY() - this.parent.getLayoutY()
    );
  }

  private void hideTooltip() {
    this.showBox(false);
  }
  private void showBox(boolean visibility) {
    this.nameLabel.setVisible(visibility);
    this.flavorLabel.setVisible(visibility);
    this.priceLabel.setVisible(visibility);
    this.buyLabel.setVisible(visibility);
    this.toolTipbox.setVisible(visibility);
  }

  private void setTooltipPos(double x, double y) {
    y-=160;
    x-=270;

    this.nameLabel.setX(x + Constants.TOOLTIP_TEXT_X);
    this.nameLabel.setY(y+ Constants.TOOLTIP_TEXT_Y);

    this.flavorLabel.setX(x + Constants.TOOLTIP_TEXT_X);
    this.flavorLabel.setY(y+ Constants.TOOLTIP_TEXT_Y+25);

    this.priceLabel.setX(x + Constants.TOOLTIP_TEXT_X);
    this.priceLabel.setY(y+ Constants.TOOLTIP_TEXT_Y+65);

    this.buyLabel.setX(x + Constants.TOOLTIP_TEXT_X);
    this.buyLabel.setY(y+ Constants.TOOLTIP_TEXT_Y+78);

    this.toolTipbox.setX(x);
    this.toolTipbox.setY(y);
  }

  public void update() {
   if(this.wallet.canAfford(this.upgrade)) {
     this.lock.setOpacity(0);
     this.toolTipbox.setImage(new Image("idle/images/tooltip_locked.png"));
     this.nameLabel.setFill(Color.BLACK);
     this.flavorLabel.setFill(Color.BLACK);
     this.priceLabel.setFill(Color.BLACK);
     this.buyLabel.setOpacity(1.0);

   } else {
     this.lock.setOpacity(0.7);
     this.priceLabel.setFill(Color.CRIMSON);
     this.nameLabel.setFill(Color.GRAY);
     this.flavorLabel.setFill(Color.GRAY);
     this.buyLabel.setOpacity(0);
     this.toolTipbox.setImage(new Image("idle/images/tooltip.png"));
   }
  }

  private void purchaseUpgrade() {

    if(this.wallet.makePurchase(this.upgrade)) {
      this.kill();
    }
  }

  private void kill() {
    this.parent.getChildren().removeAll(
        this.upgradeBox,this.lock,this.priceLabel, this.buyLabel,
        this.nameLabel, this.flavorLabel
    );
  }

}
