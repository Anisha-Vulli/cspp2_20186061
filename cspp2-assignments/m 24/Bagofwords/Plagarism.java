import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.util.TreeMap;
import java.util.Map;
/**
 * Class for plagarism.
 */
public final class Plagarism {
    /**
     * Map declaration.
     */
    private static Map<String, Integer> mapor;
    /**
     * Map declaration.
     */
    private static Map<String, Integer> mapco;
    /**
     * Input arraylist.
     */
    private static ArrayList<String> inputlist = new ArrayList<>();
    /**
     * Values arraylist.
     */
    private static ArrayList<Long> values = new ArrayList<>();
    //static Map<String, ArrayList<Integer>> mapcom = new TreeMap<>();

    /**
     * Constructs the object.
     */
    private Plagarism() {
        //Empty constructor.
    }

    /**
     * appending to list.
     *
     * @param      buffer  The buffer
     */
    public static void format(final String buffer) {
        inputlist.add(buffer);
    }
    /**
     * Sending to make dictionary.
     */
    public static void senddict() {
        //System.out.println(inputlist.size());
        for (int i = 0; i < inputlist.size(); i++) {
            for (int j = 0; j < inputlist.size(); j++) {
                freqdict(inputlist.get(i), inputlist.get(j));
            }
            //System.out.println(inputlist);
        }
    }
    /**
     * Dictionary making.
     *
     * @param      first   The first
     * @param      second  The second
     */
    public static void freqdict(final String first, final String second) {
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
            }
            if (!mapor.containsKey(each)) {
                mapor.put(each, 0);
            }
        }

        wordcal(mapor, mapco);
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
    /**
     * Distance calucluation.
     *
     * @param      mapor  The mapor
     * @param      mapco  The mapco
     */
    public static void wordcal(final Map<String, Integer> mapor,
        final Map<String, Integer> mapco) {
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
        final int hundred = 100;
        distance = ((numval / (Math.sqrt(a1) * Math.sqrt(b1))) * hundred);
        values.add(Math.round(distance));
        //System.out.print(values);
        cosine = Math.acos(distance);
    }
    /**
     * Printing.
     *
     * @param      list  The list
     */
    public static void print(final ArrayList<String> list) {
        //System.out.println(list);
        int n = list.size();
        int j = 0;
        System.out.print("\t\t");
        for (int k = 0; j < n; j++) {
            System.out.print(list.get(k) + "\t");
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

        Long[][] valuesdouble = new Long[n][n];
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                valuesdouble[a][b] = values.get(b);
            }
        }

        float maxpercetmatch = 0;
        String file1 = "", file2 = "";
        for (int c = 0; c < list.size(); c++) {
            for (int d = 0; d < list.size(); d++) {
                if (c < d && maxpercetmatch < valuesdouble[c][d]) {
                    file1 = list.get(c);
                    file2 = list.get(d);
                    maxpercetmatch = valuesdouble[c][d];
                }
            }
        }
        System.out.println("Maximum similarity is between "
                           + file1 + " and " + file2);
    }

    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            ArrayList<String> sa = new ArrayList<>();
            String t = in.nextLine();
            File folder = new File(t);
            File[] listFiles = folder.listFiles();
            ArrayList<String> fnames = new ArrayList<>();
            int j = 0;
            String fname;

            for (File file : listFiles) {
                if (file.isFile()) {
                    sa.add(("D:\\MSIT\\IT\\cspp2_20186061\\cspp2-assignments"
                        + "\\m 24\\Bagofwords\\" + t + "\\" + file.getName()));
                    fnames.add(file.getName());
                }
            }

            if (fnames.size() == 0) {
                System.out.println("Empty directory");
                //break;
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
                    //System.out.println(s1);
                    String input1 = s1.replaceAll("[^A-Za-z0-9 ]", "");
                    String original = input1.toLowerCase();
                    format(original);
                    s1 = " ";
                }
                senddict();
                print(fnames);
            } catch (Exception e) {
                System.out.println(e);
            }

        } catch (Exception e) {
            System.out.println("empty directory");
        }
        // format(buffer);
    }
}
