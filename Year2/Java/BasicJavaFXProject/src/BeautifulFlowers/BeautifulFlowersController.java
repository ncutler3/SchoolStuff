package BeautifulFlowers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BeautifulFlowersController implements Initializable {
    @FXML
    private ImageView flowersImageView; //declare the image view

    @FXML
    private Label flowersNote; //declare the label

    @FXML
    private RadioButton roseRadioButton; //declare the radio buttons

    @FXML
    private RadioButton callaLilyRadioButton;

    @FXML
    private RadioButton cannaRadioButton;

    @FXML
    private RadioButton bleedingHeartRadioButton;

    @FXML
    private RadioButton cherryBlossomRadioButton;

    private Image roseImage; //declare all 5 images
    private Image callaLilyImage;
    private Image cannaImage;
    private Image bleedingHearImage;
    private Image cherryBlossomImage;

    @Override
    public void initialize(URL url, ResourceBundle rb){ //initialize the 5 images when the program starts
        roseImage = new Image("file:src\\BeautifulFlowers\\Rose.gif"); //i troublshot this for about an hour cuz i had no idea exactly what was meant to go here
        callaLilyImage = new Image("file:src\\BeautifulFlowers\\Calla Lily.gif");
        cannaImage = new Image("file:src\\BeautifulFlowers\\Canna.gif");
        bleedingHearImage = new Image("file:src\\BeautifulFlowers\\Bleeding Heart.gif");
        cherryBlossomImage = new Image("file:src\\BeautifulFlowers\\Cherry Blossom.gif");
    }

    public void roseRadioButtonListener() { //eventListeners for each of the 5 radio buttons, changes text and image depending on the button clicked
        flowersImageView.setImage(roseImage);
        flowersNote.setText("This beautiful flower and symbol of love belongs the genus Rosa. The family name of this flower is Rosaceae and it contains different other species in almost all parts of the world. The flower of rose vary in size from each other depending upon the speciesto which they belong. A large number of species of this flower are found in different parts of Asia.");
    }
    public void callaLilyRadioButtonListener() {
        flowersImageView.setImage(callaLilyImage);
        flowersNote.setText("One simple and common name of this beautiful flower is arum lily and this flowering plant belongs to the family known as Araceae. This flowering plant is grown well in areas which have reasonable rainfall and moderate temperatures.");
    }
    public void cannaRadioButtonListener() {
        flowersImageView.setImage(cannaImage);
        flowersNote.setText("This beautiful flowering plant belongs to a genus that contain around 10 species and its family is known as Cannaceae. This flower plant also provides large quantity of starch which is further used for different purposes. This flower is mostly found in tropical regions of the world. The flowers of this plant have three sepals and three petals.");
    }
    public void bleedingHeartRadioButtonListener() {
        flowersImageView.setImage(bleedingHearImage);
        flowersNote.setText("The bleeding heart flower belongs to the family known as Papaveraceae. This heart shaped flower is famous all over the world due to its unique beauty and is found in great numbers in Siberia and China. Blooming season of this flower starts in spring when there spread beautiful pink heart-shaped flowers in gardens. Lady-in-a-bath is also a common name of this flower.");
    }
    public void cherryBlossomRadioButtonListener() {
        flowersImageView.setImage(cherryBlossomImage);
        flowersNote.setText("Cherry blossom, a beautiful flowering plant is found in different parts of the world including the Northern Hemisphere. It is found in those areas which have moderate climate. All species of this flowering plant do not produce cherries as there are special species of this flower that produce edible cherries.");
    }
}
