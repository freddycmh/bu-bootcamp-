import java.io.*;
import java.util.ArrayList;

public class GradeAnalyzer {

    public static void main(String[] args) {
        String inputFile = "scores.txt";
        String outputFile = "report.txt";

        // Step 1: read scores from file
        ArrayList<Integer> scores = readScores(inputFile);

        // Safety check if no data was successfully loaded
        if (scores.isEmpty()) {
            System.out.println("No valid scores to analyze.");
            return;
        }

        // Step 2: calculate statistics
        double avg = calculateAverage(scores);
        
        // Find highest and lowest
        int high = scores.get(0);
        int low = scores.get(0);
        for (int score : scores) {
            if (score > high) high = score;
            if (score < low) low = score;
        }

        // Step 3: write and print report
        writeReport(scores, avg, high, low, outputFile);
    }

    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    int score = Integer.parseInt(line.trim()); // trim removes extra spaces
                    if (score >= 0 && score <= 100) {
                        scores.add(score);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
        return scores; 
    }

    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores == null || scores.isEmpty()) {
            return 0.0;
        }
        
        double sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return sum / scores.size();
    }

    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores, double avg, int high, int low, String outputFile) {
        // Build the report content
        String report = "--- Grade Report ---\n" +
                        "Total Students: " + scores.size() + "\n" +
                        "Average Score:  " + String.format("%.2f", avg) + "\n" +
                        "Highest Score:  " + high + "\n" +
                        "Lowest Score:   " + low + "\n";

        // Print to console
        System.out.print(report);

        // Write to file using BufferedWriter
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(report);
            System.out.println("\nReport successfully saved to " + outputFile);
        } catch (IOException e) {
            System.out.println("Could not write report to file: " + e.getMessage());
        }
    }
}
