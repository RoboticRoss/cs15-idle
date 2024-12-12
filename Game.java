package idle;

import idle.Particles.ParticleManager;
import idle.currency.Currency;
import idle.projects.Project;
import idle.projects.ProjectBox;
import idle.projects.ProjectType;
import idle.upgrades.ProjectUpgrade;
import idle.upgrades.Upgrade;
import idle.upgrades.UpgradeBox;
import idle.upgrades.UpgradePanel;
import java.util.ArrayList;
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
  private ArrayList<ProjectBox> projectBoxes;


  private UpgradeBox box; //DELETE ME


  public Game(Currency[] currencies, Pane gamePane, Pane particlePane, Pane upgradePane, Pane projectPane) {
    
    this.projectBoxes = new ArrayList<>();
    
    ArrayList<Project> projects = new ArrayList<>();
    Project project = new Project(ProjectType.RATTYTOUILLE);
    projects.add(project);

    this.wallet = new Wallet(currencies, projects);
    this.particleManager = new ParticleManager(particlePane);

    this.andy = new Andy(this.wallet, gamePane, this.particleManager);
    this.particlePane = particlePane;
    this.gamePane = gamePane;
    this.setTimeline();

    Upgrade upgrade = new ProjectUpgrade(project, 0);
    Upgrade upgrade2 = new ProjectUpgrade(project, 1);
    Upgrade upgrade3 = new ProjectUpgrade(project, 2);
    //this.box = new UpgradeBox(upgradePane, upgrade2, this.wallet);

    ArrayList<Upgrade> allUpgrades = new ArrayList<>();


    allUpgrades.add(new ProjectUpgrade(project, 0));
    allUpgrades.add(new ProjectUpgrade(project, 1));
    allUpgrades.add(new ProjectUpgrade(project, 2));
    allUpgrades.add(new ProjectUpgrade(project, 3));
    allUpgrades.add(new ProjectUpgrade(project, 4));

    this.projectBoxes.add(new ProjectBox(projectPane,project, this.wallet));
    this.projectBoxes.add(new ProjectBox(projectPane,project, this.wallet));
    this.projectBoxes.add(new ProjectBox(projectPane,project, this.wallet));
    this.projectBoxes.add(new ProjectBox(projectPane,project, this.wallet));


    this.upgradePanel = new UpgradePanel(upgradePane, allUpgrades, this.wallet);

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

  private void setupProjects() {
    Project ratty = new Project(ProjectType.RATTYTOUILLE);
    Project andy = new Project(ProjectType.RATTYTOUILLE);



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
    this.upgradePanel.update();

    for (ProjectBox box :
        this.projectBoxes) {
      box.update();
    }
  }





  private void initializeUpgrades() {

  }

}
