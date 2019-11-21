package Quizzy;

import java.util.ArrayList;

public class Quiz {
    ArrayList<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(ArrayList<Question> questionList) {
        this.questionList = questionList;
    }

    ArrayList<Question> questionList = new ArrayList<Question>();

    public void addQuestion(Question i_question) {
        questionList.add(i_question);
    }
}
