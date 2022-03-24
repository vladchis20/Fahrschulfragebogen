package services;

import model.Question;
import model.Quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuizBuilder{

    /**
     * Build a quiz with 26 random questions from the list of all questions
     *
     * @return
     */
    public static Quiz buildQuiz(){
        List<Question> allQuestions = QuestionFileReader.readFromFile();
        List<Question> quizQuestions = new ArrayList<>();
        Random rand = new Random();
        for(int i = 1; i <= 26; i++){
            Question question = allQuestions.get(rand.nextInt(allQuestions.size()));
            quizQuestions.add(question);
            allQuestions.remove(question);
        }
        Quiz quiz = (new Quiz())
                .setQuestionList(quizQuestions);

        return quiz;
    }
}
