package pg_git;

import java.util.Arrays;

class Budget{
    public int solution(int[] d, int budget) {    	
    	Arrays.sort(d);
        int answer = 0;
        for(int c : d) {
        	int temp = budget-c;
        	if(temp >= 0) {
        		budget = temp;
        		answer++;
        	}else {
        		break;
        	}
        }
        return answer;
    }
}
public class Lv1_budget {
	public static void main(String[] args) {
		Budget b = new Budget();
		int[] d = {2,2,3,3};
		System.out.println(b.solution(d, 10));
	}
}
