import java.util.ArrayList;
import java.util.List;

// This is for q_seq_sum 

public class CombinationsWithOrder {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(7);

        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(8);
        list4.add(9);

        input.add(list1);
        input.add(list2);
        input.add(list3);
        input.add(list4);

        ArrayList<ArrayList<ArrayList<Integer>>> output = generateCombinationsWithOrder(input);

        // Print the output
        for (ArrayList<ArrayList<Integer>> combination : output) {
            System.out.println(combination);
        }
    }

    public static ArrayList<ArrayList<ArrayList<Integer>>> generateCombinationsWithOrder(ArrayList<ArrayList<Integer>> input) {
        ArrayList<ArrayList<ArrayList<Integer>>> output = new ArrayList<>();
        generateCombinationsWithOrderHelper(input, 0, new ArrayList<>(), output);
        return output;
    }

    private static void generateCombinationsWithOrderHelper(ArrayList<ArrayList<Integer>> input, int startIndex, ArrayList<ArrayList<Integer>> current, ArrayList<ArrayList<ArrayList<Integer>>> output) {
        if (startIndex == input.size()) {
            output.add(new ArrayList<>(current));
            return;
        }

        ArrayList<Integer> list = input.get(startIndex);
        for (Integer num : list) {
            ArrayList<ArrayList<Integer>> newCombination = new ArrayList<>(current.size() + 1);
            for (ArrayList<Integer> subList : current) {
                newCombination.add(new ArrayList<>(subList));
            }
            newCombination.add(new ArrayList<>(List.of(num)));
            generateCombinationsWithOrderHelper(input, startIndex + 1, newCombination, output);
        }
    }
}
