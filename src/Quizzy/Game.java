package Quizzy;

import java.util.ArrayList;

public class Game extends Main{

    private Player player;
    private ArrayList<Question> questionList;
    private int finalScore;
    private String date;

    public Game(Player player, String date, ArrayList<Question> questionList) {

        this.player = player;
        this.questionList = new ArrayList<>();
        this.finalScore = 0;
        this.date = date;
    }

    ArrayList<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(ArrayList<Question> questionList) {
        this.questionList = questionList;
    }

    public void addQuestion(Question i_question) {
        questionList.add(i_question);
    }


    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    public int getFinalScore() {
        return finalScore;
    }
    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
}
