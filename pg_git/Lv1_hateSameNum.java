package pg_git;

class Hate {
	public int[] solution(int[] arr) {
		int leng = arr.length;
		int cnt = 0;
		for (int i = 1; i < leng; i++) {
			if(arr[i-1] == arr[i]) {
				arr[i-1] = -1;
				cnt++;
			}
		}

		int[] ans = new int[leng-cnt];
		int j = 0;
		for(int a : arr) {
			if(a != -1) {
				ans[j] = a;
				j++;
			}
		}

		return ans;
	}
}

public class Lv1_hateSameNum {
	public static void main(String[] args) {

		Hate h = new Hate();
		int[] arr = { 1, 1, 3, 3, 0, 1, 1 };

		arr = h.solution(arr);
		for (int a : arr) {
			System.out.print(a + " ");
		}
	}
}
