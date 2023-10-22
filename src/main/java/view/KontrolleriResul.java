package view;

import dao.AsiakasDao;
import dao.SimuDao;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class KontrolleriResul {

    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private MenuItem CheckINSelection;

    @FXML
    private MenuItem DutySelection;

    @FXML
    private HBox HBox;

    @FXML
    private MenuBar MenuBar;

    @FXML
    private MenuItem PassportSelection;

    @FXML
    private ScrollPane ScrollPane;

    @FXML
    private MenuItem SecuritySelection;

    @FXML
    private SplitPane SplitPane;

    @FXML
    private VBox VBox;

    @FXML
    private Menu ViewSelection;

    @FXML
    private Label controlText;

    @FXML
    private Label dataCustomers;

    @FXML
    private Label dataFlights;

    @FXML
    private Label dataMissed;

    @FXML
    private Label dataSimulationTime;

    @FXML
    private ComboBox<String> selection;

    @FXML
    private StackPane stackPane;

    @FXML
    private MenuItem startButton;

    @FXML
    private Font x1;

    @FXML
    private void initialize() {
        AsiakasDao dao = new AsiakasDao();
        SimuDao simuDao = new SimuDao();
        selection.getItems().addAll(simuDao.getNames());
        //selection.getSelectionModel().selectFirst();
    }

    @FXML
    public void selector(){
        AsiakasDao dao = new AsiakasDao();
        SimuDao simuDao = new SimuDao();
        int id = simuDao.getNames().indexOf(selection.getSelectionModel().getSelectedItem()) + 1;
        dataCustomers.setText(String.valueOf(simuDao.find(id).getCustomers()));
        dataSimulationTime.setText(String.valueOf(simuDao.find(id).getTime()));

    }

}
