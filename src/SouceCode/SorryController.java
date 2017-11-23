package SouceCode;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Created by Aaiyeesha Mostak on 6/9/2016.
 */
public class SorryController
{
    ServerMain main;

    @FXML
    public Button goback;

    public void setMain(ServerMain main) {
        this.main = main;
    }

    public void gobackClicked(ActionEvent event) throws Exception
    {
        main.showMainPage();
    }
}
