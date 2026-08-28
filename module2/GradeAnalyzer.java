import java.io.*;
import java.util.ArrayList;

public class GradeAnalyzer {

    public static void main(String[] args) {
        String inputFile = "scores.txt";
        String outputFile = "report.txt";

        // Step 1: read scores from file
        ArrayList<Integer> scores = readScores(inputFile);

        // Step 2: calculate statistics
        if (scores.isEmpty()) {
            System.out.println("No valid scores found in " + inputFile + ". Exiting.");
            return;
        }

        double avg = calculateAverage(scores);

        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;
        for (int score : scores) {
            if (score > highest) highest = score;
            if (score < lowest) lowest = score;
        }

        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;
        for (int score : scores) {
            if (score >= 90)      countA++;
            else if (score >= 80) countB++;
            else if (score >= 70) countC++;
            else if (score >= 60) countD++;
            else                  countF++;
        }

        // Step 3: write and print report
        writeReport(scores, avg, highest, lowest,
                    countA, countB, countC, countD, countF, outputFile);
    }

    // Returns a list of valid integer scores read from filename.
    // Skips blank lines and prints a warning for non-numeric lines.
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                try {
                    scores.add(Integer.parseInt(line));
                } catch (NumberFormatException e) {
                    System.out.println("Warning: skipping invalid line: \"" + line + "\"");
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return scores;
    }

    // Returns the average of the scores list, or 0.0 if empty.
    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores.isEmpty()) return 0.0;
        double total = 0;
        for (int score : scores) {
            total += score;
        }
        return total / scores.size();
    }

    // Prints the report to the terminal and writes it to outputFile.
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   int countA, int countB, int countC, int countD, int countF,
                                   String outputFile) {
        String[] lines = {
            "=== Grade Analysis Report ===",
            String.format("Total scores processed:  %d", scores.size()),
            "",
            String.format("Average score:  %.2f", avg),
            String.format("Highest score:  %d", high),
            String.format("Lowest score:   %d", low),
            "",
            "Grade distribution:",
            String.format("  A (90-100):   %d", countA),
            String.format("  B (80-89):    %d", countB),
            String.format("  C (70-79):    %d", countC),
            String.format("  D (60-69):    %d", countD),
            String.format("  F (below 60): %d", countF)
        };

        for (String line : lines) {
            System.out.println(line);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("\nReport written to " + outputFile);
        } catch (IOException e) {
            System.out.println("Error writing report: " + e.getMessage());
        }
    }
}
