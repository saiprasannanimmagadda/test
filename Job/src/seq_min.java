import java.util.ArrayList;
 
// seq_min: it is same as q_seq_sum but the way quality calculated will be different

public class seq_min {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(7);
         list3.add(8);
         list3.add(9);
       
         ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(10);
        

        input.add(list1);
        input.add(list2);
        input.add(list3);
        input.add(list4);

        ArrayList<ArrayList<Integer>> output = generateCombinationsWithOrder(input);

        // Print the output
        for (ArrayList<Integer> combination : output) {
            System.out.println(combination);
        }
        System.out.println(output.size());
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
}
