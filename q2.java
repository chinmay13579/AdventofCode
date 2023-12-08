import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TopThreeCaloriesFinder {

    public static int findTopThreeCalories(String[] elvesInput) {
        List<Integer> elvesCalories = new ArrayList<>();

        int currentCal = 0;
        for (String line : elvesInput) {
            if (!line.trim().isEmpty()) {
                currentCal += Integer.parseInt(line);
            } else {
                elvesCalories.add(currentCal);
                currentCal = 0;
            }
        }
        elvesCalories.add(currentCal);

        // Sort the list in descending order
        Collections.sort(elvesCalories, Collections.reverseOrder());

        // Calculate the sum of Calories for the top three Elves
        int topThreeSum = 0;
        for (int i = 0; i < Math.min(3, elvesCalories.size()); i++) {
            topThreeSum += elvesCalories.get(i);
        }

        return topThreeSum;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            StringBuilder inputBuilder = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                inputBuilder.append(line).append(System.lineSeparator());
            }

            String[] lines = inputBuilder.toString().split(System.lineSeparator());

            int result = findTopThreeCalories(lines);
            System.out.println("Total Calories carried by the top three Elves: " + result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
