package idle.Particles;

import java.util.ArrayList;
import javafx.scene.layout.Pane;

public class ParticleManager {
  private ArrayList<Particle> particles;
  private Pane parent;

  public ParticleManager(Pane parent) {
    this.parent = parent;
    this.particles = new ArrayList<>();
  }

  public void update() {
    if(!this.particles.isEmpty()) {
      ArrayList<Particle> toRemove = new ArrayList<>();
      for (Particle particle : this.particles) {
        particle.updatePosition();
        if(particle.readyToRemove()) {
          toRemove.add(particle);
          particle.kill();
        }

      }
      this.particles.removeAll(toRemove);
    }
  }

  public void spawnParticle(ParticleType type) {
    Particle particle = null;
    switch (type) {
      default:
        particle = new AndyParticle(this.parent);
    }

    this.particles.add(particle);
  }
}
