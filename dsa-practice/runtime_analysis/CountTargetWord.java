package runtime_analysis;
import java.io.*;
import java.util.*;

class CountTargetWord {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        String target = sc.nextLine();

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        int count = 0;

        while((line = br.readLine()) != null) {
            String[] words = line.split("\\s+");
            for(int i = 0; i < words.length; i++) {
                if(words[i].equals(target)) {
                    count++;
                }
            }
        }

        br.close();
        System.out.println(count);
    }
}

