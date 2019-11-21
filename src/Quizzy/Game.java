package Quizzy;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) throws IOException {

        String correct = "Correct!";
        String incorrect = "Incorrect!";
        int points = 0;
        boolean enter;

        for (int n = 0; n <= points; n++) {
            Random random = new Random();


            // Set up the quiz
            Quiz quiz = new Quiz();
            Question q1 = new Question("What is the capital of Sweden?");
            Alternative a1 = new Alternative("Stockholm");
            Alternative a2 = new Alternative("Oslo");
            Alternative a3 = new Alternative("Helsinki");
            Alternative a4 = new Alternative("Copenhagen");
            q1.addAlternative(a1);
            q1.addAlternative(a2);
            q1.addAlternative(a3);
            q1.addAlternative(a4);
            q1.setCorrectAlternative(a1);
            quiz.addQuestion(q1);


            q1 = new Question("What is the capital of Denmark?");
            a1 = new Alternative("Stockholm");
            a2 = new Alternative("Oslo");
            a3 = new Alternative("Copenhagen");
            q1.addAlternative(a1);
            q1.addAlternative(a2);
            q1.addAlternative(a3);
            q1.setCorrectAlternative(a3);
            quiz.addQuestion(q1);

            q1 = new Question("Please enter correct answer: 2 + 3 * 4 = ?");
            a1 = new Alternative("20");
            a2 = new Alternative("14");
            a3 = new Alternative("24");
            q1.addAlternative(a1);
            q1.addAlternative(a2);
            q1.addAlternative(a3);
            q1.setCorrectAlternative(a2);
            quiz.addQuestion(q1);

            // Play the game
            // Print out the welcome screen
            Question currentQuestion;
            Alternative alternativeText;

            ArrayList questionList = quiz.getQuestionList();
            System.out.println("Welcome to the quiz!");
            int i = 0;
            while (i < questionList.size()) {
                // Display the question
                currentQuestion = (Question) questionList.get(i);
                System.out.println(currentQuestion.getQuestionText());
                int j = 0;
                while (j < currentQuestion.getAlternatives().size()) {
                    Alternative a;
                    a = currentQuestion.getAlternatives().get(j);
                    System.out.println("  " + (j + 1) + ". " + a.getAlternativeText());
                    j++;
                }
                // Stop and get user input
                i++;

                System.out.println("Please enter your answer: ");
                Scanner sc = new Scanner(System.in);
                int answer = sc.nextInt();
                System.out.println("You entered: " + answer);

                // Check if the entered value is correct

//TODOwe need to put the Score to count points

                if (currentQuestion.getAlternatives().get(answer - 1) == currentQuestion.getCorrectAlternative()) {
                    //System.out.println("You win! Score is: " + score);
                    enter = true;
                    points += 1; //increase score count

                } else {
                    enter = false;
                    points += 0; // not got the point because the user input wrong alternative.
                                 //We also can make "points -= 1" if we want take away the users point
                }
                if (enter ==true) {
                    System.out.println(correct);
                    System.out.println("Correct. You now have " + points + " points"); //show latest score
                } else {
                    System.out.println(incorrect);
                }
                System.out.println("You collected: " + points + "/" + (i)); // +(i) here means the number on the question

            }

        }
    }
}


/* determine the high score. This is just an example of the code to count the high score

        int highScore = 0;
        try {
            String file = null;
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null)                 // read the score file line by line
            {
                try {
                    int score = Integer.parseInt(line.trim());   // parse each line as an int
                    if (score > highScore)                       // and keep track of the largest
                    {
                        highScore = score;
                    }
                } catch (NumberFormatException e1) {
                    // ignore invalid scores
                    //System.err.println("ignoring invalid score: " + line);
                }
                line = reader.readLine();
            }
            reader.close();

        } catch (IOException ex) {
            System.err.println("ERROR reading scores from file");
        }
        if (points > highScore)
        {
            System.out.println("The new high score! The previous score was: " + highScore);
        } else if (points == highScore) {
            System.out.println("You tied the high score!");
        } else {
            System.out.println("The all time high score was " + highScore);
        }

        try {
            String file = null;
            BufferedWriter output = new BufferedWriter(new FileWriter(file, true));
            output.newLine();
            output.append("" + points);
            output.close();

        } catch (IOException ex1) {
            System.out.printf("ERROR writing score to file: %s\n", ex1);
        }*/
