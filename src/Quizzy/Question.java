package Quizzy;
//question object

import java.util.ArrayList;

public class Question extends Throwable {

    private String questionText;

    public Question() {
        return;
    }

    public ArrayList<Alternative> getAlternatives() {
        return alternatives;
    }

    public static void setAlternatives() {
    }

    public static void setQuestionText() {
    }

    public void setAlternatives(ArrayList<Alternative> alternatives) {
        this.alternatives = alternatives;
    }

    public Alternative getCorrectAlternative() {
        return correctAlternative;
    }

    private ArrayList<Alternative> alternatives = new ArrayList<Alternative>();
    private Alternative correctAlternative;

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Question(String i_questionText) {
        this.questionText = i_questionText;
    }

    public void addAlternative(Alternative i_alternative) {
        alternatives.add(i_alternative);
    }

    public void setCorrectAlternative(Alternative i_correctAlternative) {
        this.correctAlternative = i_correctAlternative;
    }

}
