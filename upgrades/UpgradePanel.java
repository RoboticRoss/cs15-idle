package idle.upgrades;

import idle.Wallet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javafx.scene.layout.Pane;

public class UpgradePanel {
  private ArrayList<Upgrade> lockedUpgrades, unlockedUpgrades;
  private final ArrayList<UpgradeBox> upgradeBoxes;
  private final Pane upgradePane;
  private final Wallet wallet;

  public UpgradePanel(Pane upgradePane, ArrayList<Upgrade> allUpgrades, Wallet wallet) {
    this.lockedUpgrades = allUpgrades;
    this.unlockedUpgrades = new ArrayList<>();
    this.upgradePane = upgradePane;
    this.wallet = wallet;
    this.upgradeBoxes = new ArrayList<>();
  }


  private void displayUpgrade(Upgrade upgrade) {
    this.upgradeBoxes.add(0, new UpgradeBox(
        this.upgradePane, upgrade, this.wallet));
    this.alignBoxes();
  }

  public void update() {
    this.checkUpgradeBoxes();
    this.unlockUpgrades();
    for (UpgradeBox box: this.upgradeBoxes){
      box.update();
    }
  }

  private void updatePanel() {
    ArrayList<Upgrade> toRemove = new ArrayList<>();

    for (Upgrade upgrade: this.unlockedUpgrades) {

      if(this.upgradeBoxes.size() >=4) break;

      this.displayUpgrade(upgrade);
      toRemove.add(upgrade);
    }

    this.unlockedUpgrades.removeAll(toRemove);

  }

  private void alignBoxes() {
    for (int i = 0; i < this.upgradeBoxes.size(); i++) {
      this.upgradeBoxes.get(i).setX(i);
    }
  }
  private void unlockUpgrades() {
    List<Upgrade> unlocked = this.lockedUpgrades.stream()
        .filter(Upgrade::isUnlocked).collect(Collectors.toList());
    if(!unlocked.isEmpty()) {
      this.lockedUpgrades.removeAll(unlocked);
      this.unlockedUpgrades.addAll(unlocked);
      this.updatePanel();
      this.alignBoxes();
    }
  }
  private void checkUpgradeBoxes() {
    for (int i = 0; i < this.upgradeBoxes.size(); i++) {
      UpgradeBox box = this.upgradeBoxes.get(i);
      if(box != null) {
        if (box.hasPurchased()) {
          this.upgradeBoxes.remove(i);
          this.updatePanel();
          this.alignBoxes();
          return;
        }
      }
    }
  }
}
