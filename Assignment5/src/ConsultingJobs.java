import java.util.*;
public class ConsultingJobs {
    
	public static void calulateRevenue(int[] lowStress, int[] highStress,int n) {
        
        String[] schedule = new String[n];

        
        int[] S = new int[n];

        // we can take any kind of job in the first week
        S[0] = Math.max(lowStress[0], highStress[0]);

        for (int i = 1; i < n; i++) {
        	
            S[i] = Math.max(S[i-1] + lowStress[i],i >= 2 ? S[i-2] + highStress[i] : highStress[i]);
            //System.out.println(S[i]);
        }

        // Backtrack to find the schedule
        for (int i = 0; i < schedule.length; i++) {
            if (S[i] == highStress[i]) {
                schedule[i] = "High";
                if (i > 0) {
                    schedule[i-1] = "None";
                }
            } else {
                schedule[i] = "Low";
            }
        }

        System.out.println("The schedule is " + Arrays.toString(schedule));
        System.out.println("The Revenue from the above schedule is " + S[S.length-1]);
    }

    public static void main(String[] args) {
    	int n;
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the number of weeks n");
    	n= sc.nextInt();
    	int[] lowStressRevenue = new int[n];
    	int[] highStressRevenue = new int[n];
    	System.out.println("Enter the revenue from Low stress jobs");
    	for(int i=0;i<n;i++) {
    		lowStressRevenue[i] = sc.nextInt();
    	}
    	System.out.println("Enter the revenue from High stress jobs");
    	for(int i=0;i<n;i++) {
    		highStressRevenue[i] = sc.nextInt();
    	}
    	/*
        int[] lowStressRevenue = {10, 1, 10, 10};
        int[] highStressRevenue = {5, 50, 5, 1};*/
        calulateRevenue(lowStressRevenue, highStressRevenue,n);
    }
}
