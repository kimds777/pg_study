package pg_git;

class OrganizeWallpaper {
	public int[] solution(String[] wallpaper) {
		int[] lu = { 50, 50 }; // 시작점 배열로 초기화 값보다 작은 경우 변경
		int[] rd = { 0, 0 }; // 끝점 배열로 초기화 값보다 큰 경우 변경
		for (int w = 0; w < wallpaper.length; w++) {
			for (int c = 0; c < wallpaper[w].length(); c++) {
				char checkChar = wallpaper[w].charAt(c); // w는 x좌표, c는 y좌표
				if (checkChar == '#') { //격자칸에 파일이 있는 경우
					
					//Math.min, Math.max를 사용한 방법!
					lu[0] = Math.min(lu[0], w); // 시작점 기존값보다 작은 경우
					lu[1] = Math.min(lu[1], c); // 시작점 기존값보다 작은 경우
					rd[0] = Math.max(rd[0], w); // 끝점 기존값보다 큰 경우
					rd[1] = Math.max(rd[1], c); // 끝점 기존값보다 큰 경우
					
//					if문 사용!
//					if (lu[0] > w) {
//						lu[0] = w;
//					} 
//					if (lu[1] > c) {
//						lu[1] = c;
//					}
//					
//					if (rd[0] < w) {
//						rd[0] = w;
//					}
//					
//					if (rd[1] < c) {
//						rd[1] = c;
//					}
				}
			}
		}

		int[] answer = new int[4];
		answer[0] = lu[0];
		answer[1] = lu[1];
		answer[2] = rd[0] + 1; // 격자칸을 포함시켜야하기때문에 1을 더해준다
		answer[3] = rd[1] + 1; // 격자칸을 포함시켜야하기때문에 1을 더해준다

		return answer;
	}
}

public class Lv1_organizeWallpaper {
	public static void main(String[] args) {
		String[] wallpaper = { "..", "#." };

		int[] ans = new OrganizeWallpaper().solution(wallpaper);
		for (int a : ans) {
			System.out.print(a + " ");
		}
	}
}
