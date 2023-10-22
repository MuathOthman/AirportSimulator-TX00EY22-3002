package simu.model;

import eduni.distributions.ContinuousGenerator;
import simu.framework.Tapahtumalista;

public class International extends CheckIN {
    public International(ContinuousGenerator generator, Tapahtumalista tapahtumalista, TapahtumanTyyppi tyyppi, int x, int y) {
        super(generator, tapahtumalista, tyyppi, x, y);
    }

    @Override
    public void aloitaPalvelu() {
        super.aloitaPalvelu();
    }
}
