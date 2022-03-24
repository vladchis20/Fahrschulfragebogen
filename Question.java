package model;

import java.util.List;

public class Question {
    private int id;
    private String text;
    private String answerA;
    private String answerB;
    private String answerC;
    private List<String> correctAnswers;

    public int getId() {
        return id;
    }

    public Question setId(int id) {
        this.id = id;

        return this;
    }

    public String getText() {
        return text;
    }

    public Question setText(String text) {
        this.text = text;

        return this;
    }

    public String getAnswerA() {
        return answerA;
    }

    public Question setAnswerA(String answerA) {
        this.answerA = answerA;

        return this;
    }

    public String getAnswerB() {
        return answerB;
    }

    public Question setAnswerB(String answerB) {
        this.answerB = answerB;

        return this;
    }

    public String getAnswerC() {
        return answerC;
    }

    public Question setAnswerC(String answerC) {
        this.answerC = answerC;

        return this;
    }

    public List<String> getCorrectAnswers() {
        return correctAnswers;
    }

    public Question setCorrectAnswers(List<String> correctAnswers) {
        this.correctAnswers = correctAnswers;

        return this;
    }
}
