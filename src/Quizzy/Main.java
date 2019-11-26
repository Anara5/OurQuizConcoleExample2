package Quizzy;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class Main {

    private Scanner scanner;
    private static PlayerStorage players;

    public static void main(String[] args) {

        int choice;
        String correct = "Correct!";
        String incorrect = "Incorrect!";

        boolean enter;

        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("[1] story");
            System.out.println("[2] Quiz as it is");
            System.out.println("[3] Exit");

            //logic
            System.out.println("Insert choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    new Story(); //the Quiz Story and Rules Text pops up
                    break;
                case 2:
                    new Main(); //Quiz pops up
                    PlayerStorage players = new PlayerStorage();
                    Scanner scanner = new Scanner(System.in);
                    while (true) {
                        System.out.println("New User Press 1\nUser has an account Press 2\nExit Press 3");
                        String choice1 = scanner.nextLine();
                        switch (choice1) {
                            case "1":
                                System.out.println("Enter a username");
                                String username = scanner.nextLine();
                                System.out.println("Enter password");
                                String password = scanner.nextLine();
                                players.addPlayer(new Player(username, password));
                                break;
                            case "2":
                                System.out.println("Enter your username");
                                username = scanner.nextLine();
                                System.out.println("Enter a password");
                                password = scanner.nextLine();
                                for (Player player : players.getPlayers()) {
                                    if (player.getUsername().equals(username) && player.getPassword().equals(password)) {
                                        System.out.println("Login successfully");
                                        System.out.println("Play game Press 1");
                                        int choicePlay = scanner.nextInt();
                                        int finalScore = 0;
                                        switch (choicePlay) {
                                            case 1:
                                                for (int n = 0; n <= finalScore; n++) {
                                                    new AtomicReference<>(new Random());

                                                    // Set up the quiz
                                                    ArrayList<Question> questions = new ArrayList<>();
                                                    Game game = new Game(player, "2019-11-25", questions);
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
                                                    game.addQuestion(q1);

                                                    q1 = new Question("What is the capital of Denmark?");
                                                    a1 = new Alternative("Stockholm");
                                                    a2 = new Alternative("Oslo");
                                                    a3 = new Alternative("Copenhagen");
                                                    q1.addAlternative(a1);
                                                    q1.addAlternative(a2);
                                                    q1.addAlternative(a3);
                                                    q1.setCorrectAlternative(a3);
                                                    game.addQuestion(q1);

                                                    q1 = new Question("Please enter correct answer: 2 + 3 * 4 = ?");
                                                    a1 = new Alternative("20");
                                                    a2 = new Alternative("14");
                                                    a3 = new Alternative("24");
                                                    q1.addAlternative(a1);
                                                    q1.addAlternative(a2);
                                                    q1.addAlternative(a3);
                                                    q1.setCorrectAlternative(a2);
                                                    game.addQuestion(q1);

                                                    // Play the game
                                                    // Print out the welcome screen
                                                    Question currentQuestion;
                                                    Alternative alternativeText;

                                                    ArrayList questionList = game.getQuestionList();
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
                                                        //Scanner sc = new Scanner(System.in);
                                                        int answer = sc.nextInt();
                                                        System.out.println("You entered: " + answer);
                                                        // Check if the entered value is correct

                                                        if (currentQuestion.getAlternatives().get(answer - 1) == currentQuestion.getCorrectAlternative()) {
                                                            //System.out.println("You win! Score is: " + score);
                                                            enter = true;
                                                            finalScore += 1; //increase score count

                                                        } else {
                                                            enter = false;
                                                            finalScore += 0; // not got the point because the user input wrong alternative.
                                                            //We also can make "points -= 1" if we want take away the users point
                                                        }

                                                        if (enter) {
                                                            System.out.println(correct);
                                                            System.out.println("You now have " + finalScore + " points"); //show latest score
                                                        } else {
                                                            System.out.println(incorrect);
                                                        }

                                                        System.out.println("You collected: " + finalScore + "/" + (i)); // +(i) here means the number on the question
                                                        System.out.println();
                                                    }
                                                }
                                                break;
                                            default:
                                                throw new IllegalStateException("Unexpected value: " + choicePlay);
                                        }
                                    }
                                }
                                System.out.println("Wrong username or password");
                                break;
                            case "3":
                                return;
                            default:
                                System.out.println("Invalid choice");
                                break;
                        }
                    }

                    case 3:
                        System.out.println("----------"); //The session is finished in total
                        break;
                    default:
                        System.out.println("The choice is invalid"); //if we press invalid button
                        break;
            }

        } while (choice != 3); // the main menu frame reopens when the sessions finish after the end of each case

    }
}