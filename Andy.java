package idle;


import com.sun.org.apache.bcel.internal.Const;
import idle.Particles.ParticleManager;
import idle.Particles.ParticleType;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Cursor;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Andy {
  private Stats stats;
  private ImageView body;
  private DropShadow dropShadow;

  public Andy(Stats stats, Pane parent, ParticleManager particleManager) {
    this.stats = stats;
    this.body = new ImageView("idle/images/andy_normal.png");
    this.body.setOnMouseClicked(event -> this.handleClick(particleManager));
    this.body.setOnMouseEntered(event -> this.andyHover());
    this.body.setOnMouseExited(event -> this.andyDefault());
    this.body.setCursor(Cursor.HAND);
    this.body.setX(Constants.ANDY_X);
    this.body.setY(Constants.ANDY_Y);

    this.makeDropShadow();
    parent.getChildren().add(this.body);
  }


  private void makeDropShadow() {
    this.dropShadow = new DropShadow();
    this.dropShadow.setOffsetY(3);
    this.dropShadow.setRadius(Constants.SHADOW_RADIUS);
    this.dropShadow.setColor(Constants.ANDY_SHADOW);
    this.body.setEffect(this.dropShadow);
  }

  private void handleClick(ParticleManager particleManager) {
    particleManager.spawnParticle(ParticleType.ANDY);
    this.stats.clickAndy();
    KeyFrame start = new KeyFrame(Duration.seconds(0.01),
        event -> this.body.setImage(new Image("idle/images/andy_click.png")),
        new KeyValue(this.dropShadow.colorProperty(), Constants.ANDY_CLICK),
        new KeyValue(this.body.scaleXProperty(), 1.0),
        new KeyValue(this.body.scaleYProperty(), 1.0));
    ;

    KeyFrame end = new KeyFrame(Duration.seconds(0.1),
        event -> this.body.setImage(new Image("idle/images/andy_hover.png")),
        new KeyValue(this.dropShadow.colorProperty(),Constants.ANDY_GLOW),
        new KeyValue(this.body.scaleXProperty(), 1.1),
        new KeyValue(this.body.scaleYProperty(), 1.1));

    Timeline timeline = new Timeline(start,end);

    timeline.play();
  }

  private void andyHover() {

    this.body.setImage(new Image("idle/images/andy_hover.png"));

    KeyFrame start = new KeyFrame(Duration.seconds(0.01),
        new KeyValue(this.dropShadow.colorProperty(), Constants.ANDY_SHADOW),
        new KeyValue(this.dropShadow.radiusProperty(), Constants.SHADOW_RADIUS),
        new KeyValue(this.body.scaleXProperty(), 1.0),
        new KeyValue(this.body.scaleYProperty(), 1.0));

    KeyFrame end = new KeyFrame(Duration.seconds(0.05),

        new KeyValue(this.dropShadow.colorProperty(),Constants.ANDY_GLOW),
        new KeyValue(this.dropShadow.radiusProperty(), Constants.GLOW_RADIUS),
        new KeyValue(this.body.scaleXProperty(), 1.1),
        new KeyValue(this.body.scaleYProperty(), 1.1));

    Timeline timeline = new Timeline(start,end);

    timeline.play();
  }

  private void andyDefault() {

    this.body.setImage(new Image("idle/images/andy_normal.png"));


    KeyFrame start = new KeyFrame(Duration.seconds(0.06),
        new KeyValue(this.dropShadow.colorProperty(), Constants.ANDY_SHADOW),
        new KeyValue(this.dropShadow.radiusProperty(), Constants.SHADOW_RADIUS),
        new KeyValue(this.body.scaleXProperty(), 1.0),
        new KeyValue(this.body.scaleYProperty(), 1.0));

    KeyFrame end = new KeyFrame(Duration.seconds(0.01),
        new KeyValue(this.dropShadow.colorProperty(),Constants.ANDY_GLOW),
        new KeyValue(this.dropShadow.radiusProperty(), Constants.GLOW_RADIUS),
        new KeyValue(this.body.scaleXProperty(), 1.1),
        new KeyValue(this.body.scaleYProperty(), 1.1));
    Timeline timeline = new Timeline(start,end);

    timeline.play();

  }

}
