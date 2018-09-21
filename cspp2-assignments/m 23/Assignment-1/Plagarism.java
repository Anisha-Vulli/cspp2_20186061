import java.util.*;
import java.io.*;
import java.lang.*;
public class Plagarism {
    static Map<String, Integer> mapor;
    static Map<String, Integer> mapco;
    static ArrayList<String> inputlist = new ArrayList<>();
    static ArrayList<Long> values = new ArrayList<>();
    //static Map<String, ArrayList<Integer>> mapcom = new TreeMap<>();
    Plagarism() {

    }

    public static void format(String buffer) {
        //input1 = input1.replaceAll("\\s","");
        inputlist.add(buffer);
        //System.out.println(inputlist);
        // for (int k = 0; k < inputlist.size(); k++) {
        //     lcscal();
        // }
        //print();

        //return null;
    }

    public static void senddict() {
        //System.out.println(inputlist.size());
        for (int i = 0; i < inputlist.size(); i++) {
            for (int j = 0; j < inputlist.size(); j++) {
                freqdict(inputlist.get(i),inputlist.get(j));
            }
            //System.out.println(inputlist);
        }
    }
    
    public static void freqdict(String first, String second) {
        //System.out.println(first);
        mapor = new TreeMap<>();
        mapco = new TreeMap<>();
        String[] originalarr = first.split("\\W");
        for (String each : originalarr) {
            if (mapor.containsKey(each)) {
                mapor.put(each, mapor.get(each) + 1);
            } else {
                mapor.put(each, 1);
            } 
            if (!mapco.containsKey(each)) {
                mapco.put(each, 0);
            }
        }
        //System.out.println(mapor);
        //     for (String str : originalarr) {
        //         int freq = 1;
        //         for (String strng : originalarr) {
        //             if (str.equals(strng)) { 
        //                 mapor.put(str,freq++); 
        //             } else {
        //                 if (mapor.get(strng) == null) {
        //                     mapor.put(str, 1);
        //                } 
        //             }
        //         }
        //         if (!mapco.containsKey(str)){
        //             mapco.put(str,0);
        //         }
        //     }

        // //System.out.println(mapor);
        String[] copiedarr = second.split("\\W");
        for (String each : copiedarr) {
            if (mapco.containsKey(each)) {
                mapco.put(each, mapco.get(each) + 1);
            } else {
                mapco.put(each, 1);
            } if (!mapor.containsKey(each)) {
                mapor.put(each, 0);
            }
        }

        lcscal(mapor, mapco);
        //System.out.println(mapco);
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
        //     if (!mapor.containsKey(strco)){
        //             mapor.put(strco,0);
        //         }
        // }

        
    }

    public static void lcscal(Map<String, Integer> mapor, Map<String, Integer> mapco) {
        //int distance = 0;
        Double numval = 0.0;
        Double distance = 0.0;
        Double cosine = 0.0;

        //System.out.println(mapor.size());
        // System.out.println(mapco.size());
        
        // for (Map.Entry<String, Integer> val : mapor.entrySet()) {
        //     for (Map.Entry<String, Integer> valco : mapco.entrySet()) {
        //         if (val.getKey().equals(valco.getKey())) {
        //             numval += val.getValue() * valco.getValue();           
        //         }
        //     }   
        // }
        
        // for (Map.Entry<String, Integer> val : mapor.entrySet()) {
        //     a1 += Math.pow(val.getValue(), 2);
        // }

        Double a1 = 0.0;
        Double b1 = 0.0;
        // for (Map.Entry<String, Integer> valco : mapco.entrySet()) {
        //     b1 += Math.pow(valco.getValue(), 2);   
        // }
        
        for (String str : mapor.keySet()) {
            a1 += Math.pow(mapor.get(str), 2);
            b1 += Math.pow(mapco.get(str), 2);
            numval += mapor.get(str) * mapco.get(str);
        }
        //System.out.println(numval);
        //System.out.println(a1);
        //System.out.println(b1);
        // distance = 100 * (numval / (Math.sqrt(a1) * Math.sqrt(b1)));
        distance = ((numval / (Math.sqrt(a1) * Math.sqrt(b1))) * 100);
        values.add(Math.round(distance));
        //System.out.print(values);
        cosine = Math.acos(distance);
    }
    public static void print(ArrayList<String> list) {
        //System.out.println(list);
        int n = list.size();
        int j = 0;
        for (int k = 0; j < n; j++) {
            System.out.print("\t    ");
            System.out.print(list.get(k));
            k++;
        }
        int p = 0;
        for (int i = 0; i < values.size(); i++) {
            if (j == n) {
                j = 0;
                System.out.println("");
                System.out.print(list.get(p));
                p++;
            }
            System.out.print("\t" + values.get(i) + "\t");
            j++;
        }
    }

}