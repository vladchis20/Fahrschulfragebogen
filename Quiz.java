package model;

import java.util.List;

public class Quiz {
    private int id;
    private int correctAnswersNr = 0;
    private int wrongAnswersNr = 0;
    private List<Question> questionList;

    public int getId() {
        return id;
    }

    public Quiz setId(int id) {
        this.id = id;

        return this;
    }

    public int getCorrectAnswersNr() {
        return correctAnswersNr;
    }

    public Quiz setCorrectAnswersNr(int correctAnswersNr) {
        this.correctAnswersNr = correctAnswersNr;

        return this;
    }

    public int getWrongAnswersNr() {
        return wrongAnswersNr;
    }

    public Quiz setWrongAnswersNr(int wrongAnswersNr) {
        this.wrongAnswersNr = wrongAnswersNr;

        return this;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public Quiz setQuestionList(List<Question> questionList) {
        this.questionList = questionList;

        return this;
    }
}
