package Quizzy;

import java.util.Scanner;

public class ShowMenu { //it's just a menu on the main page. We connect it later
    ShowMenu() {
        int choice = 0;

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
                    new Game(); //Quiz Yes or No pops up
                    break;

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