package view;

import controller.IKontrolleriForM;
import controller.IKontrolleriForV;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import simu.framework.IMoottori;
import simu.framework.Kello;
import simu.framework.Trace;
import simu.model.Asiakas;
import simu.model.OmaMoottori;
import simu.model.Palvelupiste;
import java.awt.*;
import javafx.scene.canvas.Canvas;


public class Kontrolleri implements IKontrolleriForM, IKontrolleriForV {
    private Visualisointi visualisointi;

    private Asiakas asiakas;
    private IMoottori moottori;
    private ISimulaattorinUI ui;
    private IKontrolleriForV kontrolleri;

    @FXML
    private TextField textFieldAika;
    @FXML
    private TextField textFieldViive;
    @FXML
    private Button buttonNopeuta;
    @FXML
    private Button buttonHidasta;
    @FXML
    private Button buttonKaynnista;
    @FXML
    private Button buttonPlus;
    @FXML
    private Button buttonMinus;
    @FXML
    private Button buttonPlusSecurity;
    @FXML
    private Button buttonMinusSecurity;
    @FXML
    private Button buttonPlusPassport;
    @FXML
    private Button buttonPlusDutyFree;
    @FXML
    private Button buttonMinusDutyFree;
    @FXML
    private Button buttonMinusPassport;
    @FXML
    private ImageView counter1;
    @FXML
    private ImageView security1;
    @FXML
    private ImageView security2;
    @FXML
    private ImageView security3;
    @FXML
    private ImageView security4;
    @FXML
    private ImageView security5;
    @FXML
    private ImageView security6;
    @FXML
    private ImageView counter2;
    @FXML
    private ImageView counter3;
    @FXML
    private ImageView counter4;
    @FXML
    MenuButton Selection;
    @FXML
    MenuItem CheckINSelection;
    @FXML
    MenuItem SecuritySelection;
    @FXML
    MenuItem PassportSelection;
    @FXML
    MenuItem DutySelection;
    @FXML
    AnchorPane ContentSecurity;
    @FXML
    AnchorPane ContentDuty;
    @FXML
    AnchorPane checkinContent;
    @FXML
    AnchorPane ContentPassport;
    @FXML
    ImageView cashier1;
    @FXML
    ImageView cashier2;
    @FXML
    ImageView cashier3;
    @FXML
    ImageView control1;
    @FXML
    ImageView control2;
    @FXML
    ImageView control3;
    @FXML
    ImageView control4;
    @FXML
    ImageView control5;
    @FXML
    MenuItem startButton;
    @FXML
    Canvas canvasy;


    int dutyTimes = 1;
    int securityTimes = 5;
    int checkinTimes = 4;
    int passportTimes = 5;


    @FXML
    public synchronized void buttonMinusSecurity() {
        buttonMinusSecurity.setOnAction(e -> {
            if (securityTimes == 1) {
                security1.setVisible(false);
                System.out.println("Check-IN minus button pressed" + securityTimes);
                securityTimes = 1;
            } else if (securityTimes == 2) {
                security2.setVisible(false);
                System.out.println("Check-IN minus button pressed" + securityTimes);
                securityTimes = 2;
            } else if (securityTimes == 3) {
                security3.setVisible(false);
                System.out.println("Check-IN minus button pressed" + securityTimes);
                securityTimes = 3;
            } else if (securityTimes == 4) {
                security4.setVisible(false);
                System.out.println("Check-IN minus button pressed" + securityTimes);
                securityTimes = 4;
            } else if (securityTimes == 5) {
                security5.setVisible(false);
                System.out.println("Check-IN minus button pressed" + securityTimes);
                securityTimes = 5;
            }
            if (securityTimes > 0) {
                securityTimes--;
            }
        });
    }

    @FXML
    public synchronized void buttonPlusSecurity() {
        buttonPlusSecurity.setOnAction(e -> {
            if (securityTimes == 5) {
                security5.setVisible(true);
                System.out.println("Check-IN plus button pressed" + securityTimes);
                securityTimes = 5;
            } else if (securityTimes == 4) {
                security4.setVisible(true);
                System.out.println("Check-IN plus button pressed" + securityTimes);
                securityTimes = 4;
            } else if (securityTimes == 3) {
                security3.setVisible(true);
                System.out.println("Check-IN plus button pressed" + securityTimes);
                securityTimes = 3;
            } else if (securityTimes == 2) {
                security2.setVisible(true);
                System.out.println("Check-IN plus button pressed" + securityTimes);
                securityTimes = 2;
            } else if (securityTimes == 1) {
                security1.setVisible(true);
                System.out.println("Check-IN plus button pressed" + securityTimes);
                securityTimes = 1;
            }
            if (securityTimes < 5) {
                securityTimes++;
            }
        });
    }


    @FXML
    public synchronized void buttonMinusDuty() {
        buttonMinusDutyFree.setOnAction(e -> {
            if (dutyTimes == 0) {
                cashier1.setVisible(false);
                System.out.println("Duty minus button pressed" + dutyTimes);
            } else if (dutyTimes == 1) {
                cashier2.setVisible(false);
                System.out.println("Duty minus button pressed" + dutyTimes);
            } else if (dutyTimes == 2) {
                cashier3.setVisible(false);
                System.out.println("Duty minus button pressed" + dutyTimes);
            } else if (dutyTimes > 2) {
                dutyTimes = 2;
            }
            dutyTimes++;
        });
    }

