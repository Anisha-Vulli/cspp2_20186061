class Solution {
    Solution() {
        
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
                fnames.add(file.getName());
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
                //System.out.println(s1);
                String input1 = s1.replaceAll("[^A-Za-z0-9 ]","");
                String original = input1.toLowerCase();
                format(original);
                s1 = " ";
            }
            senddict();
            print(fnames);
        } catch(Exception e) {
            System.out.println(e);
        }

        // format(buffer);
    }
}