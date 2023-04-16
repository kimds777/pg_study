package pg_git;

public class Lv1_avg {
	public double Lv1_avg(int[] arr) {
	        double answer = 0;
	        int sum = 0 ;
	        for(int i=0;i<arr.length;i++){
	            sum+=arr[i];
	            answer=(double)sum/arr.length;
	        }
	        return answer;
    }
}