    @FXML
    public synchronized void buttonPlusDuty() {
        buttonPlusDutyFree.setOnAction(e -> {
            if (dutyTimes == 0) {
                cashier1.setVisible(true);
                System.out.println("Duty plus button pressed" + dutyTimes);
            } else if (dutyTimes == 1) {
                cashier2.setVisible(true);
                System.out.println("Duty plus button pressed" + dutyTimes);
            } else if (dutyTimes == 2) {
                cashier3.setVisible(true);
                System.out.println("Duty plus button pressed" + dutyTimes);
            } else if (dutyTimes < 0) {
                dutyTimes = 0;
            }
            dutyTimes--;
        });
    }

    @FXML
    public synchronized void ButtonMinusCheckIn() {
        buttonMinus.setOnAction(e -> {
            if (checkinTimes == 1) {
                counter4.setVisible(false);
                checkinTimes = 1;
            } else if (checkinTimes == 2) {
                counter3.setVisible(false);
                checkinTimes = 2;
            } else if (checkinTimes == 3) {
                counter2.setVisible(false);
                checkinTimes = 3;
            } else if (checkinTimes == 4) {
                counter1.setVisible(false);
                checkinTimes = 4;
                System.out.println("Check-IN minus button pressed" + checkinTimes);
            } if (checkinTimes > 0) {
                checkinTimes--;
            }
        });
    }

    @FXML
    public synchronized void ButtonPlusCheckIn() {
        buttonPlus.setOnAction(e -> {
            if (checkinTimes == 1) {
                counter4.setVisible(true);
                checkinTimes = 1;
            } else if (checkinTimes == 2) {
                counter3.setVisible(true);
                checkinTimes = 2;
            } else if (checkinTimes == 3) {
                counter2.setVisible(true);
                checkinTimes = 3;
            } else if (checkinTimes == 4) {
                counter1.setVisible(true);
                checkinTimes = 4;
                System.out.println("Check-IN plus button pressed" + checkinTimes);
            } if (securityTimes < 5) {
                securityTimes++;
            }
        });
    }

    @FXML
    public synchronized void ButtonMinusPassport() {
        buttonMinusPassport.setOnAction(e -> {
            if (passportTimes == 1) {
                control5.setVisible(false);
                passportTimes = 1;
            } else if (passportTimes == 2) {
                control4.setVisible(false);
                passportTimes = 2;
            } else if (passportTimes == 3) {
                control3.setVisible(false);
                passportTimes = 3;
            } else if (passportTimes == 4) {
                control2.setVisible(false);
                passportTimes = 4;
            } else if (passportTimes == 5) {
                control1.setVisible(false);
                passportTimes = 5;
            } if (passportTimes > 0) {
                passportTimes--;
            }
        });
    }

    @FXML
    public synchronized void ButtonPlusPassport() {
        buttonPlusPassport.setOnAction(e -> {
            if (passportTimes == 1) {
                control5.setVisible(true);
                passportTimes = 1;
            } else if (passportTimes == 2) {
                control4.setVisible(true);
                passportTimes = 2;
            } else if (passportTimes == 3) {
                control3.setVisible(true);
                passportTimes = 3;
            } else if (passportTimes == 4) {
                control2.setVisible(true);
                passportTimes = 4;
            } else if (passportTimes == 5) {
                control1.setVisible(true);
                passportTimes = 5;
            } if (passportTimes < 5) {
                passportTimes++;
            }
        });
    }

    @FXML
    public void buttonHidasta() {
        buttonHidasta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                hidasta();
            }
        });

    }
    @FXML
    public void buttonNopeuta() {
        buttonNopeuta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nopeuta();
            }
        });
    }

    @FXML
    private void aloita(ActionEvent event) {
        // Resetoidaan kellon aika ja staattiset muuttujat
        Kello.getInstance().setAika(0);
        // Luodaan uusi moottori ja asetetaan sille asetukset
        //moottori = new OmaMoottori(this);
        visualisointi = new Visualisointi(this, canvasy);
        moottori = new OmaMoottori(this);
        moottori.setSimulointiaika(Integer.parseInt(textFieldAika.getText()));
        moottori.setViive(Integer.parseInt(textFieldViive.getText()));
        moottori.setSettings(new int[]{checkinTimes, securityTimes, passportTimes});
        System.out.println(moottori.getSettings()[0]);
        System.out.println(moottori.getSettings()[1]);
        System.out.println(moottori.getSettings()[2]);
        ((Thread) moottori).start();
        Trace.setTraceLevel(Trace.Level.INFO);
        // Luodaan uusi asikakkaita GUI:iin
        Thread thread = new Thread(new Runnable() {
            @Override
            public synchronized void run() {
                while (true) {
                    System.out.println("Visualisoi asiakas --- IAM HERE");
                    visualisointi.uusiAsiakas();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();

    }

    public Palvelupiste[] getPalvelupisteet() {
        return ((OmaMoottori) moottori).getPalvelupisteet();
    }


    @Override
    public void naytaLoppuaika(double aika) {

    }

    @Override
    public synchronized void visualisoiAsiakas() {
        System.out.println("Visualisoi asiakas");
        Platform.runLater(new Runnable(){
            public void run(){
                ui.getVisualisointi().uusiAsiakas();
            }
        });
    }

    @Override
    public void kaynnistaSimulointi() {

    }

    @Override
    public void nopeuta() {
        moottori.setViive((long) (moottori.getViive() * 0.9));
    }

    @Override
    public void hidasta() {
        moottori.setViive((long) (moottori.getViive() * 1.10));
    }
}
