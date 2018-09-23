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

    public static void lcscalu(ArrayList<String> filenames) {
        //System.out.println(inputlist);
        float[][] stringmatch = new float[filenames.size()][filenames.size()];
        for (int i = 0; i < filenames.size(); i++) {
            for (int j = 0; j < filenames.size(); j++) {
                if (i == j) {
                    stringmatch[i][j] = 100;
                } else {
                    int lcs = 0; int lcstemp = 0;
                    for (String wordi : inputlist.get(i).split(" ")) {
                        for (String wordj : inputlist.get(j).split(" ")) {
                            if (wordi.equals(wordj) && wordi.length() > lcs) {
                                lcs = wordi.length();
                            }
                        }
                    }
                    stringmatch[i][j] = (lcs * 200) / (inputlist.get(i).length() + inputlist.get(j).length());
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
            System.out.println("empty directory");
        }
        //format(buffer);
    }
}

