import java.util.*;
import java.util.stream.Stream;
public class test {

	public static void main(String[] args) {
		 ArrayList<Integer> input = new ArrayList<>();
	        input.add(1);
	        input.add(2);
	        input.add(3);
	        input.add(4);
	        input.add(5);
	        input.add(6);
	        

	        ArrayList<ArrayList<Integer>> output = generateCombinations(input);
	        
	        // Print the combinations
	        for (ArrayList<Integer> combination : output) {
	            System.out.println(combination);
	        }
	    }

	    public static ArrayList<ArrayList<Integer>> generateCombinations(ArrayList<Integer> input) {
	        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
	        generateCombinationsHelper(input, 0, new ArrayList<>(), output);
	        System.out.println(output.size());
	        return output;
	    }

	    private static void generateCombinationsHelper(ArrayList<Integer> input, int startIndex, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> output) {
	        output.add(new ArrayList<>(current));

	        for (int i = startIndex; i < input.size(); i++) {
	            current.add(input.get(i));
	            generateCombinationsHelper(input, i + 1, current, output);
	            current.remove(current.size() - 1);
	        }

	}

}
