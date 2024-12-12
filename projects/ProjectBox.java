package idle.projects;

import idle.Constants;
import idle.Price;
import idle.PurchaseBox;
import idle.Wallet;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class ProjectBox extends PurchaseBox {
  private Pane projectPane;
  private Price price;
  private Wallet wallet;
  private Project project;
  private Text nameLabel, priceLabel;
  private Rectangle body;
  private static int numBoxes = 0;
  public ProjectBox(Pane projectPane, Project project, Wallet wallet) {
    super(projectPane, wallet, project.computePrice(), Constants.UPGRADE_BOX_WIDTH, Constants.UPGRADE_BOX_HEIGHT, "");
    this.projectPane = projectPane;
    this.project = project;
    this.wallet = wallet;
    this.price = project.computePrice();
    this.setupText();
  }



  private void setupText() {

    this.body = new Rectangle();

    this.initializeTooltip(
        this.project.displayName(),this.project.displayName(), this.price);


    this.body.setFill(Constants.PROECT_BACKGROUND_READY);
    this.body.setStroke(Constants.PROECT_BORDER_READY);

    this.body.setStrokeWidth(10);
    this.nameLabel = new Text(this.project.displayName());
    this.nameLabel.setFont(Constants.PROJECT_NAME);
    this.priceLabel = new Text(this.project.computePrice().toString());
    this.priceLabel.setFont(Constants.PROJECT_COST);

    double y = Constants.PROJECT_BOX_Y + Constants.PROJECT_BOX_PADDING*numBoxes;
    this.setPos(Constants.PROJECT_BOX_X, y);

    this.projectPane.getChildren().addAll(this.nameLabel, this.priceLabel);

    numBoxes++;
  }


  @Override
  public void onPurchase() {
    this.project.addTower(this.priceLabel);
    this.price = this.project.computePrice();
    this.setPrice(this.price);
    this.updateTooltipPrice(this.price);
  }

  @Override
  public void canAfford() {

  }

  @Override
  public void cannotAfford() {

  }


//
//
//  private void setPos(double x, double y) {
//    this.body.setX(x);
//    this.body.setY(y);
//    this.hover.setX(x);
//    this.hover.setY(y);
//    this.nameLabel.setX(x);
//    this.nameLabel.setY(y);
//    this.priceLabel.setX(x);
//    this.priceLabel.setY(y);
//  }
}
