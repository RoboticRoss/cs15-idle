package idle;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Tooltip {
  private Pane parent;
  private Rectangle toolTipbox;
  private Text nameLabel, flavorLabel, priceLabel, buyLabel;

  public Tooltip(Pane parent) {
    this.parent = parent;
    this.setupLabels();
  }

  private void setupLabels() {

    this.toolTipbox = new Rectangle(240,140); //MAKE THIS DYNAMIC
    this.toolTipbox.setStrokeWidth(12);
    this.nameLabel = new Text();
    this.flavorLabel = new Text();
    this.priceLabel = new Text();
    this.buyLabel = new Text("(CLICK TO BUY)");
    this.buyLabel.setFill(Color.GREEN);

    this.nameLabel.setFont(Constants.TOOLTIP_TITLE);
    this.flavorLabel.setFont(Constants.TOOLTIP_TEXT);
    this.priceLabel.setFont(Constants.TOOLTIP_COST);
    this.buyLabel.setFont(Constants.TOOLTIP_BUY);

    this.nameLabel.setFont(Constants.TOOLTIP_TITLE);
    this.flavorLabel.setFont(Constants.TOOLTIP_TEXT);
    this.priceLabel.setFont(Constants.TOOLTIP_COST);
    this.buyLabel.setFont(Constants.TOOLTIP_BUY);
    this.flavorLabel.setWrappingWidth(200);

    this.parent.getChildren().addAll(this.toolTipbox, this.nameLabel,this.priceLabel,
        this.flavorLabel,this.buyLabel);
  }

  public void setName(String name) {
    this.nameLabel.setText(name);
  }

  public void setFlavor(String flavor) {
    this.flavorLabel.setText(flavor);
  }
  public void setPrice(Price price) {
    this.priceLabel.setText("COST: "+ price.toString());
  }

  public void setColors(boolean canBuy) {
    if(canBuy) {
      this.nameLabel.setFill(Color.BLACK);
      this.flavorLabel.setFill(Color.BLACK);
      this.priceLabel.setFill(Color.BLACK);
      this.buyLabel.setOpacity(1.0);

      this.toolTipbox.setFill(Color.LIGHTBLUE);
      this.toolTipbox.setStroke(Color.DARKBLUE);
    } else {
      this.priceLabel.setFill(Color.CRIMSON);
      this.nameLabel.setFill(Color.GRAY);
      this.flavorLabel.setFill(Color.GRAY);
      this.buyLabel.setOpacity(0);

      this.toolTipbox.setFill(Color.LIGHTGRAY);
      this.toolTipbox.setStroke(Color.GRAY);
    }
  }
  public void hide() {
    this.nameLabel.setVisible(false);
    this.flavorLabel.setVisible(false);
    this.priceLabel.setVisible(false);
    this.buyLabel.setVisible(false);
    this.toolTipbox.setVisible(false);
  }

  public void show() {
    this.nameLabel.setVisible(true);
    this.flavorLabel.setVisible(true);
    this.priceLabel.setVisible(true);
    this.buyLabel.setVisible(true);
    this.toolTipbox.setVisible(true);
  }




  public void setTooltipPos(double x, double y) {
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


  public void kill() {
    this.parent.getChildren().removeAll(this.nameLabel,this.priceLabel,
        this.flavorLabel,this.buyLabel,this.toolTipbox);
  }

}
