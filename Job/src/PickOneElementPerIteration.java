
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PickOneElementPerIteration {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(5);
        numbers.add(15);
        numbers.add(8);
        numbers.add(20);
        numbers.add(3);

        pickOneElementPerIteration(numbers);
    }

    public static void pickOneElementPerIteration(List<Integer> numbers) {
        Iterator<Integer> iterator = numbers.iterator();

        while (iterator.hasNext()) {
            Integer element = iterator.next();
            System.out.println("Picked element: " + element);
            iterator.remove();
        }
    }
}
