package pg_git;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

class PointRectangle{
	public void print(int[] rec) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<rec[1]; i++) {
			sb.append("*".repeat(rec[0])).append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
}

public class Lv1_pointStarRectangle {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] rec = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		PointRectangle pr = new PointRectangle();
		pr.print(rec);
		
	}
}
