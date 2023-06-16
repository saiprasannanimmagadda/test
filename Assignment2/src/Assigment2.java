import java.util.*;


public class Assigment2{
public static int butterfly_consistant_check(int[][] matrix, int n) {
	// TODO Auto-generated method stub
	int dummy = 65 ;
	char s1;
	char s2;
	int res =0;
	ArrayList<Character> A = new ArrayList<>();
	ArrayList<Character> B = new ArrayList<>();
	for(int i=0;i<n;i++) {
		for(int j=i+1;j<n;j++) {
			s1= (char) (dummy+i);
			s2= (char)(dummy+j);
			if(A.contains(s1))
			    {
			       if(matrix[i][j]==0) {
			    	   if(B.contains(s2)) {
			    		   res=1;
			    		   break;
			    	   }
			    	   else if(A.contains(s2)){
			    		   continue;
			    	   }
			    	   else {
			    		   A.add(s2);
			    	   }
				   
			       }
			        else {
			        	if(A.contains(s2)) {
			        		res =1;
			        		break;
			        	}
			        	else if (B.contains(s2)) {
			        		continue;
			        	}
			        	else {
			        		 B.add(s2);
			        	}
				   
			    }
			 }
			else if(B.contains(s1))
			     {
				  if(matrix[i][j]==0) {
					  if(A.contains(s2)) {
						  res=1;
						  break;
					  }
					  else if(B.contains(s2)) {
						  continue;
					  }
					  else {
						  B.add(s2);
					  }
					   
				    }
				   else {
					   if(B.contains(s2)) {
						   res=1;
						   break;
					   }
					   else if(A.contains(s2)) {
						   continue;
					   }
					   else
					   {
						    A.add(s2);   
					   }
				
			     }
				  }
		    else{
			   if(matrix[i][j]==0) {
				   A.add(s1);
				   A.add(s2);
		       }
			   else {
				   A.add(s1);
				   B.add(s2);
			   }
			
		}
	}
	}
	System.out.println("Group1 "+A);
	System.out.println("Group2 " +B);
	return res;
}

public static void main(String[] args) 
{ 
	int n , m;
	Scanner sc = new Scanner(System.in);
	int dummy = 65;
	char node1, node2;
	System.out.println("Enter the value of no of nodes (n)");
	n= sc.nextInt();
	m = (n*(n-1))/2; 
	System.out.println("Number of judgements m = (n*(n-1))/2");
	System.out.println(m);
	System.out.println("please enter the "+ m + " judgements values in 0 and 1 format: 0's for same 1's for different " );
	int[][] judgments = new int[n][n];
	
	for(int i=0;i<n;i++) {
		for(int j=i+1;j<n;j++) {
			node1= (char) (dummy+i);
			node2= (char)(dummy+j);
			System.out.println("Judgment for Edge "+ node1 + node2);
			judgments[i][j]=sc.nextInt();
			
		}
	}
	int ans = butterfly_consistant_check(judgments,n);
	if(ans==0) {
		System.out.println("Judgements are consistant");
	}
	else {
		System.out.println("Judgements are not consistant");
	}
}
}