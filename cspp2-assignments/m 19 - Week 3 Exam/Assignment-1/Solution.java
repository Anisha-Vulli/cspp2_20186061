import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

class Quiz {
    private String[] answerchoice;
    private String[] questions;
    private String[] answers;
    private String[] choices;
    private int size;
    // private ArrayList<Integer> correctmark;
    // private ArrayList<Integer> wrongmark;
    Quiz() {
        answerchoice = new String[10];
        questions = new String[10];
        answers = new String[10];
        choices = new String[10];
        size = 0;
        // correctmark = new ArrayList<>();
        // wrongmark = new ArrayList<>();
    }

    void addanswerchoice(final String answers) {
        answerchoice[size++] = answers;
    }

    void addquestions(final String question) {
        questions[size++] = question;
    }

    void addanswers(final String answerenter) {
        answers[size++] = answerenter;
    }

    void addchoices(final String choice) {
        choices[size++] = choice;
    }

    int size() {
        return size;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < questions.length; i++) {
            String tempstr = "";
            //System.out.println(questions[i]);
            for (int j = 0; j < choices.length; j++) {
                System.out.println(choices.length);
                // tempstr = tempstr + " " + choices[i];
                // System.out.println(tempstr);
            }
        }

        return "";
    }
    // int getanswer() {
    //     return this.answer;
    // }

    // int getcorrectmark() {
    //     return this.correctmark;
    // }

    // int getwrongmark() {
    //     return this.wrongmark;
    // }
}

/**
 * Solution class for code-eval.
 */
public final class Solution {
     /**
     * Constructs the object.
     */
    private Solution() {
        // leave this blank
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
         // instantiate this Quiz
        Quiz q = new Quiz();
         // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
             // split the line using space
            String[] tokens = line.split(" ");
              // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                loadQuestions(s, q, Integer.parseInt(tokens[1]));
                break;
                case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
                case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                displayScore(q);
                break;
                default:
                break;
            }
        }
    }
    /**
     * Loads questions.
     *
     * @param      s              The scanner object for user input
     * @param      quiz           The quiz object
     * @param      questionCount  The question count
     */
    public static void loadQuestions(final Scanner s, final Quiz quiz, final int questionCount) {
        //int count = 0;
        //ArrayList<String> questions = new ArrayList<>();
        for (int i = 0; i < questionCount; i++) {
            String[] input = s.nextLine().split(":");
            quiz.addquestions(input[0]);
            quiz.addchoices(input[1]);
            quiz.addanswers(input[2]);
        }
        System.out.println("4 are added to the quiz");
    }

    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public static void startQuiz(final Scanner s, final Quiz quiz, final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object
        
        for (int i = 0; i < answerCount; i++) {
            String[] tokens = s.nextLine().split(" ");
            quiz.addanswerchoice(tokens[1]);
        }

        quiz.toString();
    }

    /**
     * Displays the score report
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
    }
}
