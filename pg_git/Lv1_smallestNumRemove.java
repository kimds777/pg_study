package pg_git;

// 다시 풀어야함!
public class Lv1_smallestNumRemove {
	public int[] solution(int[] arr) {

		if (arr.length == 1) {
			int[] answer = { -1 };
			return answer;
		} else {
			int smallestNum = 0;
			
			for (int i = 0; i < arr.length-1; i++) {
				if (arr[i] < arr[i + 1]) {
					smallestNum = arr[i];
				} else if (arr[i] > arr[i + 1]) {
					smallestNum = arr[i + 1];
				}
			}

			int[] answer = new int[arr.length - 1];
			int j = 0;
			for (int i = 0; i < arr.length; i++) {
				if(arr[i] != smallestNum) {
					answer[j] = arr[i];	
					j++;
				}
			}
			return answer;
		}
	}
}
