package pg_git;

public class Lv1_smallestNumRemove {
	public int[] solution(int[] arr) {

		if (arr.length == 1) {
			int[] answer = { -1 };
			return answer;
		} else {
			int smallestNum = arr[0];
			
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] < smallestNum) {
					smallestNum = arr[i];
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
