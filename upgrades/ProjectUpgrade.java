package idle.upgrades;

import idle.Constants;
import idle.Project;
import idle.Wallet;

public class ProjectUpgrade extends Upgrade{
  private Project project;
  private int unlockCount;

  public ProjectUpgrade(Project project, int tier) {
    super(
        project.getUpgradeCostType(tier),
        project.getUpgradeCost(tier),
        project.getUpgradeName(tier),
        project.getUpgradeDescription(tier),
        project.upgradeFilename() + tier
    );
    this.project = project;
    this.unlockCount = Constants.UNLOCK_INCREMENTS[tier];

    this.setUpgradeEffect(()->project.purchaseUpgrade(tier));
  }

  @Override
  public boolean unlockUpgrade() {
    return this.project.hasTowers(this.unlockCount);
  }
}
