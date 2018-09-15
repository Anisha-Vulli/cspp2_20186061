import java.util.Scanner;

/**
 * Solution class for code-eval.
 */
public final class Solution {
    private static boolean errorflag = false;
     /**
     * Constructs the object.
     */
    private Solution() {
        // leave this blank
    }
    /**
     * Flag checking
     *
     * @return     { flag }
     */
    public static boolean getflag() {
        return errorflag;
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
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        final int five = 5;
        final int two = 2;
        final int zero = 0;
        final int one = 1;
        final int three = 3;
        final int four = 4;
        if (questionCount == 0) {
                System.out.println("Quiz does not have questions");
                errorflag = true;
        } else {
        for (int i = 0; i < questionCount; i++) {
            String[] tokens = s.nextLine().split(":");
            if (tokens.length != five || tokens[zero].equals("")) {
                System.out.println("Error! Malformed question");
                errorflag = true;
                return;
            }

            if(tokens[one].split(",").length < two) {
                System.out.println(tokens[zero]
                    + " does not have enough answer choices");
                errorflag = true;
                return;
            }

            if (Integer.parseInt(tokens[two]) > four) {
                System.out.println("Error! Correct answer" + 
                    " choice number is out of range for " + tokens[0]);
                errorflag = true;
                return;
            }

            if (Integer.parseInt(tokens[three]) < zero) {
                System.out.println("Invalid max marks for "
                    + tokens[0]);
                errorflag = true;
                return;
            }

            if (Integer.parseInt(tokens[four]) > zero) {
                System.out.println("Invalid penalty for "
                    + tokens[0]);
                errorflag = true;
                return;
            }

            Question newques = new Question(tokens[zero],
                tokens[one], tokens[two],
                Integer.parseInt(tokens[three]),
                Integer.parseInt(tokens[four]));

            quiz.addtoques(newques);
        }
        quiz.displaycount();
    }
    }

    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public static void startQuiz(final Scanner s,
        final Quiz quiz, final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object
        if (getflag()) {
            return;
        }

        for (int i = 0; i < answerCount; i++) {
            String choiceline = s.nextLine();
            quiz.addtochoices(choiceline);
        }
        quiz.displayqueschoice();
    }

    /**
     * Displays the score report.
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
        if (getflag()) {
            return;
        }
        System.out.println("Total Score: " + quiz.caluculatescore());
    }
}
