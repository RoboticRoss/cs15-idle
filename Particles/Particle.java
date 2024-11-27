package idle.Particles;

import idle.Constants;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public abstract class Particle {

  private Pane parent;
  private ImageView body;

  public Particle(Pane parent, String imageView) {
    this.parent = parent;
    this.body = new ImageView(imageView);
    this.body.setX(Math.random() * 340);
    this.body.setY(Constants.PARTICLE_Y);
    this.parent.getChildren().add(this.body);
  }


  public abstract void updatePosition();

  public void setOpacity(double opacity) {
    this.body.setOpacity(opacity);
  }

  public void setX(double x) {
    this.body.setX(x);
  }

  public void setY(double y) {
    this.body.setY(y);
  }

  public double getX() {
    return this.body.getX();
  }

  public double getY() {
    return this.body.getY();
  }

  public void move(double x, double y) {
    this.setX(this.getX()+x);
    this.setY(this.getY()+y);
  }

  public boolean readyToRemove() {
    return this.body.getY() > Constants.PARTICLE_DESPAWN_Y;
  }



  public void kill() {
    this.parent.getChildren().remove(this.body);
  }

}
