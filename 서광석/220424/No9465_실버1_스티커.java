import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No9465_실버1_스티커 {

	static int T, N;
	static int[][] score;
	static int[][] memoi;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			N = Integer.parseInt(br.readLine());
			score = new int[2][N];
			
			for(int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					score[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			memoi = new int[2][N];
			memoi[0][0] = score[0][0];
			memoi[1][0] = score[1][0];
			
			for(int i = 1; i < N; i++) {
				
				for(int j = 1; j <= 2; j++) {
					if(i - j < 0) continue;
					
					memoi[0][i] = Math.max(memoi[0][i], memoi[1][i-j]);
					memoi[1][i] = Math.max(memoi[1][i], memoi[0][i-j]);
				}
				
				memoi[0][i] += score[0][i];
				memoi[1][i] += score[1][i];
				
			}
			
			if(memoi[0][N-1] > memoi[1][N-1]) System.out.println(memoi[0][N-1]);
			else System.out.println(memoi[1][N-1]);
			
		}

	}

}
