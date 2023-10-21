package simu.framework;

import simu.model.Palvelupiste;

public interface IMoottori { // UUSI
		
	// Kontrolleri käyttää tätä rajapintaa
	
	public void setSimulointiaika(double aika);
	public void setViive(long aika);
	public long getViive();

    void setSettings(int[] ints);

	int[] getSettings();

}
