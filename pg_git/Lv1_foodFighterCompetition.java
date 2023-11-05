package pg_git;

class FoodFighter {
	public String solution(int[] food) {
		String ans = "";
		StringBuilder answer = new StringBuilder();

		for (int j = 1; j < food.length; j++) {
			int f = food[j] / 2;
			if (f != 0) {
				answer.append(String.valueOf(j).repeat(f));
			}
		}
		ans += answer.toString();
		ans += "0" + answer.reverse().toString();

		return ans;
	}
}

public class Lv1_foodFighterCompetition {
	public static void main(String[] args) {
		int[] food = { 1, 7, 1, 2 };
		String answer = new FoodFighter().solution(food);
		System.out.println(answer);
	}
}
