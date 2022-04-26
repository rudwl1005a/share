import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2096_골드4_내려가기 {

	static int N;
	static int[][] map;
	
	static int[] dx = {-1, 0, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int[][] minMemoi = new int[N][3];
		int[][] maxMemoi = new int[N][3];
		
		map = new int[N][3];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				minMemoi[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for(int i = 0; i < 3; i++) {
			minMemoi[0][i] = map[0][i];
			maxMemoi[0][i] = map[0][i];
		}
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < 3; j++) {
				for(int k = 0; k < 3; k++) {
					int nx = j + dx[k];
					if(nx < 0 || nx >= 3) continue;
					
					minMemoi[i][j] = Math.min(minMemoi[i-1][nx], minMemoi[i][j]);
					maxMemoi[i][j] = Math.max(maxMemoi[i-1][nx], maxMemoi[i][j]);
				}
				minMemoi[i][j] += map[i][j];
				maxMemoi[i][j] += map[i][j];
			}
		}
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < 3; i++) {
			max = Math.max(maxMemoi[N-1][i], max);
			min = Math.min(minMemoi[N-1][i], min);
		}
		
		System.out.println(max + " " + min);

	}

}
