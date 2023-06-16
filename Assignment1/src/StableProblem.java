import java.util.*;

public class StableProblem
{ 
static int N=5;
public static int wPrefersM1OverM(int w_prefer[][], int w, 
                               int m, int m1) 
{ 
	int res=0;
    for(int i0= 0; i0<N; i0++) 
    { 
        
        if (w_prefer[w][i0] == m1) {
        	
        	res=1;
        	break;
        }
             
        if (w_prefer[w][i0] == m) {
        	res=0;
        	break;
        }
              
    }
    return res;
} 
   
public static void stableMarriageProblem(int m_prefer[][],int w_prefer[][]) 
{ 
    int wPartner[] = new int[N]; 
    boolean mFree[] = new boolean[N]; 
    int men; 
    int count = N; 
    for(int i=0;i<N;i++)
      {
          wPartner[i]=-1;
          
      }
    
    while (count > 0) 
    { 
    	
        for (men = 0; men < N; men++) { 
            if (mFree[men] == false) 
            	break;
               }
        
        for (int i = 0; i < N &&mFree[men] == false; i++) 
        { 
        	int women = m_prefer[men][i]; 
            
            if (wPartner[women] == -1) 
            { 
                wPartner[women] = men; 
                mFree[men] = true; 
                count--; 
            } 
  
            else 
            { 
               
                int men1 = wPartner[women]; 
                if (wPrefersM1OverM(w_prefer, women, men, men1) == 0) 
                { 
                    wPartner[women] = men; 
                    mFree[men] = true; 
                    mFree[men1] = false; 
                    
                } 
            } 
        } 
          
    } 
System.out.println("Man    Women"); 
for (int i = 0; i < N; i++) 
{
    System.out.print(" "); 
    System.out.println( "m" + wPartner[i] + "     " + "w" +
                          + i );
}
} 
public static void main(String[] args) 
{ 
  
	
	int m_prefer[][] = new int[][]{{1, 0, 3, 4,2}, 
        {3,1,0,2,4}, 
        {1,4,2,3,0}, 
        {0,3,2,1,4},
        {1,3,0,4,2}};

   int w_prefer[][] = new int[][] {{4,0,1,3,2}, 
          {2,1,3,0,4}, 
          {1,2,3,4,0}, 
          {0,4,3,2,1},
          {3,1,4,2,0}}; 
          stableMarriageProblem(m_prefer,w_prefer);
}
}