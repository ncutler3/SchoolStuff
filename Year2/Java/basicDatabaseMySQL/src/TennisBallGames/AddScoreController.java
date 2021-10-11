package TennisBallGames;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddScoreController implements Initializable {

    @FXML
    ComboBox Match;

    @FXML
    Button cancelBtn;

    @FXML
    Button saveBtn;

    @FXML
    TextField homeTeamScore;

    @FXML
    TextField visitorTeamScore;


    final ObservableList<String> data = FXCollections.observableArrayList();
    private MatchesAdapter matchesAdapter;
    private TeamsAdapter teamsAdapter;

    public void setModel(MatchesAdapter match, TeamsAdapter team) {
        matchesAdapter = match;
        teamsAdapter = team;
        buildComboBoxData();
    }

    public void buildComboBoxData() {
        try {
            //build combo box using data
            data.addAll(matchesAdapter.getMatchesNamesList());
        } catch (SQLException ex) {
            displayAlert("ERROR: " + ex.getMessage());
        }
    }

    @FXML
    public void cancel() {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    private void displayAlert(String msg) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Alert.fxml"));
            Parent ERROR = loader.load();
            AlertController controller = (AlertController) loader.getController();

            Scene scene = new Scene(ERROR);
            Stage stage = new Stage();
            stage.setScene(scene);

            stage.getIcons().add(new Image("file:src/TennisBallGames/WesternLogo.png"));
            controller.setAlertText(msg);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

        } catch (IOException ex1) {

        }
    }

    @FXML
    public void save() {
        try {
            //set team score by parsing for integers through the combo box values via string splitting
            matchesAdapter.setTeamsScore(Integer.parseInt(Match.getValue().toString().split("-", 2)[0]), Integer.parseInt(homeTeamScore.getText()), Integer.parseInt(visitorTeamScore.getText()));
            //set status by getting both team names and team scores from the combo box
            teamsAdapter.setStatus(Match.getValue().toString().split("-", 9)[1], Match.getValue().toString().split("-", 9)[2], Integer.parseInt(homeTeamScore.getText()), Integer.parseInt(visitorTeamScore.getText()));
        } catch (SQLException ex) {
            displayAlert("ERROR: " + ex.getMessage());
        }

        Stage stage = (Stage) saveBtn.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Match.setItems(data);
    }

}
