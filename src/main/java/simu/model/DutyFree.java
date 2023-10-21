package simu.model;

import eduni.distributions.ContinuousGenerator;
import simu.framework.Tapahtumalista;

public class DutyFree extends Palvelupiste {
    private static int cashers = 0;
    public DutyFree(ContinuousGenerator generator, Tapahtumalista tapahtumalista, TapahtumanTyyppi tyyppi, int x, int y) {
        super(generator, tapahtumalista, tyyppi, x, y);
        cashers++;
    }

    @Override
    public void aloitaPalvelu() {
        System.out.println("Duty Free: ");
        super.aloitaPalvelu();
    }
}
