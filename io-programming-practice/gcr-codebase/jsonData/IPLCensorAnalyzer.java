package jsonData;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class IPLCensorAnalyzer {

    static void censorJSON(String input, String output) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(input));
        BufferedWriter bw = new BufferedWriter(new FileWriter(output));

        String line;
        while((line = br.readLine()) != null){
            if (line.contains("team") || line.contains("winner")) {
                line = maskTeam(line);
            }
            if (line.contains("player_of_match")) {
                line = line.replaceAll(":\\s*\".*\"", ": \"REDACTED\"");
            }

            bw.write(line);
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    static void censorCSV(String input, String output) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(input));
        BufferedWriter bw = new BufferedWriter(new FileWriter(output));

        String line;
        bw.write(br.readLine());
        bw.newLine();

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            data[1] = maskTeamName(data[1]);
            data[2] = maskTeamName(data[2]);
            data[5] = maskTeamName(data[5]);
            data[6] = "REDACTED";

            bw.write(String.join(",", data));
            bw.newLine();
        }

        br.close();
        bw.close();

    }

    static String maskTeam(String line) {

        int start = line.indexOf(":") + 2;
        int end = line.lastIndexOf("\"");
        String team = line.substring(start, end);
        return line.replace(team, maskTeamName(team));
    }

    static String maskTeamName(String team) {

        String firstWord = team.split(" ")[0];
        return firstWord + " ***";
    }

    public static void main(String[] args) throws Exception {

        censorJSON("C:\\BridgeLab-Training\\ipl.json", "ipl_censored.json");
        censorCSV("C:\\BridgeLab-Training\\ipl.csv", "ipl_censored.csv");

        System.out.println("Censorship completed.");
    }
}
