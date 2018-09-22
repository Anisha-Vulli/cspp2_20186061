import java.util.Arrays;
class Todoist {
    public Task[] tasksarr = new Task[6];
    private int taskcount;
    /**
     * Constructs the object.
     */
    Todoist() {
        taskcount = 0;
    }

    public void addTask(Task taskgiven) {
        try {
        	tasksarr[taskcount++] = taskgiven;
            //taskcount++;
        } catch (Exception e) {
        	taskresize();
            addTask(taskgiven);
        }
    }
    
    /**
     * { function_description }
     */
    public void taskresize() {
        tasksarr = Arrays.copyOf(tasksarr, 2 * taskcount);
    }
    
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "";
        for (int i = 0; i < taskcount; i++) {
            String imp = "Not Important";
            String urg = "Not Urgent";
            if (tasksarr[i].important) {
                imp = "Important";
            }
            if (tasksarr[i].urgent) {
                urg = "Urgent";
            }
            str += tasksarr[i].title + ", " + tasksarr[i].assignedTo + ", " + tasksarr[i].timeTocomplete +", " + tasksarr[i].important + ", " + tasksarr[i].urgent +", " + tasksarr[i].status;
            str += "\n";
        }
        return str;
    }
}