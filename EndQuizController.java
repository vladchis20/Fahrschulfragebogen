package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EndQuizController implements Initializable {
    public Label endMessage;
    public Label correctAnswerNr;
    public Label wrongAnswerNr;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //StartUp
    }

    /**
     * Sets a message and the number of correct and wrong answers
     *
     * @param message
     * @param correctAnswerNr
     * @param wrongAnswerNr
     */
    public void setMessageAndScore(String message, String correctAnswerNr, String wrongAnswerNr ){
        this.endMessage.setText(message);
        this.correctAnswerNr.setText(correctAnswerNr);
        this.wrongAnswerNr.setText(wrongAnswerNr);
    }

    /**
     * Starts a new quiz
     *
     * @param actionEvent
     * @throws IOException
     */
    public void tryAgain(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../view/quiz.fxml"));
        Stage window = (Stage) endMessage.getScene().getWindow();
        window.setScene(new Scene(root, 900, 750));
    }

}
