import java.util.*;
public class TriathlonExercise {
    private static class Contestant implements Comparable<Contestant> {
        int swimmingTime;
        int bikingTime;
        int runningTime;

        public Contestant(int swimmingTime, int bikingTime, int runningTime) {
            this.swimmingTime = swimmingTime;
            this.bikingTime = bikingTime;
            this.runningTime = runningTime;
        }

        // comparing contestants based on their projected swimming times
        public int compareTo(Contestant other) {
            return Integer.compare(this.swimmingTime, other.swimmingTime);
        }
    }

    public static int calculateTotalTime(Contestant[] contestants) {
        Arrays.sort(contestants);
        System.out.println("The order of the contestants are as follows");
        for(Contestant e : contestants) {
        	System.out.println(e.swimmingTime + " " + e.bikingTime + " " + e.runningTime );
        }
        int poolTime = 0;
        int maxTotalTime = 0;

        for (Contestant c : contestants) {
            int swimmingStartTime = poolTime;
            poolTime = swimmingStartTime+c.swimmingTime;
            //System.out.print(poolTime+ " ");
            int bikeStartTime = poolTime;
            int bikeEndTime = bikeStartTime + c.bikingTime;
            //System.out.print(bikeEndTime+" ");
            int totalTime = bikeEndTime + c.runningTime;
            //System.out.print(totalTime+ " ");
            maxTotalTime = Math.max(maxTotalTime, totalTime);
            //System.out.println(maxTotalTime);
        }

        return maxTotalTime;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of contestants: ");
        int n = sc.nextInt();
        
        Contestant[] contestants = new Contestant[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the projected time for contestant " + (i + 1) + " (swim, bike, run): ");
            int swimmingTime = sc.nextInt();
            int bikingTime = sc.nextInt();
            int runningTime = sc.nextInt();
            contestants[i] = new Contestant(swimmingTime, bikingTime, runningTime);
        }

        int totalTime = calculateTotalTime(contestants);
        System.out.println("Total time taken for the competition to complete: " + totalTime);
    }

}