package algo.day0409;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11048_이동하기 {

    static int R, C, s;
    static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R + 1][C + 1];

		for (int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= C; j++) {
				s = Integer.parseInt(st.nextToken());
				map[i][j] = Math.max(map[i - 1][j], map[i][j - 1]) + s;
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println(map[R][C]);
	}

}
