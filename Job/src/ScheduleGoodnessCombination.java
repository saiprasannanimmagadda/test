import java.util.ArrayList;
import java.util.List;

public class ScheduleGoodnessCombination {
    public static void main(String[] args) {
        List<Float> Goodness = new ArrayList<>();
        List<String> possibleSchedules = new ArrayList<>();

        // Adding float values to the Goodness list
        for (int i = 0; i < 5; i++) {
            float floatValue = i * 1.5f; // You can use any value here based on your requirements
            Goodness.add(floatValue);
        }

        // Adding the possibleSchedules list to the schedules list five times
        List<List<String>> schedules = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            schedules.add(new ArrayList<>(possibleSchedules));
        }

        // Combine and return schedules and Goodness
        Pair<List<List<String>>, List<Float>> combinedData = combineSchedulesAndGoodness(schedules, Goodness);

        // Retrieve combined schedules and Goodness
        List<List<String>> combinedSchedules = combinedData.getFirst();
        List<Float> combinedGoodness = combinedData.getSecond();

        // Printing the combined schedules and Goodness lists
        System.out.println("Combined Schedules: " + combinedSchedules);
        System.out.println("Combined Goodness: " + combinedGoodness);
        
    }

    public static <T, U> Pair<List<T>, List<U>> combineSchedulesAndGoodness(List<T> schedules, List<U> Goodness) {
        return new Pair<>(schedules, Goodness);
    }
}

class Pair<T, U> {
    private final T first;
    private final U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }
}
