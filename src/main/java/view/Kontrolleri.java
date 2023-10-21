package view;

import controller.IKontrolleriForM;
import controller.IKontrolleriForV;
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
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import simu.framework.IMoottori;
import simu.framework.Kello;
import simu.framework.Trace;
import simu.model.OmaMoottori;

public class Kontrolleri implements IKontrolleriForM {
    private Visualisointi visualisointi;
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


    int dutyTimes = 0;
    int securityTimes = 0;
    int checkinTimes = 0;
    int passportTimes = 0;


    @FXML
    public synchronized void buttonMinusSecurity() {
        buttonMinusSecurity.setOnAction(e -> {
            if (securityTimes == 0) {
                security1.setVisible(false);
                System.out.println("Check-IN minus button pressed" + securityTimes);
            } else if (securityTimes == 1) {
                security2.setVisible(false);
                System.out.println("Check-IN minus button pressed" + securityTimes);
            } else if (securityTimes == 2) {
                security3.setVisible(false);
                System.out.println("Check-IN minus button pressed" + securityTimes);
            } else if (securityTimes == 3) {
                security4.setVisible(false);
                System.out.println("Check-IN minus button pressed" + securityTimes);
            } else if (securityTimes == 4) {
                security5.setVisible(false);
                System.out.println("Check-IN minus button pressed" + securityTimes);
            } else if (securityTimes == 5) {
                security6.setVisible(false);
                System.out.println("Check-IN minus button pressed" + securityTimes);
            } else if (securityTimes > 5) {
                securityTimes = 5;
            }
            securityTimes++;
        });
    }

    @FXML
    public synchronized void buttonPlusSecurity() {
        buttonPlusSecurity.setOnAction(e -> {
            if (securityTimes == 5) {
                security6.setVisible(true);
                System.out.println("Check-IN plus button pressed" + securityTimes);
            } else if (securityTimes == 4) {
                security5.setVisible(true);
                System.out.println("Check-IN plus button pressed" + securityTimes);
            } else if (securityTimes == 3) {
                security4.setVisible(true);
                System.out.println("Check-IN plus button pressed" + securityTimes);
            } else if (securityTimes == 2) {
                security3.setVisible(true);
                System.out.println("Check-IN plus button pressed" + securityTimes);
            } else if (securityTimes == 1) {
                security2.setVisible(true);
                System.out.println("Check-IN plus button pressed" + securityTimes);
            } else if (securityTimes == 0) {
                security1.setVisible(true);
                System.out.println("Check-IN plus button pressed" + securityTimes);
            } else if (securityTimes < 0) {
                securityTimes = 0;
            }
            securityTimes--;
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
            if (checkinTimes == 0) {
                counter4.setVisible(false);
            } else if (checkinTimes == 1) {
                counter3.setVisible(false);
            } else if (checkinTimes == 2) {
                counter2.setVisible(false);
            } else if (checkinTimes == 3) {
                counter1.setVisible(false);
                System.out.println("Check-IN minus button pressed" + checkinTimes);
            } else if (checkinTimes > 4) {
                checkinTimes = 4;
            }
            checkinTimes++;
        });
    }

    @FXML
    public synchronized void ButtonPlusCheckIn() {
        buttonPlus.setOnAction(e -> {
            if (checkinTimes == 0) {
                counter4.setVisible(true);
            } else if (checkinTimes == 1) {
                counter3.setVisible(true);
            } else if (checkinTimes == 2) {
                counter2.setVisible(true);
            } else if (checkinTimes == 3) {
                counter1.setVisible(true);
                System.out.println("Check-IN plus button pressed" + checkinTimes);
            } else if (passportTimes < 0) {
                checkinTimes = 0;
            }
            checkinTimes--;
        });
    }

    @FXML
    public synchronized void ButtonMinusPassport() {
        buttonMinusPassport.setOnAction(e -> {
            if (passportTimes == 0) {
                control5.setVisible(false);
            } else if (passportTimes == 1) {
                control4.setVisible(false);
            } else if (passportTimes == 2) {
                control3.setVisible(false);
            } else if (passportTimes == 3) {
                control2.setVisible(false);
            } else if (passportTimes == 4) {
                control1.setVisible(false);
            } else if (passportTimes > 4) {
                passportTimes = 4;
            }
            passportTimes++;
        });
    }

    @FXML
    public synchronized void ButtonPlusPassport() {
        buttonPlusPassport.setOnAction(e -> {
            if (passportTimes == 0) {
                control5.setVisible(true);
            } else if (passportTimes == 1) {
                control4.setVisible(true);
            } else if (passportTimes == 2) {
                control3.setVisible(true);
            } else if (passportTimes == 3) {
                control2.setVisible(true);
            } else if (passportTimes == 4) {
                control1.setVisible(true);
            } else if (passportTimes < 0) {
                passportTimes = 0;
            }
            passportTimes--;
        });
    }

    @FXML
    public void buttonHidasta() {
        buttonHidasta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                kontrolleri.hidasta();
            }
        });

    }

    @FXML
    public void buttonNopeuta() {
        buttonNopeuta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                kontrolleri.nopeuta();
            }
        });
    }

    @FXML
    private void aloita(ActionEvent event) {
        // Resetoidaan kellon aika ja staattiset muuttujat
        Kello.getInstance().setAika(0);
        // Luodaan uusi moottori ja asetetaan sille asetukset
        //moottori = new OmaMoottori(this);
        moottori = new OmaMoottori(this);
        moottori.setSimulointiaika(Integer.parseInt(textFieldAika.getText()));
        moottori.setViive(Integer.parseInt(textFieldViive.getText()));
        //Stage simulaationStage = (Stage) simulaatioSivu.getScene().getWindow();
        ((Thread) moottori).start();
        Trace.setTraceLevel(Trace.Level.INFO);
        //visualisointi.aloitaVisualisointi();
    }


    @Override
    public void naytaLoppuaika(double aika) {

    }

    @Override
    public void visualisoiAsiakas() {

    }
}
