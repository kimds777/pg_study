package pg_git;

public class Lv2_multiplicationOfMatrices {
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++) { // arr1의 1차원 배열 갯수 만큼
            for (int j = 0; j < arr2[0].length; j++) { // 1차원 배열의 길이 만큼
                int sum = 0;
                for (int k = 0; k < arr2.length; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                
                answer[i][j] = sum;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}};

//        int[][] arr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
//        int[][] arr2 = {{5, 4}, {2, 4}, {3, 1}};

//        int[][] arr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
//        int[][] arr2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};

        int[][] answer = solution(arr1, arr2);
        for (int[] ans : answer) {
            for(int a : ans){
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }
}
