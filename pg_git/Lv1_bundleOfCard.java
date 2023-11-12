package pg_git;

class BundleOfCard {
	public String solution(String[] cards1, String[] cards2, String[] goal) {
		String answer = "Yes";
		int cnt = 0;
		for (String g : goal) {
			for (int c1 = 0; c1 < cards1.length; c1++) {
				if (cards1[c1].equals(g) && c1 == 0) {
					cards1[c1] = "0";
					cnt++;
					break;
				} else if (cards1[c1].equals(g) && cards1[c1 - 1].equals("0")) {
					cards1[c1] = "0";
					cnt++;
					break;
				}
			}

			for (int c2 = 0; c2 < cards2.length; c2++) {
				if (cards2[c2].equals(g) && c2 == 0) {
					cards2[c2] = "0";
					cnt++;
					break;
				} else if (cards2[c2].equals(g) && cards2[c2 - 1].equals("0")) {
					cards2[c2] = "0";
					cnt++;
					break;
				}
			}

		}

		if (cnt != goal.length) {
			answer = "No";
		}

		return answer;
	}
}

public class Lv1_bundleOfCard {
	public static void main(String[] args) {
		String[] cards1 = { "i", "water", "drink" };
		String[] cards2 = { "want", "to" };
		String[] goal = { "i", "want", "to", "drink", "water" };

		String ans = new BundleOfCard().solution(cards1, cards2, goal);
		System.out.println(ans);
	}
}
