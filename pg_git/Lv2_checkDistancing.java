package pg_git;

public class Lv2_checkDistancing {
    public static int moveLeft (String[][] placeArray, int index){

    }
    public static int chaeckPeople (String[][] placeArray){
        for(int i = 0; i < placeArray.length; i++){
            for(int k = 0; k < placeArray[i].length; k++) {
                if (i == 0) { // 왼쪽으로 이동할 칸이 없음

                } else if (i == 4) { // 오른쪽으로 이동할 칸이 없음

                }
            }
        }

//        for(int i = 0; i < placeArray[index].length; i++){
//            String check = placeArray[index][i];
//            if(check.equals("P")){
//
//            }
//        }

        return 0;
    }

    public static int[] solution(String[][] places) {
        int[] answer = new int[5];

        for(String[] place : places){
            String[][]  placeArray = new String[5][5];

            for(int j = 0; j < place.length; j++){
                placeArray[j] = place[j].split("");
            }

            for(int i = 0; i < placeArray.length; i++){
                for(int k = 0; k < placeArray[i].length; k++) {
                    if (i == 0) { // 왼쪽으로 이동할 칸이 없음

                    } else if (i == 4) { // 오른쪽으로 이동할 칸이 없음

                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

        System.out.println(solution(places));
    }
}
