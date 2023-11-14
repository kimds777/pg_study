package pg_git;

import java.util.HashSet;
import java.util.Set;

class Phoneketmon {
	public int solution(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int n : nums) {
			set.add(n);
		}

		int getPhoneketmon = nums.length / 2;
		int size = set.size();
		int answer = 0;

		if (size >= getPhoneketmon) {
			answer = getPhoneketmon;
		} else {
			answer = size;
		}
		
		return answer;
	}
}

public class Lv1_phoneketmon {
	public static void main(String[] args) {
		int[] nums = { 3,3,3,2,2,2 };
		int ans = new Phoneketmon().solution(nums);
		System.out.println(ans);
	}
}
