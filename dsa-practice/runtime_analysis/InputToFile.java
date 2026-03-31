package runtime_analysis;
import java.io.*;

class InputToFile {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileWriter fw = new FileWriter("output.txt");

        String line;
        while(true) {
            line = br.readLine();
            if(line.equals("exit")) {
                break;
            }
            fw.write(line);
            fw.write("\n");
        }

        fw.close();
        br.close();
    }
}

