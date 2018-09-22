class Task {
    String title;
    String assignedTo;
    int timeTocomplete;
    boolean important;
    boolean urgent;
    String status;
    //boolean errorflag = true;
    Task(String task1, String name1, int time1, boolean impor, boolean urgent1, String status1) throws Exception{
        this.title = task1;
        this.assignedTo = name1;
        this.timeTocomplete = time1;
        this.important = impor;
        this.urgent = urgent1;
        this.status = status1;
        if (title.equals("")) {
            throw new Exception("Title not Provided");
        }
        if (timeTocomplete < 0) {
            throw new Exception("Invalid timeTocomplete " + timeTocomplete);
        }
        if (!status.equals("todo") && !status.equals("done")) {
            throw new Exception("Invalid status " + status);
        }
    }
    /**
     * { function_description }
     *
     * @param      impor  The impor
     *
     * @return     { description_of_the_return_value }
     */
    public String checkimportance(final boolean impor) {
        if (impor) {
            return "Important";
        } else {
            return "Not Important";
        }
    }
    /**
     * { function_description }
     *
     * @param      urgent  The urgent
     *
     * @return     { description_of_the_return_value }
     */
    public String checkurgency(final boolean urgent) {
        if (urgent) {
            return "Urgent";
        } else {
            return "Not Urgent";
        }
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return title + ", " + assignedTo + ", " + timeTocomplete +", " + checkimportance(important) + ", " + checkurgency(urgent) +", " + status;
    } 
}