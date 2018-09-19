import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Fitbit fb = new Fitbit();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String[] token = scan.nextLine().split(" ");
            switch(token[0]) {
            case "Food":
            String[] foodentry = token[1].split(",");
            fb.addtofood(new Fooddata(foodentry[0], Integer.parseInt(foodentry[1]), foodentry[2], foodentry[3]));
            break;
            case "Water":
            String[] waterentry = token[1].split(",");
            fb.addtowater(new Waterdata(Integer.parseInt(waterentry[0]), waterentry[1], waterentry[2]));
            break;
            case "PhysicalActivity":
            String[] activityentry = token[1].split(",");
            fb.addtoactivity(new Activitydata(activityentry[0], activityentry[1], activityentry[2], activityentry[3], activityentry[4]));
            break;
            case "Weight":
            String[] weightentry = token[1].split(",");
            fb.addtoweight(new Weightdata(weightentry[0], weightentry[1], weightentry[2], weightentry[3]));
            break;
            case "Sleep":
            String[] sleepentry = token[1].split(",");
            fb.addtosleep(new Sleepdata(sleepentry[0], sleepentry[1], sleepentry[2]));
            break;
            case "Foodlog":
            fb.displayfood();
            // fb.displayfoodwithdate("18/9/2018");
            break;
            case "Waterlog":
            fb.displaywater();
            break;
            case "PhysicalActivitylog":
            fb.displayact();
            break;
            case "Weightlog":
            fb.displayweigh();
            break;
            case "Sleeplog":
            fb.displaysleep();
            break;
            case "Summary":
            if (token.length == 1) {
                fb.displaysummary();   
            } else {
                fb.displaysummarywithdate(token[1]);
            }
            break;
            }
        }
    }
}

                    