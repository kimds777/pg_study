package pg_git;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class DataAnalysis { // 문제 : [PCCE 기출문제] 10번 / 데이터 분석
	public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
		String[] dataChart = { "code", "date", "maximum", "remain" }; //데이터 칼럼 배열
		List<Integer> arrIndex = new ArrayList<>();

		int extIndex = getIndex(dataChart, ext); // 기준 데이터 ext와 데이터 칼럼을 비교하여 동일한 문자열의 index를 가져온다. 

		getArrIndex(arrIndex, extIndex, data, val_ext); // 기준값 val_ext보다 작은 배열을 가져와 arrIndex에 넣는다.

		int[][] answer = new int[arrIndex.size()][dataChart.length]; // arrIndex의 길이를 행의 크기로, dataChart의 길이를 열의 크기로 설정.
		addData(answer, data, arrIndex); // arrIndex에 들어있는 행의 index로 data에서 배열을 가져와 answer에 넣는다.

		int sortIndex = getIndex(dataChart, sort_by); // 정렬 기준 sort_by와 데이터 칼럼을 비교하여 동일한 문자열의 index를 가져온다. 
		arrSort(answer, sortIndex); // sortIndex를 기준으로 answer를 오름차순으로 정렬한다.

		return answer;
	}

	public List<Integer> getArrIndex(List<Integer> arrIndex, int extIndex, int[][] data, int val_ext) {
		for (int d = 0; d < data.length; d++) {
			if (data[d][extIndex] < val_ext) {
				arrIndex.add(d);
			}
		}
		return arrIndex;
	}

	public int getIndex(String[] dataChart, String str) {
		int index = 0;
		
		for(int d = 0; d<dataChart.length; d++) {
			if(dataChart[d].equals(str)) {
				index = d;
				break;
			}
		}
		
		return index;
	}

	public int[][] addData(int[][] answer, int[][] data, List<Integer> arrIndex) {
		for (int i = 0; i < answer.length; i++) {
			answer[i] = data[arrIndex.get(i)];
		}
		return answer;
	}

	public int[][] arrSort(int[][] answer, int sortIndex) {
		Arrays.sort(answer, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[sortIndex] - o2[sortIndex];
			}
		});
		return answer;
	}
}

public class Lv1_dataAnalysis {
	public static void main(String[] args) {
		int[][] data = { { 1, 20300104, 100, 80 }, { 2, 20300804, 847, 37 }, { 3, 20300401, 10, 8 } };
		String ext = "date";
		int val_ext = 20300501;
		String sort_by = "remain";

		int[][] ans = new DataAnalysis().solution(data, ext, val_ext, sort_by);
		for (int[] a : ans) {
			System.out.println(a[0] + ", " + a[1] + ", " + a[2] + ", " + a[3]);
		}
	}
}
