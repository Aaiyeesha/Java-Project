package SouceCode;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.util.Random;

/**
 * Created by Aaiyeesha Mostak on 6/8/2016.
 */
public class ServerController
{
    ServerMain servermain;
    gameController controller;

    @FXML
    public void buttonclicked(ActionEvent event) throws Exception
    {
        servermain.showGamePage();
        Thread t = new Thread();
        try
        {
            t.sleep(5000);
        }
        catch (InterruptedException e)
        {
            System.out.println("Error in button click");
        }

        controller = servermain.gameController;
        controller.setInstruction();
    }


    @FXML
    public void showSorryPage(ActionEvent event) throws Exception
    {
        servermain.sorryPage();
    }


    public void setMain(ServerMain main) {
        this.servermain = main;
    }
}
