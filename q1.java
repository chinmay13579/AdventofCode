import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MaxCaloriesFinder {

    public static int findMaxCalories(String[] elvesInput) {
        int maxCal = 0;
        int currentCal = 0;

        for (String line : elvesInput) {
            if (!line.trim().isEmpty()) {
                currentCal += Integer.parseInt(line);
            } else {
                if (currentCal > maxCal) {
                    maxCal = currentCal;
                }
                currentCal = 0;  // Reset the currentCalories for the next Elf
            }
        }

        // Check one last time in case the last Elf has the most Calories
        if (currentCal > maxCal) {
            maxCal = currentCal;
        }

        return maxCal;
    }

    public static void main(String[] args) {
        // Read input from a text file
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            StringBuilder inputBuilder = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                inputBuilder.append(line).append(System.lineSeparator());
            }

            // Split the input into lines
            String[] lines = inputBuilder.toString().split(System.lineSeparator());

            // Find and print the result
            int result = findMaxCalories(lines);
            System.out.println("Total Calories carried by the Elf with the most Calories: " + result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
