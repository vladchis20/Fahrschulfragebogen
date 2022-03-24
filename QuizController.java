package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Quiz;
import services.QuizBuilder;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class QuizController implements Initializable {
    public int questionId = 0;
    public Quiz quiz = QuizBuilder.buildQuiz();
    public Label question;
    public CheckBox answerA;
    public CheckBox answerB;
    public CheckBox answerC;
    public Label correctAnswerNr;
    public Label wrongAnswerNr;
    public Label minutes;
    public Label seconds;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        question.setText(quiz.getQuestionList().get(questionId).getText());
        answerA.setText(quiz.getQuestionList().get(questionId).getAnswerA());
        answerB.setText(quiz.getQuestionList().get(questionId).getAnswerB());
        answerC.setText(quiz.getQuestionList().get(questionId).getAnswerC());
        correctAnswerNr.setText(Integer.toString(quiz.getCorrectAnswersNr()));
        wrongAnswerNr.setText(Integer.toString(quiz.getWrongAnswersNr()));
        countdown();
    }

    /**
     * Quits the current scene
     */
    public void exitScene(){
        Stage stage = (Stage) question.getScene().getWindow();
        stage.close();
    }

    /**
     *Check if the quiz is over(fail or success), otherwise loads the next question
     *
     * @param actionEvent
     * @throws IOException
     */
    public void submitAnswer(ActionEvent actionEvent) throws IOException {
        if (validateAnswers()) {
            correctAnswerNr.setText(Integer.parseInt(correctAnswerNr.getText()) + 1 + "");
        }else{
            wrongAnswerNr.setText(Integer.parseInt(wrongAnswerNr.getText()) + 1 + "");
        }
        if (Integer.parseInt(wrongAnswerNr.getText()) == 5){
            quizEnd("Ai picat testul");
            exitScene();
        }
        if (questionId == 25){
            quizEnd("Ai trecut testul, felicitari!");
            exitScene();
        }

        questionId += 1;
        question.setText(quiz.getQuestionList().get(questionId).getText());
        answerA.setText(quiz.getQuestionList().get(questionId).getAnswerA());
        answerB.setText(quiz.getQuestionList().get(questionId).getAnswerB());
        answerC.setText(quiz.getQuestionList().get(questionId).getAnswerC());
    }

    /**
     * Checks if the user answered correctly or not
     *
     * @return bool
     */
    public boolean validateAnswers(){
        List<String> answers = new ArrayList<>();
        if(answerA.isSelected()){
            answers.add("A");
        }
        if(answerB.isSelected()){
            answers.add("B");
        }
        if(answerC.isSelected()){
            answers.add("C");
        }
        return quiz.getQuestionList().get(questionId).getCorrectAnswers().equals(answers);
    }

    /**
     * Opens a new window for the end results(message and score)
     *
     * @param message
     */
    public void quizEnd(String message){
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("../view/endQuiz.fxml"));
            Parent root = (Parent) loader.load();

            EndQuizController endQuizController = loader.getController();
            endQuizController.setMessageAndScore(message, correctAnswerNr.getText(), wrongAnswerNr.getText());

            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 30 minutes countdown
     */
    public void countdown(){
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    if(seconds.getText().equals("00")){
                        if(minutes.getText().equals("00")){
                            // if time expired, go to end quiz
                            quizEnd("Timpul a expirat");
                            exitScene();
                        }if(Integer.parseInt(minutes.getText()) <= 10){
                            minutes.setText("0" + (Integer.parseInt(minutes.getText()) - 1));
                        }
                        else{
                            minutes.setText(Integer.parseInt(minutes.getText()) - 1 + "");
                        }
                        seconds.setText("59");
                    }
                    else{
                        if(seconds.getText().equals("1")){
                            seconds.setText("00");
                        }
                        else{
                            if(Integer.parseInt(seconds.getText()) <= 10){
                                seconds.setText("0" + (Integer.parseInt(seconds.getText()) - 1));
                            }
                            else{
                                seconds.setText(Integer.parseInt(seconds.getText()) - 1 + "");
                            }
                        }
                    }
                });
            }
        }, 1000, 1000);
    }
}
