package idle.upgrades;

import idle.Wallet;
import java.util.ArrayList;
import javafx.scene.layout.Pane;

public class UpgradePanel {
  private ArrayList<Upgrade> upgrades;
  private UpgradeBox[] upgradeBoxes;
  private Pane upgradePane;
  private Wallet wallet;

  public UpgradePanel() {
    this.upgradeBoxes = new UpgradeBox[4];
  }


  public void updateUpgrades() {

  }
}
