package simu.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import simu.framework.Kello;
import simu.framework.Trace;
import view.Kontrolleri;
import view.Visualisointi;

import java.util.Random;


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

	public boolean international;

	public Asiakas() {
		id = i++;
		saapumisaika = Kello.getInstance().getAika();
		Trace.out(Trace.Level.INFO, "Uusi asiakas:" + id + ":" + saapumisaika);
		international = true;
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

	public double raportti() {
		Trace.out(Trace.Level.INFO, "Asiakas " + id + " saapui:" + saapumisaika);
		Trace.out(Trace.Level.INFO, "Asiakas " + id + " poistui:" + poistumisaika);
		Trace.out(Trace.Level.INFO, "Asiakas " + id + " viipyi:" + (poistumisaika - saapumisaika));
		sum += (poistumisaika - saapumisaika);
		double keskiarvo = sum / id;
		System.out.println("Asiakkaiden läpimenoaikojen keskiarvo " + keskiarvo);
		return keskiarvo;
	}

	public void draw(GraphicsContext gc, int x, int y) {
		if (international) {
			gc.setFill(Color.GREEN);
		} else {
			gc.setFill(Color.RED);
		}
		gc.fillOval(x, y, 10, 10);


	}

	public void removeDraw(GraphicsContext gc, int x, int y) {
		gc.setFill(Color.TRANSPARENT);
		gc.fillOval(x, y, 1, 1);
		gc.setFill(Color.TRANSPARENT);
	}
}