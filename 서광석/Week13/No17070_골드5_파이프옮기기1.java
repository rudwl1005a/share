import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No17070_골드5_파이프옮기기1 {

	static int N;
	static int[][] map;
	static int[][][] memoi;		// 0:가로   1:대각  2:세로
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		memoi = new int[N+1][N+1][3];
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		memoi[1][2][0] = 1;
		
		for(int i = 1; i <= N; i++) {
			for(int j = 3; j <= N; j++) {
				if(map[i][j] == 1) continue;
				
				memoi[i][j][0] = memoi[i][j-1][0] + memoi[i][j-1][1];
				memoi[i][j][2] = memoi[i-1][j][1] + memoi[i-1][j][2];
				
				if(map[i-1][j] == 1 || map[i][j-1] == 1) continue;
				memoi[i][j][1] = memoi[i-1][j-1][0] + memoi[i-1][j-1][1] + memoi[i-1][j-1][2];
			}
		}
		
		System.out.println(memoi[N][N][0] + memoi[N][N][1] + memoi[N][N][2]);

	}

}
