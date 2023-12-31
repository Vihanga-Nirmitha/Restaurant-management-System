package lk.ijse.dep11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        AnchorPane root = FXMLLoader.load(getClass().getResource("/view/ServerView.fxml"));
        Scene mainscene = new Scene(root);
        primaryStage.setScene(mainscene);
        primaryStage.setTitle("Control-basic");
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
}
