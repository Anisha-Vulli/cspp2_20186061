import java.util.*;
class Socialnetwork {
    static Map<String, ArrayList<String>> map = new TreeMap<>();
    Socialnetwork() {

    }

    public void addconnections(String connect) {
        String in = connect.replace(".","");
        String[] input = in.split(" is connected to ");
        //System.out.println(input[0]);
        if (map.get(input[0]) == null) {
            map.put(input[0], new ArrayList<String>());
        } 
        map.get(input[0]).add(input[1]);
    }

    public void getconnections(String name) {
        //System.out.println(name);
        System.out.println(map.get(name));
    }

    public void common(String names) {
        String[] namein = names.split(",");
        //System.out.println(Arrays.toString(namein));
        ArrayList<String> name1 = map.get(namein[0]);
        String str1 = name1.toString();
        String in1 = str1.replace("[","");
        String in11 = in1.replace("]","");
        String[] strarray1 = in11.split(",");
        ArrayList<String> name2 = map.get(namein[1]);
        String str2 = name2.toString();
        String in2 = str2.replace("[","");
        String in22 = in2.replace("]","");
        String[] strarray2 = in22.split(",");
        //System.out.println(Arrays.toString(strarray2));
        //System.out.println(Arrays.toString(strarray1));
        for (int i = 0; i < strarray1.length; i++) {
            for (int j = 0; j < strarray2.length; j++) {
                if(strarray1[i].equals(strarray2[j])) {
                    System.out.println(strarray2[j]);
                }
            }
        }
    }
    public void print() {
        for (Map.Entry<String, ArrayList<String>> val : map.entrySet()) {
            System.out.println(val.getKey() + " ---> " + val.getValue());
        }
    }

}
public class Solution {
    public static void main(String[] args) {
        Socialnetwork sn = new Socialnetwork();
        Scanner scan = new Scanner(System.in);
        //int n = scan.nextInt();
        ArrayList<String> a = new ArrayList<>();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(":");
            switch(tokens[0]) {
                case "add":
                sn.addconnections(tokens[1]);
                break;
                case "getconnections":
                sn.getconnections(tokens[1]);
                break;
                case "common":
                sn.common(tokens[1]);
                break;
                case "print":
                sn.print();
                break;
            }
        }
    }
}