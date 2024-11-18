package pg_git;

public class Lv2_fatigueLevel {
    static int answer = 0;

    public static int solution(int k, int[][] dungeons) {
        boolean[] checkVisit = new boolean[dungeons.length]; // default false
        int cnt = 0;
        dfs(dungeons, checkVisit, cnt, k);

        return answer;
    }

    private static void dfs(int[][] dungeons, boolean[] checkVisit, int cnt, int stamina) {
        answer = Math.max(answer, cnt);

        for (int i = 0; i < dungeons.length; i++) {
            if (!checkVisit[i] && dungeons[i][0] <= stamina) {
                checkVisit[i] = true;

                dfs(dungeons, checkVisit, cnt + 1, stamina - dungeons[i][1]);

                checkVisit[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int k = 78;
//        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        int[][] dungeons = {{78, 18}, {70, 11}, {67, 9}, {60, 8}, {59, 2}, {57, 54}};
//        int[][] dungeons = {{4,3}, {2,2}, {2,2}};

        System.out.println(solution(k, dungeons));
    }
}
