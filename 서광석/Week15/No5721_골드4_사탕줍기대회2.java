package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No5721_골드4_사탕줍기대회2 {

	static int M, N;
	static int[][] box;
	static int[][] memoi;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			if(M == 0 && N == 0) return;
			
			memoi = new int[M][N];
			box = new int[M][N];
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					box[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < N; j++) {
					memoi[i][j] = box[i][j];
										
					if(j-3 >= 0) {
						memoi[i][j] += memoi[i][j-3] > memoi[i][j-2] ? memoi[i][j-3] : memoi[i][j-2];
						memoi[i][j] = Math.max(memoi[i][j], memoi[i][j-1]);
					} else if(j-2 >= 0) {
						memoi[i][j] = Math.max(memoi[i][j] + memoi[i][j-2], memoi[i][j-1]);
					} else if(j-1 >= 0) {
						memoi[i][j] = Math.max(memoi[i][j], memoi[i][j-1]);						
					}
				}
				
				if(i-3 >= 0) {
					memoi[i][N-1] += memoi[i-3][N-1] > memoi[i-2][N-1] ? memoi[i-3][N-1] : memoi[i-2][N-1];
					memoi[i][N-1] = Math.max(memoi[i][N-1], memoi[i-1][N-1]);
				} else if(i-2 >= 0) {
					memoi[i][N-1] = Math.max(memoi[i][N-1] + memoi[i-2][N-1], memoi[i-1][N-1]);
				} else if(i-1 >= 0) {
					memoi[i][N-1] = Math.max(memoi[i][N-1], memoi[i-1][N-1]);
				}
			}
			
			System.out.println(memoi[M-1][N-1]);
		}

	}

}
