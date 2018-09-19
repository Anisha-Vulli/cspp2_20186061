import java.util.ArrayList;
import java.util.Arrays;
class Fooddata {
    private String fooditem;
    private int foodquant;
    private String date;
    private String foodtime;
    Fooddata(final String fooditem1, final int foodquant1, final String date1,final String foodtime1) {
        this.fooditem = fooditem1;
        this.foodquant = foodquant1;
        this.date = date1;
        this.foodtime = foodtime1;
    }

    // public String getfooditem() {
    //     return fooditem;
    // }

    // public int getfoodquant() {
    //     return foodquant;
    // }

    // public String getfoodtime() {
    //     return foodtime;
    // }

    // public void setfooditem(final String item) {
    //     this.fooditem = item;
    // }

    // public void setfoodquant(final int quant) {
    //     this.foodquant = quant;
    // }

    // public void setfoodtime(final String time) {
    //     this.foodtime = time;
    // }
    
    public String getdate() {
        return this.date;
    }

    public String toString() {
        return "Food" + "\n" + "Date:" + date + "\n" + "Time:" + foodtime + "\n" + "Name:" + fooditem + "\n" + "Quantity:" + foodquant;
    }
}

class Waterdata {
    private int waterquant;
    private String date;
    private String time;
    Waterdata(final int waterquant1, final String date1, final String time1) {
        this.waterquant = waterquant1;
        this.date = date1;
        this.time = time1;
    }

    public String getdate() {
        return date;
    }

    // public void setwaterquant(final int quant) {
    //     this.waterquant = quant;
    // }
    
    public String toString() {
        return "Water" + "\n" + "Date:" + date + "\n" + "Quantity:" + waterquant;
    }
}

class Activitydata {
    private String activityname;
    private String activitystime;
    private String activityetime;
    private String activitynotes;
    private String activitydate;
    Activitydata(String activityname1, String activitynotes1, String activitydate1 ,String activitystime1, String activityetime1) {
        this.activityname = activityname1;
        this.activitystime = activitystime1;
        this.activityetime = activityetime1;
        this.activitynotes = activitynotes1;
        this.activitydate = activitydate1;
    }

    // public String getactname() {
    //     return activityname;
    // }

    // public String getactstime() {
    //     return activitystime;
    // }

    // public String getsctetime() {
    //     return activityetime;
    // }

    public String getdate() {
        return activitydate;
    }

    // public void setactname(String name) {
    //     this.activityname = name;
    // }

    // public void setactstime(String stime) {
    //     this.activitystime = stime;
    // }

    // public void setactetime(String etime) {
    //     this.activityetime = etime;
    // }

    // public void setactnotes(String notes) {
    //     this.activitynotes = notes;
    // }

    public String toString() {
        String title = "PhysicalActivity";
        String name = "Name:" + activityname;
        String notes = "Notes:" + activitynotes;
        String date = "Date:" + activitydate;
        String stime = "Starttime:" + activitystime;
        String etime = "Endtime:" + activityetime;
        return title + "\n" + name + "\n" + notes + "\n" + date + "\n" + stime + "\n" + etime;
    }
}

class Weightdata {
    private String weight;
    private String date;
    private String time;
    private String fatper;

    Weightdata(String date1, String time1, String weight1, String fatper1) {
        this.weight = weight1;
        this.fatper = fatper1;
        this.date = date1;
        this.time = time1;
    }

    public String getdate() {
        return date;
    }

    // public int getfatper() {
    //     return fatper;
    // }
    
    public String toString() {
        String title = "Weight";
        String pdate = "Date:" + date;
        String ptime = "Time:" + time;
        String weigh = "Weight:" + weight;
        String fat = "Fat:" + fatper;
        return title + "\n" + pdate + "\n" + ptime + "\n" + weigh + "\n" + fat;
    }
}

class Sleepdata {
    private String sleepdate;
    private String sleepstime;
    private String sleepetime;
    Sleepdata(String sleepdate1, String sleepstime1, String sleepetime1) {
        this.sleepdate = sleepdate1;
        this.sleepstime = sleepstime1;
        this.sleepetime = sleepetime1;
    }

    public String getsleepdate() {
        return sleepdate;
    }

