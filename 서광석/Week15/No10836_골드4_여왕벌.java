package 시뮬레이션;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No10836_골드4_여왕벌 {

	static int M, N;
	static int[][] matrix, grow;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		matrix = new int[M][M];
		for(int i = 0; i < M; i++) {
			Arrays.fill(matrix[i], 1);
		}
		
		for(int t = 0; t < N; t++) {
			grow = new int[M][M];
			int[] growCnt = new int[3];
			
			// 입력으로 주어지는 성장
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 3; i++) {
				growCnt[i] = Integer.parseInt(st.nextToken());
			}
			int index = 0;
			
			for(int i = M-1; i >= 0; i--) {
				if(growCnt[index] == 0) index++;
				grow[i][0] = index;
				matrix[i][0] += index; 
				growCnt[index]--;
			}
			for(int i = 1; i < M; i++) {
				if(growCnt[index] == 0) index++;
				grow[0][i] = index;
				matrix[0][i] += index;
				growCnt[index]--;
			}
			
			// 그 외 성장
			for(int i = 1; i < M; i++) {
				for(int j = 1; j < M; j++) {
					grow[i][j] = Math.max(grow[i-1][j], grow[i-1][j-1]);
					grow[i][j] = Math.max(grow[i][j], grow[i][j-1]);
					
					matrix[i][j] += grow[i][j];
				}
			}
		}
		
		// 출력
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

}
