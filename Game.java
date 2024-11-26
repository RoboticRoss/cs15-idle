package idle;

import idle.Particles.AndyParticle;
import idle.Particles.Particle;
import idle.Particles.ParticleManager;
import java.util.ArrayList;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Game {
  private Stats stats;
  private Andy andy;
  private Pane gamePane, particlePane;
  private ParticleManager particleManager;


  public Game(Stats stats, Pane gamePane, Pane particlePane) {
    this.stats = stats;
    this.particleManager = new ParticleManager(particlePane);

    this.andy = new Andy(stats, gamePane, this.particleManager);
    this.particlePane = particlePane;
    this.gamePane = gamePane;
    this.setTimeline();
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
    this.stats.update();
  }

}