    // public String getsleepetime() {
    //     return this.sleepetime;
    // }
    
    public String toString() {
        String title = "Sleep";
        String psdate = "Date:" + sleepdate;
        String pstime = "Starttime:" + sleepstime;
        String psetime = "Endtime:" + sleepetime;
        return title + "\n" + psdate + "\n" + pstime + "\n" + psetime;
    }
}

// class Date {
//     private String entereddate;
//     Date(String entereddate1) {
//         this.entereddate = entereddate1;
//     }

//     String getdate() {
//         return entereddate;
//     }

//     void setdate(String givendate) {
//         this.entereddate = givendate;
//     }
// }

class Fitbit {
    private ArrayList<Fooddata> foodarray;
    private ArrayList<Waterdata> waterarray;
    private ArrayList<Activitydata> activityarray;
    private ArrayList<Weightdata> weightarray;
    private ArrayList<Sleepdata> sleeparray;
    //private ArrayList<String> datearray;
    //private String date;
    Fitbit() {
        foodarray = new ArrayList<>();
        waterarray = new ArrayList<>();
        activityarray = new ArrayList<>();
        weightarray = new ArrayList<>();
        sleeparray = new ArrayList<>();
    }

    void addtofood(Fooddata food) {
        foodarray.add(food);
    }

    void addtowater(Waterdata water) {
        waterarray.add(water);
    }

    void addtoactivity(Activitydata activity) {
        activityarray.add(activity);
    }

    void addtoweight(Weightdata weight) {
        weightarray.add(weight);
    }

    void addtosleep(Sleepdata sleep) {
        sleeparray.add(sleep);
    }

    public void displayfood() {
        if (foodarray.size() == 0) {
            System.out.println("None");
        }
        for (Fooddata food : foodarray) {
           System.out.println(food);   
        }
    }

    public void displayfoodwithdate(String date) {
        if (foodarray.size() == 0) {
            System.out.println("None");
        }
        for (Fooddata food : foodarray) {
            if (food.getdate().equals(date)) {
                System.out.println(food);      
            }
        }
    }

    public void displaywater() {
        if (waterarray.size() == 0) {
            System.out.println("None");
        }
        for (Waterdata water : waterarray) {
            System.out.println(water);
        }
    }

    public void displaywaterwithdate(String date) {
        if (waterarray.size() == 0) {
            System.out.println("None");
        }
        for (Waterdata water : waterarray) {
            if (water.getdate().equals(date)) {
                System.out.println(water);   
            }
        }
    }

    public void displayact() {
        if (activityarray.size() == 0) {
            System.out.println("None");
        }
        for (Activitydata act : activityarray) {
            System.out.println(act);
        }
    }

    public void displayactwithdate(String date) {
        if (activityarray.size() == 0) {
            System.out.println("None");
        }
        for (Activitydata act : activityarray) {
            if (act.getdate().equals(date)) {
                System.out.println(act);   
            }
        }
    }

    public void displayweigh() {
        if (weightarray.size() == 0) {
            System.out.println("None");
        }
        for (Weightdata weigh : weightarray) {
            System.out.println(weigh);
        }
    }

    public void displayweighwithdate(String date) {
        if (weightarray.size() == 0) {
            System.out.println("None");
        }
        for (Weightdata weigh : weightarray) {
            if (weigh.getdate().equals(date)) {
                System.out.println(weigh);   
            }
        }
    }

    public void displaysleep() {
        if (sleeparray.size() == 0) {
            System.out.println("None");
        }
        for (Sleepdata sleep : sleeparray) {
            System.out.println(sleep);
        }
    }

    public void displaysleepwithdate(String date) {
        if (sleeparray.size() == 0) {
            System.out.println("None");
        }
        for (Sleepdata sleep : sleeparray) {
            if (sleep.getsleepdate().equals(date)) {
                System.out.println(sleep);   
            }
        }
    }

    public void displaysummary() {
        displayfood();
        displaywater();
        displayact();
        displayweigh();
        displaysleep();
    }

    public void displaysummarywithdate(String date) {
        displayfoodwithdate(date);
        displaywaterwithdate(date);
        displayactwithdate(date);
        displayweighwithdate(date);
        displaysleepwithdate(date);
    }
}