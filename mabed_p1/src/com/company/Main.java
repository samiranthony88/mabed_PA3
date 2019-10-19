package com.company;

import java.security.SecureRandom;
import java.util.Scanner;

public class Main {
    public static void getResults(double[] solutions, double[] userAns){
        int correct=0, wrong;
        double percentage;
        for(int i=0;i<10;i++){
            if(solutions[i] == userAns[i]){
                correct++;
            }
        }
        wrong = (10-correct);
        System.out.println();
        System.out.println("Correct Answers: " + correct);
        System.out.println("Wrong Answers: " + wrong);
        percentage = ((double)correct/10);
        if(percentage<0.75){
            System.out.println();
            System.out.println("Please ask your teacher for extra help.");
        } else{
            System.out.println();
            System.out.println("Congratulations, you are ready to go to the next level!");
        }
    }

    public static int getProblemType(){
        Scanner scnr = new Scanner(System.in);
        int input = 0;
        boolean validChoice = false;

        System.out.println("Select Problem Type:");
        System.out.println("1. Addition problems only");
        System.out.println("2. Multiplication problems only");
        System.out.println("3. Subtraction problems only");
        System.out.println("4. Division problems only");
        System.out.println("5. Random mixture of all types");
        while(!validChoice) {
            System.out.println("Make a selection:");
            input = scnr.nextInt();
            if(input>=1 && input<=5){
                validChoice = true;
            }
        }
        return input;
    }

    public static int getDifficulty(){
        int input=0;
        boolean validChoice = false;
        Scanner scnr = new Scanner(System.in);

        System.out.println("1. Numbers with single digits");
        System.out.println("2. Numbers with up to 2 digits");
        System.out.println("3. Numbers with up to 3 digits");
        System.out.println("4. Numbers with up to 4 digits");

        while(!validChoice) {
            System.out.println("Enter your selection (1-4):");
            input = scnr.nextInt();
            if(input >=1 && input <=4) {
                validChoice = true;
            }
        }
        return input;
    }
    public static String generateQuestion(double[] solutions, int currPos, int questionType, int difficulty){
        String question = "";
        SecureRandom rand = new SecureRandom();
        int num1=0, num2=0;

        switch (difficulty){
            case 1:
                num1 = (rand.nextInt(9)+1);
                num2 = (rand.nextInt(9)+1);
                break;
            case 2:
                num1 = (rand.nextInt(99)+1);
                num2 = (rand.nextInt(99)+1);
                break;
            case 3:
                num1 = (rand.nextInt(999)+1);
                num2 = (rand.nextInt(999)+1);
                break;
            case 4:
                num1 = (rand.nextInt(9999)+1);
                num2 = (rand.nextInt(9999)+1);
                break;
        }

        switch (questionType){
            case 1:
                question = "How much is " + num1 + " plus " + num2 +"?";
                solutions[currPos] = (double)num1 + num2;
                break;
            case 2:
                question = "How much is " + num1 + " times " + num2 +"?";
                solutions[currPos] = (double)num1 * num2;
                break;
            case 3:
                question = "How much is " + num1 + " minus " + num2 +"?";
                solutions[currPos] = (double)num1 - num2;
                break;
            case 4:
                question = "How much is " + num1 + " divided by " + num2 +"?";
                solutions[currPos] = (double)num1 / num2;
                break;
        }
        return question;
    }

  public static void getResponse(boolean answer){
        SecureRandom rand = new SecureRandom();
        int option = (rand.nextInt(4)+1);

        if(answer){
            switch(option){
                case 1:
                    System.out.println("Very good!");
                    break;
                case 2:
                    System.out.println("Excellent!");
                    break;
                case 3:
                    System.out.println("Nice work!");
                    break;
                case 4:
                    System.out.println("Keep up the good work!");
                    break;
            }
        } else {
            switch(option){
                case 1:
                    System.out.println("No, please try again.");
                    break;
                case 2:
                    System.out.println("Wrong. Try once more.");
                    break;
                case 3:
                    System.out.println("Don’t give up!");
                    break;
                case 4:
                    System.out.println("No. Keep trying.");
                    break;
            }
        }

    }

    public static void main(String[] args) {
        double[] solutions = new double[10];
        String[] questions = new String[10];
        SecureRandom rand = new SecureRandom();
        Scanner scnr = new Scanner(System.in);
        int difficulty, questionType, temp;
        double[] userAns = new double[10];
        boolean quit = false, answer=false;

        while(!quit) {
            difficulty = getDifficulty();
            questionType = getProblemType();

            if(questionType == 5) {
                for (int i = 0; i < 10; i++) {
                    temp = (rand.nextInt(4) + 1);
                    questions[i] = generateQuestion(solutions, i, temp, difficulty);
                }
            } else {
                for (int i = 0; i < 10; i++) {
                    questions[i] = generateQuestion(solutions, i, questionType, difficulty);
                }
            }

            for(int i=0;i<10;i++){
                System.out.println(questions[i]);
                userAns[i] = scnr.nextDouble();
                if(userAns[i] == solutions[i]){
                    answer = true;
                    getResponse(answer);
                }
                else{
                    answer = false;
                    getResponse(answer);
                }
            }

            getResults(solutions,userAns);

            boolean exitOption = false;
            while(!exitOption){
                System.out.println("Enter 1 to continue or 2 to quit");
                temp = scnr.nextInt();
                switch(temp){
                    case 1:
                        exitOption = true;
                        break;
                    case 2:
                        exitOption = true;
                        quit = true;
                        break;
                    default:
                        System.out.println("Invalid option.");
                }

            }
            }
        }
    }

