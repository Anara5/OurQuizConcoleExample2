package Quizzy;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Game extends Main{

    private Player player;
    private ArrayList<Question> questionList;
    private int finalScore;
    private Date finalDate;
    private SimpleDateFormat formatter;

    public Game(Player player, ArrayList<Question> questionList) {
        super();
        this.player = player;
        this.questionList = new ArrayList<>();
        this.finalScore = 0;
        this.finalDate= new Date();
        this.formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        printDate(this.finalDate);
    }

    public Game() {
        return;
    }

    private void printDate(Date date) {
        System.out.println(formatter.format(date));
    }
    public void printFinalDate(){
        this.finalDate=new Date();
        System.out.println(formatter.format(finalDate));
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
}
