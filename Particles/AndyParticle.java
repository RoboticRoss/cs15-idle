package idle.Particles;

import idle.Constants;
import javafx.scene.layout.Pane;

public class AndyParticle extends Particle {
  private double velo;
  public AndyParticle(Pane parent) {
    super(parent, Constants.ANDY_PARTICLE);
    this.velo = 0;
  }

  @Override
  public void updatePosition() {
      this.velo += 0.1;
      this.move(0, this.velo);
      this.setOpacity(1-(this.getY()/ Constants.PARTICLE_DESPAWN_Y));
  }
}
