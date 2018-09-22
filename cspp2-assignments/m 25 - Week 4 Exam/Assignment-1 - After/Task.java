class Task {
    private String title;
    private String assignedTo;
    private int timeToComplete;
    private boolean important;
    private boolean urgent;
    private String status;
    Task(String title1, String assignedTo1, int timeToComplete1, boolean important1, boolean urgent1, String status1) {
        this.title = title1;
        this.assignedTo = assignedTo1;
        this.timeToComplete = timeToComplete1;
        this.important = important1;
        this.urgent = urgent1;
        this.status = status1;
        // if (title.equals(" ")) {
        //  throw new Exception("Title not provided");
        // }
        // if (timeToComplete < 0) {
        //  throw new Exception("Invalid timeToComplete" + timeToComplete);
        // }
        // if (!status.equals("todo") || !status.equals("done")) {
        //  throw new Exception("Invalid status" + status);
        // }
    }

    // public String checktitle(String title) {
    //     if (title.equals(" ")) {
    //      throw new Exception("Title not provided");
    //     } else {
    //         return title;
    //     }
    // }

    public String checkimportant(boolean imp) {
        if (important) {
            return "Important";
        } else {
            return "Not Important";
        }
    }

    public String checkurgent(boolean urg) {
        if (urgent) {
            return "Urgent";
        } else {
            return "Not Urgent";
        }
    }

    public String toString() {
        //return checktitle(title) + ", " + assignedTo + ", " + timeToComplete + ", " + checkimportant(important) + ", " + checkurgent(urgent) + ", " + status;
        return title + ", " + assignedTo + ", " + timeToComplete + ", " + checkimportant(important) + ", " + checkurgent(urgent) + ", " + status;
    }
}