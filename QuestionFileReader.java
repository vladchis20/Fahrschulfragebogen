package services;

import model.Question;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionFileReader {
    /**
     * Reads from a file and creates a list of questions
     *
     * @return
     */
    public static List<Question> readFromFile(){
        BufferedReader reader;
        List<Question> questions = new ArrayList<>();
        try{
            reader = new BufferedReader(new java.io.FileReader("C:\\Users\\Cosmin\\IdeaProjects\\Lab5\\Cosmin_Vlad_L5\\src\\questions"));
            String line = reader.readLine();
            while (line != null){
                line = reader.readLine();
                if (line == null) {
                    continue;
                }
                // Builds a Question
                String[] questionSplit = line.split("; ");

                Question question = new Question();
                question.setId(Integer.parseInt(questionSplit[0]))
                        .setText(questionSplit[1])
                        .setAnswerA(questionSplit[2])
                        .setAnswerB(questionSplit[3])
                        .setAnswerC(questionSplit[4]);

                ArrayList<String> correctAnswers = new ArrayList<>();
                correctAnswers.addAll(Arrays.asList(questionSplit[5].substring(1, questionSplit[5].length() - 1).split(", ")));

                question.setCorrectAnswers(correctAnswers);
                questions.add(question);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        return questions;
    }
}
