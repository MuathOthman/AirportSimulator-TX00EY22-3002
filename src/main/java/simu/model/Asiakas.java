package simu.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import simu.framework.Kello;
import simu.framework.Trace;
import view.Kontrolleri;
import view.Visualisointi;


// TODO:
// Asiakas koodataan simulointimallin edellyttämällä tavalla (data!)
public class Asiakas {
	private static int index = 1;
	private Palvelupiste p;
	private Kontrolleri kontrolleri = new Kontrolleri();
	private Visualisointi gc;
	private double saapumisaika;
	private double poistumisaika;
	private int id;
	private static int i = 1;
	private static long sum = 0;
	public boolean passport = true;

	public boolean international = true;

	public Asiakas() {
		id = i++;
		saapumisaika = Kello.getInstance().getAika();
		Trace.out(Trace.Level.INFO, "Uusi asiakas:" + id + ":" + saapumisaika);
	}

	public boolean isPassport() {
		return passport;
	}

	public boolean isInternational() {
		return international;
	}

	public static int getCount() {
		return i;
	}

	public int getId() {
		return id;
	}

	public double getPoistumisaika() {
		return poistumisaika;
	}

	public void setPoistumisaika(double poistumisaika) {
		this.poistumisaika = poistumisaika;
	}

	public double getSaapumisaika() {
		return saapumisaika;
	}

	public void setSaapumisaika(double saapumisaika) {
		this.saapumisaika = saapumisaika;
	}

	public void raportti() {
		Trace.out(Trace.Level.INFO, "Asiakas " + id + " saapui:" + saapumisaika);
		Trace.out(Trace.Level.INFO, "Asiakas " + id + " poistui:" + poistumisaika);
		Trace.out(Trace.Level.INFO, "Asiakas " + id + " viipyi:" + (poistumisaika - saapumisaika));
		sum += (poistumisaika - saapumisaika);
		double keskiarvo = sum / id;
		System.out.println("Asiakkaiden läpimenoaikojen keskiarvo " + keskiarvo);
	}

	public void draw(GraphicsContext gc, int x, int y) {
		gc.setFill(Color.GREEN);
		gc.fillOval(x, y, 10, 10);

		gc.setFill(Color.BLACK);
		gc.fillText(String.valueOf(id), x + 2, y + 6);

	}
}