package simu.model;

import eduni.distributions.ContinuousGenerator;
import simu.framework.Tapahtumalista;

public class PassportControl extends Palvelupiste {
    private static int counters = 0;
    public PassportControl(ContinuousGenerator generator, Tapahtumalista tapahtumalista, TapahtumanTyyppi tyyppi, int x, int y) {
        super(generator, tapahtumalista, tyyppi, x, y);
        counters++;
    }

    @Override
    public void aloitaPalvelu() {
        System.out.println("Passport Control: ");
        super.aloitaPalvelu();
    }

    public void passportCheck(){
        
    }
}
