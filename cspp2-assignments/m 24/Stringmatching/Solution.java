// import java.util.Scanner;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.io.File;
// import java.util.TreeMap;
// import java.util.Map;

// public final class Solution {
// 	private Solution() {

// 	}

// 	private static ArrayList<String> inputlist = new ArrayList<>();

// 	public static void addingtoarray(String filesent) {
// 		inputlist.add(filesent);
// 	}

// 	public static void lcscalu(ArrayList<String> filenames) {
// 		float[][] stringmatch = new float[filenames.size()][filenames.size()];
// 		for (int i = 0; i < filenames.size(); i++) {
// 			for (int j = 0; j < filenames.size(); j++) {
// 				if (i == j) {
// 					stringmatch[i][j] = 100;
// 				} else {
// 					int lcs = 0; int lcstemp = 0;
// 					for (String wordi : inputlist.get(i).split(" ")) {
// 						for (String wordj : inputlist.get(j).split(" ")) {
// 							if (wordi.equals(wordj) && wordi.length() > lcs) {
// 								lcs = wordi.length();
// 							}
// 						}
// 					}
// 					stringmatch[i][j] = (lcs * 200) / (inputlist.get(i).length() + inputlist.get(j).length());
// 				}
// 			}
// 		}

// 		for (int i = 0; i < stringmatch.length; i++) {
// 			System.out.println(Arrays.toString(stringmatch[i]));
// 		}
// 	}

// 	public static void main(String[] args) {
// 		Scanner in = new Scanner(System.in);
//         try {
//             ArrayList<String> sa = new ArrayList<>();
//             String t = in.nextLine();
//             File folder = new File(t);
//             File[] listFiles = folder.listFiles();
//             ArrayList<String> fnames = new ArrayList<>();
//             int j = 0;
//             String fname;

//             for (File file : listFiles) {
//                 if (file.isFile()) {
//                     sa.add(("D:\\MSIT\\IT\\cspp2_20186061\\cspp2-assignments"
//                         + "\\m 24\\Stringmatching\\" + t + "\\" + file.getName()));
//                     fnames.add(file.getName());
//                 }
//             }

//             // try {
//             //     String s1 = "";
//             //     for (String i : sa) {
//             //         File file = new File(i);
//             //         Scanner input = new Scanner(file);
//             //         while (input.hasNextLine()) {
//             //             s1 += input.nextLine();
//             //             s1 += " ";
//             //         }
//             //         //System.out.println(s1);
//             //         String original = s1.trim();
//             //         addingtoarray(original);
//             //         s1 = " ";
//             //     }
//             //     lcscalu(fnames);
//             // } catch (Exception e) {
//             //     System.out.println(e);
//             // }
            
//             try {
// 			int filecount = 0;
// 			for (File file : listFiles) {
// 				Scanner filescan = new Scanner(file);
// 				String str = "";
// 				while(filescan.hasNextLine()) {
// 					str += filescan.nextLine() + " ";
// 				}
// 				// System.out.println(str);
// 				String original = str.trim();
// 				addingtoarray(original);
// 			}
// 			lcscalu(fnames);
// 			// System.out.println(Arrays.toString(strlist));
// 		} catch (Exception e) {
// 			System.out.println("file not found");
// 		}

//         } catch (Exception e) {
//             System.out.println("empty directory");
//         }
//         // format(buffer);
//     }
// }


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String foldername = scan.next();
		File folder = new File(foldername);
		File[] filelist = folder.listFiles();
		String[] strlist = new String[filelist.length];
		// System.out.println(Arrays.toString(filelist));
		try {
			int filecount = 0;
			for (File file : filelist) {
				Scanner filescan = new Scanner(file);
				String str = "";
				while(filescan.hasNextLine()) {
					str += filescan.nextLine() + " ";
				}
				// System.out.println(str);
				strlist[filecount++] = str.trim();
			}
			// System.out.println(Arrays.toString(strlist));
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		}

		float[][] matchpercentmat = new float[filelist.length][filelist.length];
		for (int i = 0; i < filelist.length; i++) {
			for (int j = 0; j < filelist.length; j++) {
				if (i == j) {
					matchpercentmat[i][j] = 100;
				} else {
					int lcs = 0 , lcstemp = 0;
					// System.out.println(strlist[i] + "\n" + strlist[j]);
					for (String eachwordi : strlist[i].split(" ")) {
						for (String eachwordj : strlist[j].split(" ")) {
							if (eachwordi.equals(eachwordj) && eachwordi.length() > lcs) {
								lcs = eachwordi.length();
							}
						}
					}
					matchpercentmat[i][j] = (lcs * 200) / (strlist[i].length() + strlist[j].length());
				}
			}
		}
		// System.out.println(Arrays.toString(matchpercentmat));
		for (int i = 0; i < matchpercentmat.length; i++) {
			System.out.println(Arrays.toString(matchpercentmat[i]));
		}
	}
}

