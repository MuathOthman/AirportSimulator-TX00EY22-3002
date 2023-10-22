package simu.model;

import controller.IKontrolleriForM;
import eduni.distributions.Negexp;
import eduni.distributions.Normal;
import entity.simulaatio;
import simu.framework.Kello;
import simu.framework.Moottori;
import simu.framework.Saapumisprosessi;
import simu.framework.Tapahtuma;
import dao.*;
import entity.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class OmaMoottori extends Moottori{

	private Saapumisprosessi saapumisprosessi;

	private SimuDao SimuDao;

	private simulaatio simulaatio;

	private AsiakasDao AsiakasDao;

	private Palvelupiste[] palvelupisteet;

	private int[] settings = {0,0,0}; //nämä määräävät kuinka monta check-iniä/turvatarkastusta/passitarkastusta on käytössä


	public OmaMoottori(IKontrolleriForM kontrolleri){

		super(kontrolleri);

		palvelupisteet = new Palvelupiste[18];

		palvelupisteet[0]=new CheckIN(new Normal(10,6), tapahtumalista, TapahtumanTyyppi.CI1, 308, 524);
		palvelupisteet[1]=new CheckIN(new Normal(10,6), tapahtumalista, TapahtumanTyyppi.CI2, 324, 517);
		palvelupisteet[2]=new CheckIN(new Normal(10,6), tapahtumalista, TapahtumanTyyppi.CI3, 342, 505);
		palvelupisteet[3]=new CheckIN(new Normal(10,6), tapahtumalista, TapahtumanTyyppi.CI4, 387, 481);
		palvelupisteet[4]=new CheckIN(new Normal(10,6), tapahtumalista, TapahtumanTyyppi.CI5, 387 , 481);

		palvelupisteet[5]=new SecurityCheck(new Normal(10,6), tapahtumalista, TapahtumanTyyppi.SEC1, 321, 392);
		palvelupisteet[6]=new SecurityCheck(new Normal(10,6), tapahtumalista, TapahtumanTyyppi.SEC2, 265, 423);
		palvelupisteet[7]=new SecurityCheck(new Normal(10,6), tapahtumalista, TapahtumanTyyppi.SEC3, 328, 430);
		palvelupisteet[8]=new SecurityCheck(new Normal(10,6), tapahtumalista, TapahtumanTyyppi.SEC4, 270, 457);
		palvelupisteet[9]=new SecurityCheck(new Normal(10,6), tapahtumalista, TapahtumanTyyppi.SEC5, 208, 454);

		palvelupisteet[10]=new PassportControl(new Normal(10,6), tapahtumalista, TapahtumanTyyppi.PAS1, 263, 360);
		palvelupisteet[11]=new PassportControl(new Normal(10,6), tapahtumalista, TapahtumanTyyppi.PAS2, 234, 373);
		palvelupisteet[12]=new PassportControl(new Normal(10,6), tapahtumalista, TapahtumanTyyppi.PAS3, 201, 389);
		palvelupisteet[13]=new PassportControl(new Normal(10,6), tapahtumalista, TapahtumanTyyppi.PAS4, 166, 404);
		palvelupisteet[14]=new PassportControl(new Normal(10,6), tapahtumalista, TapahtumanTyyppi.PAS5, 134, 422);

		palvelupisteet[15]=new DutyFree(new Normal(10,6), tapahtumalista, TapahtumanTyyppi.DUT1, 321, 250);

		palvelupisteet[16]=new International(new Normal(10,6), tapahtumalista, TapahtumanTyyppi.DEP2, 257, 157);
		palvelupisteet[17]=new Domestic(new Normal(10,6), tapahtumalista, TapahtumanTyyppi.DEP1, 51, 359);



		saapumisprosessi = new Saapumisprosessi(new Negexp(15,5), tapahtumalista, TapahtumanTyyppi.ARR1);

	}

	public void setSettings(int[] settings) {
		this.settings = settings;
	}

	public int[] getSettings() {
		return settings;
	}


	@Override
	protected void alustukset() {
		saapumisprosessi.generoiSeuraava(); // Ensimmäinen saapuminen järjestelmään
		SimuDao = new SimuDao();
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String strDate = dateFormat.format(date);
		simulaatio = new simulaatio(settings, strDate);
		SimuDao.persist(simulaatio);
		AsiakasDao = new AsiakasDao();
	}

	@Override
	protected void suoritaTapahtuma(Tapahtuma t) {  // B-vaiheen tapahtumat

		Asiakas a;
		AsiakasE e;
		boolean jonocheck;
		int j;
		switch ((TapahtumanTyyppi) t.getTyyppi()) {

			case ARR1:
				jonocheck = true;
				j=0;
				while (jonocheck) {

					for (int i = 0; i < settings[0]; i++) {
						if (palvelupisteet[i].GetJonoSize() == j) {
							palvelupisteet[i].lisaaJonoon(new Asiakas());
							System.out.println("Asiakas lisätty check iniin nro" + i);
							jonocheck = false;
							break;
						}
					}
					j++;
				}
				saapumisprosessi.generoiSeuraava();
				break;
			case CI1:
				a = (Asiakas) palvelupisteet[0].otaJonosta(); //asiakas siirtyy check-inistä turvatarkastukseen
				jonocheck = true;
				j=0;
				while (jonocheck) {

					for (int i = 5; i < (5+settings[1]); i++) {
						if (palvelupisteet[i].GetJonoSize() == j) {
							palvelupisteet[i].lisaaJonoon(a);
							System.out.println("Asiakas lisätty sec nro" + i);
							jonocheck = false;
							break;
						}
					}
					j++;
				}
				break;
			case CI2:
				a = (Asiakas) palvelupisteet[1].otaJonosta(); //asiakas siirtyy check-inistä turvatarkastukseen
				jonocheck = true;
				j=0;
				while (jonocheck) {

					for (int i = 5; i < (5+settings[1]); i++) {
						if (palvelupisteet[i].GetJonoSize() == j) {
							palvelupisteet[i].lisaaJonoon(a);
							System.out.println("Asiakas lisätty sec nro " + i);
							jonocheck = false;
							break;
						}
					}
					j++;
				}
				break;
			case CI3:
				a = (Asiakas) palvelupisteet[2].otaJonosta(); //asiakas siirtyy check-inistä turvatarkastukseen
				jonocheck = true;
				j=0;
				while (jonocheck) {

					for (int i = 5; i < (5+settings[1]); i++) {
						if (palvelupisteet[i].GetJonoSize() == j) {
							palvelupisteet[i].lisaaJonoon(a);
							System.out.println("Asiakas lisätty sec nro " + i);
							jonocheck = false;
							break;
						}
					}
					j++;
				}
				break;
			case CI4:
				a = (Asiakas) palvelupisteet[3].otaJonosta(); //asiakas siirtyy check-inistä turvatarkastukseen
				jonocheck = true;
				j=0;
				while (jonocheck) {

					for (int i = 5; i < (5+settings[1]); i++) {
						if (palvelupisteet[i].GetJonoSize() == j) {
							palvelupisteet[i].lisaaJonoon(a);
							System.out.println("Asiakas lisätty sec nro " + i);
							jonocheck = false;
							break;
						}
					}
					j++;
				}
				break;
			case CI5:
				a = (Asiakas) palvelupisteet[4].otaJonosta(); //asiakas siirtyy check-inistä turvatarkastukseen
				jonocheck = true;
				j=0;
				while (jonocheck) {

					for (int i = 5; i < (5+settings[1]); i++) {
						if (palvelupisteet[i].GetJonoSize() == j) {
							palvelupisteet[i].lisaaJonoon(a);
							System.out.println("Asiakas lisätty check iniin nro" + i);
							jonocheck = false;
							break;
						}
					}
					j++;
				}
				break;
			case SEC1:
				a = (Asiakas) palvelupisteet[5].otaJonosta();
				if(a.isInternational()) {
					jonocheck = true;
					j=0;
					while (jonocheck) {

						for (int i = 10; i <(10 + settings[2]); i++) {
							if (palvelupisteet[i].GetJonoSize() == j) {
								palvelupisteet[i].lisaaJonoon(a);
								jonocheck = false;
								break;
							}
						}
						j++;
					}} else {
					palvelupisteet[17].lisaaJonoon(a);
				}

				break;
			case SEC2:
				a = (Asiakas) palvelupisteet[6].otaJonosta();
				if(a.isInternational()) {
					jonocheck = true;
					j=0;
					while (jonocheck) {

						for (int i = 10; i <(10 + settings[2]); i++) {
							if (palvelupisteet[i].GetJonoSize() == j) {
								palvelupisteet[i].lisaaJonoon(a);
								jonocheck = false;
								break;
							}
						}
						j++;
					}} else {
					palvelupisteet[17].lisaaJonoon(a);
				}
				break;
			case SEC3:
				a = (Asiakas) palvelupisteet[7].otaJonosta();
				if(a.isInternational()) {
					jonocheck = true;
					j=0;
					while (jonocheck) {

						for (int i = 10; i <(10 + settings[2]); i++) {
							if (palvelupisteet[i].GetJonoSize() == j) {
								palvelupisteet[i].lisaaJonoon(a);
								jonocheck = false;
								break;
							}
						}
						j++;
					}} else {
					palvelupisteet[17].lisaaJonoon(a);
				}
				break;

			case SEC4:
				a = (Asiakas) palvelupisteet[8].otaJonosta();
				if(a.isInternational()) {
					jonocheck = true;
					j=0;
					while (jonocheck) {

						for (int i = 10; i <(10 + settings[2]); i++) {
							if (palvelupisteet[i].GetJonoSize() == j) {
								palvelupisteet[i].lisaaJonoon(a);
								jonocheck = false;
								break;
							}
						}
						j++;
					}} else {
					palvelupisteet[17].lisaaJonoon(a);
				}
				break;
			case SEC5:
				a = (Asiakas) palvelupisteet[9].otaJonosta();
				if(a.isInternational()) {
					jonocheck = true;
					j=0;
					while (jonocheck) {

						for (int i = 10; i <(10 + settings[2]); i++) {
							if (palvelupisteet[i].GetJonoSize() == j) {
								palvelupisteet[i].lisaaJonoon(a);
								jonocheck = false;
								break;
							}
						}
						j++;
					}} else {
					palvelupisteet[17].lisaaJonoon(a);
				}
				break;
			case PAS1:
				a = (Asiakas) palvelupisteet[10].otaJonosta();
				palvelupisteet[15].lisaaJonoon(a);
				break;
			case PAS2:
				a = (Asiakas) palvelupisteet[11].otaJonosta();
				palvelupisteet[15].lisaaJonoon(a);
				break;
			case PAS3:
				a = (Asiakas) palvelupisteet[12].otaJonosta();
				palvelupisteet[15].lisaaJonoon(a);
				break;
			case PAS4:
				a = (Asiakas) palvelupisteet[13].otaJonosta();
				palvelupisteet[15].lisaaJonoon(a);
				break;
			case PAS5:
				a = (Asiakas) palvelupisteet[14].otaJonosta();
				palvelupisteet[15].lisaaJonoon(a);
				break;
			case DUT1:
				a = (Asiakas) palvelupisteet[15].otaJonosta();
				palvelupisteet[16].lisaaJonoon(a);
				break;
			case DEP1:
				a = (Asiakas) palvelupisteet[17].otaJonosta(); //asiakas poistetaan järjestelmästä
				a.setPoistumisaika(Kello.getInstance().getAika());
				e = new AsiakasE(a, this.simulaatio.getId());
				AsiakasDao.persist(e);
				a.raportti();
			case DEP2:
				a = (Asiakas) palvelupisteet[16].otaJonosta(); //asiakas poistetaan järjestelmästä
				a.setPoistumisaika(Kello.getInstance().getAika());
				e = new AsiakasE(a, this.simulaatio.getId());
				AsiakasDao.persist(e);
				simulaatio.setAv_time(a.raportti());
				simulaatio.setCustomers(Asiakas.getCount());
				simulaatio.setTime(Kello.getInstance().getAika());
				SimuDao.update(simulaatio);
				a.raportti();

		}
	}

	@Override
	protected void yritaCTapahtumat(){
		for (Palvelupiste p: palvelupisteet){
			if (!p.onVarattu() && p.onJonossa()){
				p.aloitaPalvelu();
			}
		}
	}

	public Palvelupiste[] getPalvelupisteet() {
		return palvelupisteet;
	}

	@Override
	protected void tulokset() {
		System.out.println("Simulointi päättyi kello " + Kello.getInstance().getAika());
		System.out.println("Tulokset ... puuttuvat vielä");
		System.out.println("Asiakkaita saapui " + Asiakas.getCount());

		// UUTTA graafista
		kontrolleri.naytaLoppuaika(Kello.getInstance().getAika());
	}
}