package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import simu.model.Asiakas;
import simu.model.Palvelupiste;

public class Visualisointi implements IVisualisointi{
	Kontrolleri kontrolleri;

	private final Canvas canvas;
	private final GraphicsContext gc;
	
	double i = 0;
	double j = 10;
	
	
	public Visualisointi(Kontrolleri kontrolleri, Canvas canvas) {
		this.kontrolleri = kontrolleri;
		this.canvas = canvas;
		gc = this.canvas.getGraphicsContext2D();
		//tyhjennaNaytto();
	}

	public GraphicsContext getGc() {
		return gc;
	}


	public void tyhjennaNaytto() {
		gc.setFill(Color.YELLOW);
		//gc.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

	public void uusiAsiakas() {
		int index = 1; // Initialize the index counter
		int x = 0;
		int y = 0;
		for (Palvelupiste p : kontrolleri.getPalvelupisteet()) {
			for (Asiakas asiakas : p.getJononAsiakkaat()) {
				asiakas.draw(gc, p.getX() + x, p.getY() + y);
				x+= 5;
				y+= 5;
			}
		}
	}
	
}
