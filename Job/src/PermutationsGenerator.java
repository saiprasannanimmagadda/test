import java.util.ArrayList;

public class PermutationsGenerator {

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);

        ArrayList<ArrayList<Integer>> permutations = generatePermutations(input);
        
        // Print the permutations
        for (ArrayList<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }

    public static ArrayList<ArrayList<Integer>> generatePermutations(ArrayList<Integer> input) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        generatePermutationsHelper(input, new ArrayList<>(), output);
        return output;
    }

    private static void generatePermutationsHelper(ArrayList<Integer> input, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> output) {
        if (input.isEmpty()) {
            output.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < input.size(); i++) {
            ArrayList<Integer> cloneInput = new ArrayList<>(input);
            ArrayList<Integer> cloneCurrent = new ArrayList<>(current);

            int num = cloneInput.remove(i);
            cloneCurrent.add(num);
            
            generatePermutationsHelper(cloneInput, cloneCurrent, output);
        }
    }
}
