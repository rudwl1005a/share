package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11048_실버1_이동하기 {

	static int N, M;
	static int[][] map;
	static int[][] memoi;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		memoi = new int[N][M];
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		memoi[0][0] = map[0][0];
		// y = 0 이나 x = 0 인 경우는 일직선으로 따라가면서 동작한다.
		for(int i = 1; i < N; i++) {
			memoi[i][0] = memoi[i-1][0] + map[i][0]; 
		}
		for(int i = 1; i < M; i++) {
			memoi[0][i] = memoi[0][i-1] + map[0][i];
		}
		
		// 그 외 위치는 3가지 방법 중 가장 큰 경우를 저장한다.
		for(int i = 1; i < N; i++) {
			for(int j = 1; j < M; j++) {
				// 좌측에서 오는 경우
				int lc = memoi[i][j-1];
				// 상측에서 오는 경우
				int tc = memoi[i-1][j];
				// 대각선에서 오는 경우
				int cc = memoi[i-1][j-1];
				
				int max = Math.max(lc, tc);
				max = Math.max(max, cc);
				
				memoi[i][j] = map[i][j] + max;
			}
		}
		
		System.out.println(memoi[N-1][M-1]);
		

	}

}
