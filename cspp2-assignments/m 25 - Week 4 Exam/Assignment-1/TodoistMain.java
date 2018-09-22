import java.util.Scanner;
import java.util.Arrays;

/**
  * write your code below this comment
  */

class Task {
    private String title;
    private String assignedTo;
    private int timeTocomplete;
    private boolean important;
    private boolean urgent;
    private String status;
    private boolean errorflag = true;
    Task(String task1, String name1, int time1, boolean impor, boolean urgent1, String status1) {
        this.title = task1;
        this.assignedTo = name1;
        this.timeTocomplete = time1;
        this.important = impor;
        this.urgent = urgent1;
        this.status = status1;
        //errorflag = true;
    }

    public String checktime(int time) {
        if (time > 0) {
            return String.valueOf(time);
        } else {
            System.out.println("Invalid timeTocomplete " + time);
            return null;
        }
    }

    public String checktitle(String titlegiv) {
        if (titlegiv.equals("")) {
            System.out.println("Title not given");
            return null;
        } else {
            return title;
        }
    }
    public String checkimportance(boolean impor) {
        if (impor) {
            return "Important";
        } else {
            return "Not Important";
        }
    }

    public String checkurgency(boolean urgent) {
        if (urgent) {
            return "Urgent";
        } else {
            return "Not Urgent";
        }
    }

    public String checkstatus(String stat) {
        try {
            if (stat.equals("todo") || stat.equals("done")) {
                return stat;
            } else {
                throw new Exception();
            }
        } catch(Exception e) {
            errorflag = false;
            System.out.println("Invalid status " + stat);
            return null;
        }
    }

    public String toString() {
        if (errorflag) {
            String statuswork = checkstatus(status);
            return checktitle(title) + ", " + assignedTo + ", " + checktime(timeTocomplete) +", " + checkimportance(important) + ", " + checkurgency(urgent) +", " + statuswork;   
        } else {
            return null;
        }
    } 
}

class Todoist {
    public Task[] tasks = new Task[6];
    private int taskcount;
    Todoist() {
        taskcount = 0;
    }
}

/**
 * Class for todoist main.
 */
public class TodoistMain {

    /**
     * Starts a test.
     */
    public static void startTest() {
        Todoist todo = new Todoist();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
                case "task":
                    testTask(tokens);
                break;
                // case "add-task":
                //     testAddTask(todo, tokens);
                // break;
                // case "print-todoist":
                //     System.out.println(todo);
                // break;
                // case "get-next":
                //     System.out.println(todo.getNextTask(tokens[1]));
                // break;
                // case "get-next-n":
                //     int n = Integer.parseInt(tokens[2]);
                //     Task[] tasks = todo.getNextTask(tokens[1], n);
                //     System.out.println(Arrays.deepToString(tasks));
                // break;
                // case "total-time":
                //     System.out.println(todo.totalTime4Completion());
                // break;
                default:
                break;
            }
        }
    }

    /**
     * method to test add task.
     *
     * @param      todo    The todo
     * @param      tokens  The tokens
     */
    // public static void testAddTask(final Todoist todo, final String[] tokens) {
    //     try {
    //         todo.addTask(createTask(tokens));
    //     } catch (Exception e) {
    //         System.out.println(e.getMessage());
    //     }
    // }

    /**
     * method to test the creation of task object.
     *
     * @param      tokens  The tokens
     */
    public static void testTask(final String[] tokens) {
        try {
            if (createTask(tokens) != null) {
                System.out.println(createTask(tokens));   
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a task object.
     *
     * @param      tokens     The tokens
     *
     * @return     Task object
     *
     * @throws     Exception  if task inputs are invalid
     */
    public static Task createTask(final String[] tokens) throws Exception {
        String title = tokens[1];
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[3]);
        boolean important = tokens[4].equals("y");
        boolean urgent = tokens[5].equals("y");
        String status = tokens[6];
        return new Task(
            title, assignedTo, timeToComplete, important, urgent, status);
    }

    /**
     * main method.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        startTest();
    }
}
