import java.util.*;
import java.io.*;
public class Plagarism {
    static Map<String, Integer> mapor = new TreeMap<>();
    static Map<String, Integer> mapco = new TreeMap<>();
    static ArrayList<String> inputlist = new ArrayList<>();
    static ArrayList<Long> values = new ArrayList<>();
    //static Map<String, ArrayList<Integer>> mapcom = new TreeMap<>();
    Plagarism() {
    }

    public static void format(String buffer) {
        String input1 = buffer.replaceAll("[^ A-Za-z0-9]","");
        String original = input1.toLowerCase();
        inputlist.add(original);
        //System.out.println(inputlist);
        // for (int k = 0; k < inputlist.size(); k++) {
        //     lcscal();
        // }
        //print();

        //return null;
    }

    public static void senddict() {
        //System.out.println(inputlist);
        for (int i = 0; i < inputlist.size(); i++) {
            for (int j = 0; j < inputlist.size(); j++) {
                freqdict(inputlist.get(i),inputlist.get(j));
                lcscal();
            }
            //System.out.println(inputlist.get(i));
        }
    }
    
    public static void freqdict(String first, String second) {
        //System.out.println(first);
        //System.out.println(second);
        //System.out.println(original1);
        mapor = new TreeMap<>();
        mapco = new TreeMap<>();
        String[] originalarr = first.split(" ");
            for (String str : originalarr) {
                int freq = 1;
                for (String strng : originalarr) {
                    if (str.equals(strng)) { 
                        mapor.put(str,freq++); 
                    } else {
                        if (mapor.get(strng) == null) {
                            mapor.put(str, 1);
                       } 
                    }
                }
            }

        String[] copiedarr = second.split(" ");
        for (String strco : copiedarr) {
            int freqco = 1;
            for (String strngco : copiedarr) {
                if (strco.equals(strngco)) { 
                    mapco.put(strco,freqco++); 
                } else {
                    if (mapco.get(strngco) == null) {
                        mapco.put(strco, 1);
                   } 
                }
            }
        }
    }

    public static void lcscal() {
        Double distance = 0.0;
        Double numval = 0.0;
        Double cosine = 0.0;
        for (Map.Entry<String, Integer> val : mapor.entrySet()) {
            for (Map.Entry<String, Integer> valco : mapco.entrySet()) {
                if (val.getKey().equals(valco.getKey())) {
                    numval += (val.getValue() * valco.getValue());           
                }
            }   
        }
        Double a1 = 0.0;
        for (Map.Entry<String, Integer> val : mapor.entrySet()) {
            a1 += Math.pow(val.getValue(), 2);
        }

        Double b1 = 0.0;
        for (Map.Entry<String, Integer> valco : mapco.entrySet()) {
            b1 += Math.pow(valco.getValue(), 2);   
        }
        distance = 100 * (numval / (Math.sqrt(a1) * Math.sqrt(b1)));
        values.add(Math.round(distance));
        //System.out.print(values);
        cosine = Math.acos(distance);
    }
    public static void print() {
        System.out.println(values);
        int j = 0;
        for (int i = 0; i < values.size(); i++) {
            if (j == 5) {
                j = 0;
                System.out.println();
            } else {
                System.out.print(values.get(i) + " ");
                j++;
            }
            //System.out.println();
        }
        // for (Map.Entry<String, Integer> val : mapor.entrySet()) {
        //     System.out.println(val.getKey() + " ---> " + val.getValue());
        // }
        // System.out.println("*******************");
        // for (Map.Entry<String, Integer> val : mapco.entrySet()) {
        //     System.out.println(val.getKey() + " ---> " + val.getValue());
        // }
        // System.out.println("-------------------------------");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> sa = new ArrayList<>();
        String t = in.nextLine();
        File folder = new File(t);
        File[] listFiles = folder.listFiles();
        ArrayList<String> fnames= new ArrayList<>();
        int j =0;
        String fname;

        for(File file: listFiles){
            if (file.isFile()) {
                sa.add(("D:\\MSIT\\IT\\cspp2_20186061\\cspp2-assignments\\Plagarism\\" + t + "\\" +file.getName()));
            }
        }
        try {
            String s1 = "";
            for (String i : sa) {
                File file = new File(i);
                Scanner input = new Scanner(file);
                while (input.hasNextLine()) {
                    s1 += input.nextLine();
                }
                format(s1);
                s1 = "";
            }
            senddict();
            print();
        } catch(Exception e) {
            System.out.println(e);
        }

        // format(buffer);
    }
}