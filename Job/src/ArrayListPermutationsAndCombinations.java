import java.util.ArrayList;
import java.util.HashSet;

public class ArrayListPermutationsAndCombinations {
    
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);

        ArrayList<ArrayList<Integer>> permutationsAndCombinations = generatePermutationsAndCombinations(input);
        
        // Print the permutations and combinations
        for (ArrayList<Integer> permutationOrCombination : permutationsAndCombinations) {
            System.out.println(permutationOrCombination);
        }
    }

    public static ArrayList<ArrayList<Integer>> generatePermutationsAndCombinations(ArrayList<Integer> input) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        generatePermutationsAndCombinationsHelper(input, new ArrayList<>(), output, new HashSet<>());
        return output;
    }

    private static void generatePermutationsAndCombinationsHelper(ArrayList<Integer> input, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> output, HashSet<ArrayList<Integer>> visited) {
    	
    	if (current.size() > 0) {
            if (!visited.contains(current)) {
            	
                output.add(new ArrayList<>(current));
                visited.add(new ArrayList<>(current));
            }
        }

        for (int i = 0; i < input.size(); i++) {
            int num = input.remove(i);         
            current.add(num);
            generatePermutationsAndCombinationsHelper(input, current, output, visited);
            current.remove(current.size() - 1);
            input.add(i, num);
                 
        }
    }
}
