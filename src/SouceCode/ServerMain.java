package SouceCode;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Aaiyeesha Mostak on 6/8/2016.
 */
public class ServerMain  extends Application
{

    Stage stage;
    ServerController serverController;
    gameController gameController;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        stage = primaryStage;
        showMainPage();
    }

    public void showMainPage() throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Server.fxml"));
        Parent root = loader.load();

        ServerController controller = loader.getController();
        controller.setMain(this);
        serverController = controller;

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Server Page");
        stage.show();
    }


    public void showGamePage() throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        Parent root = loader.load();

        gameController controller = loader.getController();
        gameController = controller;
        controller.setMain(this);
        controller.setServerController(serverController);

        stage.setScene(new Scene (root));
        stage.setTitle("Typeracer - Increase your typing speed");
        stage.show();
    }

    public void sorryPage() throws Exception
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sorry.fxml"));
        Parent root = loader.load();

        SorryController controller = loader.getController();
        controller.setMain(this);

        stage.setScene(new Scene (root));
        stage.setTitle("Oops!");
        stage.show();
    }

}