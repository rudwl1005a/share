package 실시간;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No11054_골드3_가장긴바이토닉부분수열 {

	static int N;
	static int[] list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] memoiUp = new int[N+1][N+1];
		int[][] memoiDown = new int[N+1][N+1];
		Arrays.fill(memoiUp[0], 1);
		Arrays.fill(memoiDown[0], 1);
		
		for(int i = 1; i <= N; i++) {
			
			for(int j = 1; j <= N; j++) {
				if(list[i-1] < list[j-1]) {
					memoiUp[i][j] = Math.max(memoiUp[i][i]+1, memoiUp[i-1][j]);
				} else {
					memoiUp[i][j] = memoiUp[i-1][j];
				}
			}
			
			for(int j = N; j > 0; j--) {
				if(list[N-i] < list[j-1]) {
					memoiDown[i][j] = Math.max(memoiDown[i][N-i+1]+1, memoiDown[i-1][j]);
				} else {
					memoiDown[i][j] = memoiDown[i-1][j];
				}
			}
			
		}
		
		int ans = 0;
		for(int i = 1; i <= N; i++) {
			int n = memoiUp[N][i] + memoiDown[N][i] - 1;
			ans = Math.max(ans, n);
		}
		
		System.out.println(ans);

	}

}
