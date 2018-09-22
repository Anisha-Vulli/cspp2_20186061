import java.util.Arrays;

class Todoist {
    private Task[] tasks = new Task[6];
    private int taskcount;
    Todoist() {
        taskcount = 0;
    }

    public void addTask(Task taskgiven) {
        try{
            tasks[taskcount] = taskgiven;
            taskcount++;
        } catch (Exception e) {
            taskresize();
        }
    }

    public void taskresize() {
        tasks = Arrays.copyOf(tasks, 2 * taskcount);
    }

    public int totalTime4Completion() {
        int total = 0;
        for (int i = 0; i < taskcount; i++) {
            if (tasks[i].status.equals("todo")) {
                System.out.println(tasks[i].timeToComplete);
                total += tasks[i].timeToComplete;
            }
        }
        return total;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < taskcount; i++) {
            String imp = "";
            String urg = "";
            if (tasks[i].important) {
                imp = "Important";
            } else {
                imp = "Not Important";
            }

            if (tasks[i].urgent) {
                urg = "Urgent";
            } else {
                urg = "Not Urgent";
            }
            str += tasks[i].title + ", " + tasks[i].assignedTo + ", " + tasks[i].timeToComplete + ", " + imp + ", " + urg + ", " + tasks[i].status; 
            str += "\n";
        }
        return str;
    }
}