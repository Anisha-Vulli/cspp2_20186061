import java.util.*;
import java.io.*;
public class Plagarism {
    static Map<String, Integer> mapor = new TreeMap<>();
    static Map<String, Integer> mapco = new TreeMap<>();
    //static Map<String, ArrayList<Integer>> mapcom = new TreeMap<>();
    Plagarism() {
    }

    public static String format(String buffer) {
        String[] inputarray = buffer.split("\n");
        Integer[] indexarray = new Integer[10];
        for (int i = 0; i < inputarray.length; i++) {
            if (inputarray[i].length() > 5) {
                indexarray[i] = i;
            }
        }

        System.out.println(Arrays.toString(indexarray));
        return null;
        //String input1 = str.replaceAll("[^ A-Za-z0-9]","");
        //String original = input1.toLowerCase();
        // String input2 = scan.nextLine().replaceAll("[^ A-Za-z0-9]","");
        // String copied = input2.toLowerCase();
        //freqdict(original);
        //print();
        //System.out.println(lcscal());
    }
    
    public static void freqdict(String original1) {
        String[] originalarr = original1.split(" ");
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

        // String[] copiedarr = copied1.split(" ");
        // for (String strco : copiedarr) {
        //     int freqco = 1;
        //     for (String strngco : copiedarr) {
        //         if (strco.equals(strngco)) { 
        //             mapco.put(strco,freqco++); 
        //         } else {
        //             if (mapco.get(strngco) == null) {
        //                 mapco.put(strco, 1);
        //            } 
        //         }
        //     }
        // }
    }

    public static Double lcscal() {
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
        distance = (numval) / (Math.sqrt(a1) * Math.sqrt(b1));
        cosine = Math.acos(distance);
        return cosine;
    }
    public static void print() {
        for (Map.Entry<String, Integer> val : mapor.entrySet()) {
            System.out.println(val.getKey() + " ---> " + val.getValue());
        }
        System.out.println("************************************");
        for (Map.Entry<String, Integer> valco : mapco.entrySet()) {
            System.out.println(valco.getKey() + " ---> " + valco.getValue());
        }
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
                sa.add(("D:\\MSIT\\IT\\cspp2_20186061\\cspp2-assignments\\m 23\\Assignment-1\\" + t + "\\" +file.getName()));
            }
        }

        //System.out.println(sa);

        // for (File i : sa) {
        //     FileReader fr = new FileReader(i);
        //     BufferedReader br = new BufferedReader(fr);
        //     String buffer = "";
        //     String s = "";
        //     while (((s = br.readLine()) != null)) {
        //         buffer += s;
        //         System.out.println(buffer);
        //     }
        // }
        try {
            String s1 = "";
            for (String i : sa) {
                File file = new File(i);
                Scanner input = new Scanner(file);
                while (input.hasNextLine()) {
                    s1 += input.nextLine();
                    s1 += " ";
                }
            } 
            format(s1);
            //System.out.println(s1);
        } catch(Exception e) {
            System.out.println(e);
        }

        // format(buffer);
    }
}