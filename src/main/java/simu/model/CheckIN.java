package simu.model;

import eduni.distributions.ContinuousGenerator;
import simu.framework.Tapahtumalista;

public class CheckIN extends Palvelupiste {
    private static int counters = 0;
    private static int customers = 0;
    public CheckIN(ContinuousGenerator generator, Tapahtumalista tapahtumalista, TapahtumanTyyppi tyyppi, int x, int y) {
        super(generator, tapahtumalista, tyyppi, x, y);
        counters++;
    }

    public int CustomersServed() {
        return customers;
    }

    @Override
    public void aloitaPalvelu() {
        System.out.println("Check-IN: ");
        super.aloitaPalvelu();
    }
}
