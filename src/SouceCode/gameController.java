package SouceCode;

import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.text.DecimalFormat;
import java.util.Random;


/**
 * Created by Aaiyeesha Mostak on 6/8/2016.
 */


public class gameController
{
    @FXML
    public TextField typeHere;
    @FXML
    public Label typeThis;
    @FXML
    public Label instruct;
    @FXML
    public ImageView animatedcar;
    @FXML
    public ImageView background;
    @FXML
    public Label resultmsg;
    @FXML
    public Label header;


    ServerMain servermain;
    ServerController serverController;

    /*
    This string holds the string typed by the user
     */

    String string;

    /*
    Timing variable
     */

    Long startTime;
    Long requiredTime;
    double score;

    String result;
    String[] showmsg = {
            "You belong to the BEGINNER class. You need to practice more to speed up.",
            "You belong to the INTERMEDIATE class. May be you should practice more to speed up. A little extra speed helps, right?",
            "You belong to the AVERAGE class. Your speed is quite good. But you can certainly improve it.",
            "You belong to the TYPEMASTER class. You have an incredible typing speed !! Congratulations."
            };

    @FXML
    public void calculateWPM() throws Exception
    {
        string = typeHere.getText();
        if(lines[c].startsWith(string))
        {
            instruct.setTextFill(Color.GREEN);
            double distance = string.length()*486.0/lines[c].length();
            animatedcar.setLayoutX(35 + distance);

            if(lines[c].equals(string))
            {
                requiredTime = System.currentTimeMillis() - startTime;
                score = (lines[c].length() *60000.0) / (requiredTime * 5);
                typeHere.setDisable(true);

                typeThis.setText("");
                typeHere.setVisible(false);

                String formattedScore = new DecimalFormat("##.##").format(score);

                background.setVisible(false);
                instruct.setText("");
                header.setVisible(true);


                if(score <= 24)
                {
                    result = "Your WPM is " + formattedScore + " . " +  showmsg[0];
                }
                else if(score <= 32)
                {
                    result = "Your WPM is " + formattedScore + " . " +  showmsg[1];
                }
                else if(score <= 45)
                {
                    result = "Your WPM is " + formattedScore + " . " +  showmsg[2];
                }
                else
                {
                    result = "Your WPM is " + formattedScore + " . " +  showmsg[3];
                }


                resultmsg.setText(result);
                animatedcar.setLayoutY(325);
                animatedcar.setLayoutX(450);
                animatedcar.setFitWidth(220);
                animatedcar.setFitHeight(120);

            }
            else
            {
                instruct.setText("Continue typing");
            }
        }

        else
        {
            instruct.setTextFill(Color.RED);
            instruct.setText("You typed wrong - Correct it to progress");
        }

    }




    String []lines ={

            "Your mind is a powerful thing. When you fill it with positive thoughts, your life start to change.",
            "Look for something positive in each day, even if some days you have to look a little harder.",
            "It's nice to be important. But it's more important to be nice.",
            "When it rains, look for RAINBOWS. When it's dark, look for starts.",
            "Nothing is permanent, NOTHING. Not even the worst days of your life.",
            "If opportunity doesn't knock, build a door.",
            "Do not give up, the beginning is always the hardest.",
            "It's a funny thing, the more I practice, the luckier I get.",
            "Problems are not stop signs, they are the guidelines.",
            "The only place success comes before work is in the dictionary.",
            "SUCCESS all depends on the second letter. Yeah, U. ",
            "Always laugh when you can, it is a cheap medicine.",
            "Happiness is a journey, not a destination.",
            "All BIRDS find shelter during a rain, but EAGLE avoids rain by flying above the clouds; problems are common but attitude makes the difference."

    };

    Random random=new Random();
    int c =(random.nextInt(lines.length-1));


    public void setMain(ServerMain main)
    {
        this.servermain = main;
        instruct.setText("Server will show message in 5 seconds, get ready");
    }


    public void setInstruction()
    {
        instruct.setText("Type the line given below");
        typeThis.setText(lines[c]);
        startTime = System.currentTimeMillis();
    }


    public void setServerController(ServerController serverController)
    {
        this.serverController = serverController;
    }

}
