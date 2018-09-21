import java.io.FileReader;
import java.lang.*;
import java.io.*;
import java.util.*;
/**
 * Class for plagrism.
 */
class Plagrism {
	/**
     * plagrism percentage calculation.
     *
     * @param      freq1   The frequency
     * @param      freq2  The frequency 2
     *
     * @return     { description_of_the_return_value }
     */
    public static int cal(TreeMap<String, Integer> freq1,
                                   TreeMap<String, Integer> freq2) {
    	//System.out.println(freq1.size());
        int sum1 = 0 ;
        int sum2 = 0;
        int dotproduct = 0;
        for (String each : freq1.keySet()) {
            sum1 += freq1.get(each) * freq1.get(each);
            sum2 += freq2.get(each) * freq2.get(each);
            dotproduct += freq1.get(each) * freq2.get(each);

        }

        //System.out.println("dot" + "" + dotproduct);
        return ((int)((dotproduct / (Math.sqrt(sum1) * Math.sqrt(sum2))) * 100));
    }
    /**
     * this is the main function.
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        File testcase = new File(input.nextLine());
        File[] testfiles = testcase.listFiles();
        for (File name : testfiles) {
            System.out.print("\t" + name.toString().split("\\\\")[1]);
        }
        for (File file : testfiles) {
            String input1 = file.getAbsolutePath();
            System.out.println();
            System.out.print(file.toString().split("\\\\")[1] + "\t");
            for (File next : testfiles) {
                String input2 = next.getAbsolutePath();
                try {
                    FileReader file1 = new FileReader(input1);
                    FileReader file2 = new FileReader(input2);
                    BufferedReader br1 = new BufferedReader(file1);
                    BufferedReader br2 = new BufferedReader(file2);
                    TreeMap<String, Integer> freq1 = new TreeMap<>();
                    TreeMap<String, Integer> freq2 = new TreeMap<>();
                    String s;
                    while ((s = br1.readLine()) != null ) {
                        String [] line = s.replaceAll("[^a-zA-Z0-9_ ]", "").toLowerCase().split(" ");
                        for (String each : line) {
                            if (freq1.containsKey(each)) {
                                freq1.put(each, freq1.get(each) + 1);

                            } else {
                                freq1.put(each, 1);
                            }
                            if (!freq2.containsKey(each)) {
                                freq2.put(each, 0);

                            }

                        }

                    }

                    while ((s = br2.readLine()) != null ) {
                        String [] line = s.replaceAll("[^a-zA-Z0-9_ ]", "").toLowerCase().split(" ");

                        for (String each : line) {
                            if (freq2.containsKey(each)) {
                                freq2.put(each, freq2.get(each) + 1);

                            } else {
                                freq2.put(each, 1);
                            }
                            if (!freq1.containsKey(each)) {
                                freq1.put(each, 0);

                            }

                        }
                    }
                    System.out.print(cal(freq1, freq2) + "\t");
                } catch (FileNotFoundException e) {
                    System.out.println("File doesnot exists");

                } catch (IOException e) {
                    System.out.println("Invalid Input");

                }

            }

        }
        System.out.println();

    }
    

}