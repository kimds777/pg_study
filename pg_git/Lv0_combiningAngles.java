package pg_git;

import java.util.Scanner;

public class Lv0_combiningAngles {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int angle1 = sc.nextInt();
        int angle2 = sc.nextInt();

        int sum_angle = (angle1 + angle2) > 360?(angle1 + angle2)%360:(angle1 + angle2);
        System.out.println(sum_angle);
    }
}