package BeautifulFlowers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("BeautifulFlowers.fxml")); //loads the fxml file
        primaryStage.setTitle("Beautiful Flowers"); //changes title
        primaryStage.setScene(new Scene(root, 650, 400)); //sets the size of the scene
        primaryStage.show(); //shows the scene
    }


    public static void main(String[] args) {
        launch(args);
    }
}
