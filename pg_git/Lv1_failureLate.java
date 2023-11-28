package pg_git;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class FailureLate {
	public int[] solution(int N, int[] stages) {
		Map<Integer, Integer> checkStages = new HashMap<>();
		for (int s : stages) {
			if (!checkStages.containsKey(s)) {
				checkStages.put(s, 0);
			}
			checkStages.put(s, checkStages.get(s) + 1);
		}

		Map<Integer, Double> checkFailureLate = new HashMap<>();
		
		int totalUser = stages.length;
		for (int i = 1; i <= N; i++) {
			Integer failUser = checkStages.get(i);
			if (failUser == null) {
				checkFailureLate.put(i, 0.0);
				continue;
			}
			double iFailureLate = (double) failUser / totalUser ;
			checkFailureLate.put(i, iFailureLate);
			
			totalUser -= failUser;
		}
		
		List<Map.Entry<Integer,Double>> failSort = new LinkedList<>(checkFailureLate.entrySet());
		failSort.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
		
		int[] answer = new int[failSort.size()];
		int i = 0;
		for(Map.Entry<Integer,Double> entry : failSort){
		    answer[i] = entry.getKey();
		    i++;
		}

		return answer;
	}
}

public class Lv1_failureLate {
	public static void main(String[] args) {
		int N = 4;
		int[] stages = { 4,4,4,4,4 };

		int[] result = new FailureLate().solution(N, stages);
		for (int r : result) {
			System.out.print(r + " ");
		}
	}
}
