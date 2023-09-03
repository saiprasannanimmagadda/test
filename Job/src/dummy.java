import java.util.*;
public class dummy {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		ArrayList<Integer> B = new ArrayList<>();
		A.add(1);
		A.add(3);
		A.add(4);
		A.add(8);
		A.add(10);
		B.add(1);
		B.add(2);
		B.add(3);
		B.add(5);
		B.add(8);
		B.add(11);
		int i=0,j=0;
		while(i<B.size() && j < A.size()) {
		    
			if(B.get(i)< A.get(j)) {
				i++;
				j++;
				System.out.println(B.get(i));
			}
			else if(B.get(i)== A.get(j)) {
				j++;
				i++;
			}
			else {
				i++;
				//System.out.println(B.get(i));
				
				
			}
				
		
		
		

	}

}
}
