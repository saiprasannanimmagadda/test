import java.math.BigInteger;
import java.util.*;
public class InversionCount
{ 
	static int inversions=0,count=0; 
	public static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
	private static int[] sort(int[] arr) {
		if(arr.length<=1) {
			return arr;
		}
		int mid = arr.length/2;
		int[] left = new int[mid];
		int[] right; 
		if(arr.length %2==0) {
			right = new int[mid];
		}
		else {
			right = new int[mid+1];
		}
		for(int i=0;i<mid;i++) {
			left[i]=arr[i];
		}
		for(int j=0;j<right.length;j++) {
			right[j]=arr[mid+j];
		}
		int[] result = new int[arr.length];
		left = sort(left);
		right = sort(right);
		
		result = merge(left,right);
		return result;
	}
    
    private static int[] merge(int[] left, int[] right) {
    	
    	int[] result = new int[left.length+right.length];
    	int l,r,res; 
    	l=r=res=0; 
    	while(l<left.length || r< right.length) {
    		int a,b; 
    		a=b=0;
    		
    			    	
    		if(l<left.length && r< right.length) {
    			if(left[l]<right[r]) {
    				result[res++]=left[l++];
    			}
    			else {
    				//System.out.println(left[l]+  "  " + right[r]);
    				 b = right[r];
    				for(int i=l;i<left.length;i++) {
    				a = left[i];
    				//System.out.println(a+" "+b);
   				    if(a > 2*b) {
 					 inversions = inversions + 1;
 				    // System.out.println(inversions);
   				      }
    				}
    				result[res++]=right[r++];
    				 
    				}
    		}
    		else if(l<left.length) {
    			result[res++]=left[l++];
    		}
    		else if (r<right.length) {
    			result[res++]=right[r++];
    			
    		}	
    	}
    	return result;
    }
    public static void main(String args[])
    {
    	int n;
    	Scanner sc = new Scanner(System.in); 
    	System.out.println("Enter the value of n" );
    	n=sc.nextInt();
    	int[] arr = new int[n];
    	System.out.println("Enter the elements in the array");
    	for(int i=0;i<n ; i++) {
    		arr[i]= sc.nextInt();
    	}
        // int arr[] = {6, 12, 15, 4, 11, 8,10,2,9,3,7};
 
        System.out.println("Given Array");
        printArray(arr);
 
        arr = sort(arr);
        System.out.println("\nSorted array");
        printArray(arr);
        System.out.print("Total number of inversions : ");
        System.out.print(inversions);
    }
}