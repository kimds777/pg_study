package pg_git;

public class Lv2_checkDistancing {
    public static int MOVE_MAX_DISTANCE = 2;

    public static int moveCheckX(String[][] array, int index1, int cal1, int index2, int cal2) {
        String checkString1 = array[index1 + cal1][index2 + cal2];

        if (!(checkString1.equals("X"))) {
            return 0;
        }
        return 1;
    }

    public static int moveCheck(String[][] array, int moveDistance, int index1, int cal1, int index2, int cal2) {
        if (moveDistance > 0) {
            String checkString1 = array[index1 + cal1][index2 + cal2];

            if (checkString1.equals("P")) {
                return 0;
            }

            if (moveDistance > 1) {
                String checkString2 = array[index1 + (cal1 * 2)][index2 + (cal2 * 2)];

                if (!(checkString1.equals("X")) && checkString2.equals("P")) {
                    return 0;
                }
            }
        }

        return 1;
    }

    public static int checkAllSides(String[][] array, int index1, int index2) {
        int check = 1;
        int checkTop = 1;
        int checkBottom = 1;
        int checkRight = 1;
        int checkLeft = 1;


        int moveLeftDistance = minDistance(index2); // 왼쪽
        check = moveCheck(array, moveLeftDistance, index1, 0, index2, -1);
        if (check == 0) {
            return 0;
        }

        int moveRightDistance = sumDistance(index2); // 오른쪽
        check = moveCheck(array, moveRightDistance, index1, 0, index2, 1);
        if (check == 0) {
            return 0;
        }

        int moveTopDistance = minDistance(index1); // 위쪽
        check = moveCheck(array, moveTopDistance, index1, -1, index2, 0);
        if (check == 0) {
            return 0;
        }

        int moveBottomDistance = sumDistance(index1); // 아래쪽
        check = moveCheck(array, moveBottomDistance, index1, 1, index2, 0);
        if (check == 0) {
            return 0;
        }

        if (moveTopDistance > 0 && moveLeftDistance > 0) { // 왼쪽 위 대각선
            check = moveCheck(array, 1, index1, -1, index2, -1);

            if (check == 0) { // 대각선에 P가 있는 경우
                checkTop = moveCheckX(array, index1, -1, index2, 0); // 위쪽 X 확인
                checkLeft = moveCheckX(array, index1, 0, index2, -1); //왼쪽 X 확인
                if (checkLeft == 0 || checkTop == 0) {
                    return 0;
                }

            }
        }

        if (moveBottomDistance > 0 && moveLeftDistance > 0) { // 왼쪽 아래 대각선
            check = moveCheck(array, 1, index1, 1, index2, -1);

            if (check == 0) { // 대각선에 P가 있는 경우
                checkBottom = moveCheckX(array, index1, 1, index2, 0); // 아래쪽 X 확인
                checkLeft = moveCheckX(array, index1, 0, index2, -1); //왼쪽 X 확인
                if (checkLeft == 0 || checkBottom == 0) {
                    return 0;
                }

            }
        }

        if (moveTopDistance > 0 && moveRightDistance > 0) { // 오른쪽 위 대각선
            check = moveCheck(array, 1, index1, -1, index2, 1);

            if (check == 0) { // 대각선에 P가 있는 경우
                checkTop = moveCheckX(array, index1, -1, index2, 0); // 위쪽 X 확인
                checkRight = moveCheckX(array, index1, 0, index2, 1); //오른쪽 X 확인
                if (checkRight == 0 || checkTop == 0) {
                    return 0;
                }

            }
        }

        if (moveBottomDistance > 0 && moveRightDistance > 0) { // 오른쪽 아래 대각선
            check = moveCheck(array, 1, index1, 1, index2, 1);

            if (check == 0) { // 대각선에 P가 있는 경우
                checkBottom = moveCheckX(array, index1, 1, index2, 0); // 아래쪽 X 확인
                checkRight = moveCheckX(array, index1, 0, index2, 1); // 오른쪽 X 확인
                if (checkRight == 0 || checkBottom == 0) {
                    return 0;
                }

            }
        }

        return 1;
    }

    public static int minDistance(int index) { // 왼/위쪽으로 이동할 수 있는 거리 측정
        if (index - MOVE_MAX_DISTANCE < 0) {
            return index;
        }
        return MOVE_MAX_DISTANCE;
    }

    public static int sumDistance(int index) { // 오른쪽으로 이동할 수 있는 거리 측정
        if (4 - index < MOVE_MAX_DISTANCE) {
            return 4 - index;
        }
        return MOVE_MAX_DISTANCE;
    }

    public static String[][] getArray(String[] places) { // String을 String[]으로 변환
        String[][] array = new String[5][5];
        for (int i = 0; i < places.length; i++) {
            array[i] = places[i].split("");
        }

        return array;
    }

    public static int chaeckPeople(String[][] array) { // 응시자 위치 확인
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                String check = array[i][j];
                if (check.equals("P")) {
                    int checkSides = checkAllSides(array, i, j);
                    if(checkSides == 0){
                        return 0;
                    }
                }
            }


        }
        return 1;
    }

    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int i = 0; i < places.length; i++) {
            String[][] array = getArray(places[i]);
            answer[i] = chaeckPeople(array);
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

        int[] answer = solution(places);
        for(int a : answer){
            System.out.print(a+" ");
        }

    }
}
