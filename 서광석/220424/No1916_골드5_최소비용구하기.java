import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1916_골드5_최소비용구하기 {

	static int N, M, start, end;
	static int[][] matrix;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		matrix = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				matrix[i][j] = -1;
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			if(matrix[s][e] == -1) {
				matrix[s][e] = n;
			} else {
				matrix[s][e] = Math.min(matrix[s][e], n);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		long[] dist = new long[N+1];
		boolean[] visit = new boolean[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		for(int i = 1; i <= N; i++) {
			long min = Long.MAX_VALUE;
			int current = 0;
			
			for(int j = 1; j <= N; j++) {
				if(!visit[j] && min > dist[j]) {
					min = dist[j];
					current = j;
				}
			}
			
			visit[current] = true;
			if(current == end) break;
			
			for(int j = 1; j <= N; j++) {
				if(!visit[j] && matrix[current][j] != -1 && dist[j] > dist[current] + matrix[current][j]) {
					dist[j] = dist[current] + matrix[current][j];
				}
			}
		}
		
		System.out.println(dist[end]);

	}

}
