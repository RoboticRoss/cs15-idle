package idle;

import idle.Particles.AndyParticle;
import idle.Particles.ParticleManager;
import idle.Particles.ParticleType;
import idle.upgrades.ProjectUpgrade;
import idle.upgrades.Upgrade;
import idle.upgrades.UpgradeBox;
import indy.UpgradePanel;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Game {
  private Wallet wallet;
  private Andy andy;
  private Pane gamePane, particlePane, upgradePane;
  private ParticleManager particleManager;
  private UpgradePanel upgradePanel;


  private UpgradeBox box; //DELETE ME


  public Game(Wallet wallet, Pane gamePane, Pane particlePane, Pane upgradePane) {
    this.wallet = wallet;
    this.particleManager = new ParticleManager(particlePane);

    this.andy = new Andy(wallet, gamePane, this.particleManager);
    this.particlePane = particlePane;
    this.gamePane = gamePane;
    this.setTimeline();

    Project project = new Project(ProjectType.ANDYBOT);
    Upgrade upgrade = new ProjectUpgrade(project, 0);
    Upgrade upgrade2 = new ProjectUpgrade(project, 1);
    Upgrade upgradebad = new ProjectUpgrade(project, 1);
    this.box = new UpgradeBox(upgradePane, upgrade2, this.wallet);

//    Upgrade upgrade = new Upgrade(CurrencyType.CHARACTERS, 100,
//        "Bigger Kitchen", "Doubles the efficiency of Rattytouille",
//        () -> {
//      this.wallet.addIncome(CurrencyType.METHODS, 1);
//          for (int i = 0; i < 100; i++) {
//            this.particleManager.spawnParticle(ParticleType.ANDY);
//          }
//    });
//
//    this.box = new UpgradeBox(upgradePane, upgrade, this.wallet);
  }
  private void setTimeline() {
    KeyFrame kf = new KeyFrame(Duration.millis(Constants.DURATION),
        (ActionEvent e) -> this.update());
    Timeline timeline = new Timeline(kf);
    timeline.setCycleCount(Animation.INDEFINITE);
    timeline.play();
  }

  private void update() {
    this.particleManager.update();
    this.wallet.update();
    this.box.update();
  }





  private void initializeUpgrades() {

  }

}
