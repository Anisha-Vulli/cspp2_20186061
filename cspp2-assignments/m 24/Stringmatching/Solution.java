import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.util.TreeMap;
import java.util.Map;

public final class Solution {
    private Solution() {

    }

    private static ArrayList<String> inputlist = new ArrayList<>();

    public static void addingtoarray(String filesent) {
        inputlist.add(filesent);
    }

    public static int lcs(final String doc1, final String doc2) {
        int lcsmax = 0, lcs = 0, temp = 0;
        for (int indexi = 0; indexi < doc1.length() - 1; indexi++) {
            int indexj = 0;
            while (indexj < doc2.length() - 1) {
                temp = indexi;
                lcs = 0;
                if (doc1.charAt(temp) == (doc2.charAt(indexj))
                        && doc1.charAt(temp) != ' ') {
                    while (doc1.charAt(temp) == (doc2.charAt(indexj)) && indexj
                            < doc2.length() - 1 && temp < doc1.length() - 1) {
                        lcs++;
                        indexj++;
                        temp++;
                    }
                    if (lcs > lcsmax) {
                        lcsmax = lcs;
                    }
                } else {
                    indexj++;
                }
            }
        }
        return lcsmax + 1;
    }

    public static void lcscalu(ArrayList<String> filenames) {
        //System.out.println(inputlist);
        float[][] stringmatch = new float[filenames.size()][filenames.size()];
        for (int i = 0; i < filenames.size(); i++) {
            for (int j = 0; j < filenames.size(); j++) {
                if (i == j) {
                    stringmatch[i][j] = 100;
                } else {
                    //System.out.println("BAWHHAAA");
                    int lcsmax = 0;
                    if (!(inputlist.get(i).equals("") || inputlist.get(j).equals(""))) {
                        if (inputlist.get(i).length() > inputlist.get(j).length()) {
                            lcsmax = lcs(inputlist.get(i), inputlist.get(j));
                        } else {
                            lcsmax = lcs(inputlist.get(i), inputlist.get(j));
                        }
                    }
                    //System.out.println(inputlist.get(i).length());
                    stringmatch[i][j] = Math.round((lcsmax * 200) / (inputlist.get(i).length() + inputlist.get(j).length()));
                }
            }
        }

        for (int i = 0; i < stringmatch.length; i++) {
            System.out.println(Arrays.toString(stringmatch[i]));
        }
    }

    public static void main(String[] args) {
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
                        + "\\m 24\\Stringmatching\\" + t + "\\" + file.getName()));
                    fnames.add(file.getName());
                }
            }

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
                    addingtoarray(original);
                    s1 = " ";
                }
                lcscalu(fnames);
            } catch (Exception e) {
                System.out.println(e);
            }
            
        //     try {
        //     int filecount = 0;
        //     for (File file : listFiles) {
        //         Scanner filescan = new Scanner(file);
        //         String str = "";
        //         while(filescan.hasNextLine()) {
        //             str += filescan.nextLine() + " ";
        //         }
        //         // System.out.println(str);
        //         String input1 = s1.replaceAll("[^A-Za-z0-9 ]", "");
        //         String original = input1.toLowerCase();
        //         addingtoarray(original);
        //     }
        //     lcscalu(fnames);
        //     // System.out.println(Arrays.toString(strlist));
        // } catch (Exception e) {
        //     System.out.println("file not found");
        // }

        } catch (Exception e) {
            System.out.println("Empty Directory");
        }
        //format(buffer);
    }
}

