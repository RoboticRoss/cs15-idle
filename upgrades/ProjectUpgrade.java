package idle.upgrades;

import idle.Constants;
import idle.projects.Project;

public class ProjectUpgrade extends Upgrade{
  private final Project project;
  private final int unlockCount;

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
  public boolean isUnlocked() {
    return this.project.hasTowers(this.unlockCount);
  }
}
