import java.util.ArrayList;
 
// all

public class all {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
       // list1.add(2);
        //list1.add(3);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(4);
        //list2.add(5);
        //list2.add(6);
        
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(7);
         //list3.add(8);
         //list3.add(9);
       
         ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(10);
        

        input.add(list1);
        input.add(list2);
        input.add(list3);
        //input.add(list4);

        ArrayList<ArrayList<Integer>> possibleCombinations = generateCombinationsWithOrder(input);
        //ArrayList<ArrayList<Integer>> output = generateCombinationsWithOrder(input);
        ArrayList<ArrayList<Integer>> possibleSchedules = new ArrayList<>();
        ArrayList<ArrayList<Integer>> possiblePermutations = new ArrayList<>();
        // Print the output
        for (ArrayList<Integer> possibleCombination : possibleCombinations) {
            //System.out.println(permutationOrCombination);
        	possiblePermutations = generateSchedulePermutations(possibleCombination);
        	for (ArrayList<Integer> possiblePermutation : possiblePermutations) {
        		possibleSchedules.add(possiblePermutation);
                //System.out.println(possibleSchedules);
            }
        	
        }
        
        System.out.println(possibleSchedules);
        System.out.println(possibleSchedules.size());
    
    }

    public static ArrayList<ArrayList<Integer>> generateCombinationsWithOrder(ArrayList<ArrayList<Integer>> input) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        generateCombinationsWithOrderHelper(input, 0, current, output);
        return output;
    }

    private static void generateCombinationsWithOrderHelper(ArrayList<ArrayList<Integer>> input, int startIndex, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> output) {
        if (startIndex == input.size()) {
            output.add(new ArrayList<>(current));
            return;
        }

        ArrayList<Integer> list = input.get(startIndex);
        for (Integer num : list) {
            current.add(num);
            generateCombinationsWithOrderHelper(input, startIndex + 1, current, output);
            current.remove(current.size() - 1);
        }
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
