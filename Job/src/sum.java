import java.util.ArrayList;
// sum

public class sum {
    
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        //list1.add(2);
       // list1.add(3);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(4);
       //list2.add(5);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(6);
       // list3.add(7);

        input.add(list1);
        input.add(list2);
        input.add(list3);

        ArrayList<ArrayList<Integer>> possibleCombinations = possibleCombinations(input);
        ArrayList<ArrayList<Integer>> possibleSchedules = new ArrayList<>();
        ArrayList<ArrayList<Integer>> possiblePermutations = new ArrayList<>();
        for (ArrayList<Integer> possibleCombination : possibleCombinations) {
            //System.out.println(permutationOrCombination);
        	possiblePermutations = generateSchedulePermutations(possibleCombination);
        	for (ArrayList<Integer> possiblePermutation : possiblePermutations) {
        		possibleSchedules.add(possiblePermutation);
                //System.out.println(possiblePermutations);
            }
        	
        }
        
        System.out.println(possibleSchedules);
        System.out.println(possibleSchedules.size());
    }

    public static ArrayList<ArrayList<Integer>> possibleCombinations(ArrayList<ArrayList<Integer>> input) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        possibleCombinationsHelper(input, 0, new ArrayList<>(), output);
        return output;
    }

    private static void possibleCombinationsHelper(ArrayList<ArrayList<Integer>> input, int listIndex, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> output) {
        if (listIndex == input.size()) {
            output.add(new ArrayList<>(current));
            return;
        }

        ArrayList<Integer> currentList = input.get(listIndex);
        for (int i = 0; i < currentList.size(); i++) {
            current.add(currentList.get(i));
            possibleCombinationsHelper(input, listIndex + 1, current, output);
            current.remove(current.size() - 1);
        }

        // Skip the current list
        possibleCombinationsHelper(input, listIndex + 1, current, output);
    }
    public static ArrayList<ArrayList<Integer>> generateSchedulePermutations(ArrayList<Integer> input) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        schedulePermutationsHelper(input, new ArrayList<>(), output);
        return output;
    }

    private static void schedulePermutationsHelper(ArrayList<Integer> input, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> output) {
        if (input.isEmpty()) {
            output.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < input.size(); i++) {
            ArrayList<Integer> cloneInput = new ArrayList<>(input);
            ArrayList<Integer> cloneCurrent = new ArrayList<>(current);

            int num = cloneInput.remove(i);
            cloneCurrent.add(num);
            
            schedulePermutationsHelper(cloneInput, cloneCurrent, output);
        }
    }
   
}
