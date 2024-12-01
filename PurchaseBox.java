package idle;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class PurchaseBox {
  private Wallet wallet;
  private Tooltip tooltip;
  private Price price;
  private Pane parent;
  private Rectangle lock;
  private ImageView box;

  public PurchaseBox(Pane parent, Wallet wallet, Price price, double width, double height, String boxPath) {
    this.parent = parent;
    this.tooltip = new Tooltip(parent);
    this.wallet = wallet;
    this.price = price;

    this.lock = new Rectangle(width, height);
    this.lock.setFill(Color.WHITE);
    this.setInteractable(this.lock);
    this.box = new ImageView(boxPath);

    parent.getChildren().addAll(this.box, this.lock);

    this.lock.toBack();
    this.box.toBack();
  }


  public void setPrice(Price price) {
    this.price = price;
  }

  public void initializeTooltip(String name, String flavor, Price price) {
    this.tooltip.setName(name);
    this.tooltip.setFlavor(flavor);
    this.tooltip.setPrice(price);
    this.tooltip.hide();
  }

  public void setInteractable(Node node) {
    node.setOnMouseEntered(this::showTooltip);
    node.setOnMouseMoved(this::moveTooltip);
    node.setOnMouseExited(event -> this.hideTooltip());
    node.setOnMouseClicked(event -> this.purchase());
  }

  public void purchase() {
    if(this.wallet.makePurchase(this.price)) {
      this.wallet.updateIncome();
      this.onPurchase();
    }
  }
  public abstract void onPurchase();
  public abstract void canAfford();
  public abstract void cannotAfford();

  public void update() {
    if(this.wallet.canAfford(this.price)) {
      this.lock.setOpacity(0);
      this.tooltip.setColors(true);
      this.canAfford();
    } else {
      this.lock.setOpacity(0.7);
      this.tooltip.setColors(false);
      this.cannotAfford();
    }
  }

  private void showTooltip(MouseEvent mouseEvent) {
    this.moveTooltip(mouseEvent);
    this.tooltip.show();
  }

  private void moveTooltip(MouseEvent mouseEvent) {
    this.tooltip.setTooltipPos(
        mouseEvent.getSceneX()-260,
        mouseEvent.getSceneY() - this.parent.getLayoutY()-150
    );
  }

  private void hideTooltip() {
    this.tooltip.hide();
  }

  public void kill() {
    this.tooltip.kill();
  }


  public void setX(double x) {
    this.box.setX(x);
    this.lock.setX(x);
  }

  public void setPos(double x, double y) {
    this.box.setX(x);
    this.box.setY(y);

    this.lock.setX(x);
    this.lock.setY(y);
  }
}
