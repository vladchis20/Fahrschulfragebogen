package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewController implements Initializable {

    @FXML
    Button startQuizBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    /**
     * Opens the scene with the start of the quiz
     *
     * @throws IOException
     */
    public void startQuiz() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../view/quiz.fxml"));
        Stage window = (Stage) startQuizBtn.getScene().getWindow();
        window.setScene(new Scene(root, 900, 750));
    }
}