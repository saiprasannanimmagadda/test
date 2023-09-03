import java.util.*;
public class StableProblemMenProposingtoWomen {
	

	 
	static int N=5;
	public static int wPrefersM1OverM(int women_priority[][], int w, 
	                               int men, int men1) 
	{ 
		int res=0;
	    for(int i0= 0; i0<N; i0++) 
	    { 
	        
	        if (women_priority[w][i0] == men1) {
	        	
	        	res=1;
	        	break;
	        }
	             
	        if (women_priority[w][i0] == men) {
	        	res=0;
	        	break;
	        }
	              
	    }
	    return res;
	} 
	   
	public static void stableMarriageProblem(int men_priority[][],int women_priority[][]) 
	{ 
	    int womenPartner[] = new int[N]; 
	    boolean menFree[] = new boolean[N]; 
	    int men; 
	    int count = N; 
	    for(int i=0;i<N;i++)
	      {
	          womenPartner[i]=-1;
	          
	      }
	    
	    while (count > 0) 
	    { 
	    	
	        for (men = 0; men < N; men++) { 
	            if (menFree[men] == false) 
	            	break;
	               }
	        
	        for (int i = 0; i < N &&menFree[men] == false; i++) 
	        { 
	        	int women = men_priority[men][i]; 
	            
	            if (womenPartner[women] == -1) 
	            { 
	                womenPartner[women] = men; 
	                menFree[men] = true; 
	                count--; 
	            } 
	  
	            else 
	            { 
	               
	                int men1 = womenPartner[women]; 
	                if (wPrefersM1OverM(women_priority, women, men, men1) == 0) 
	                { 
	                    womenPartner[women] = men; 
	                    menFree[men] = true; 
	                    menFree[men1] = false; 
	                    
	                } 
	            } 
	        } 
	          
	    } 
	    System.out.println("The stable matchings when men propose to women are as follows");    
	System.out.println("Man    Women"); 
	for (int i = 0; i < N; i++) 
	{
	    //System.out.print(" "); 
		
	    System.out.println( "M" + womenPartner[i] + "     " + "W" +
	                          + i );
	}
	} 
	public static void main(String[] args) 
	{ 
	  
		
		int men_priority[][] = new int[][]{{1, 0, 3, 4,2}, 
	        {3,1,0,2,4}, 
	        {1,4,2,3,0}, 
	        {0,3,2,1,4},
	        {1,3,0,4,2}};

	   int women_priority[][] = new int[][] {{4,0,1,3,2}, 
	          {2,1,3,0,4}, 
	          {1,2,3,4,0}, 
	          {0,4,3,2,1},
	          {3,1,4,2,0}}; 
	    stableMarriageProblem(men_priority,women_priority);
	}
}

