package algo.day0312;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ17144_미세먼지안녕 {

	static int R, C, T; // 행 열 시간
	static int ap; // 공기청정기 위치
	static int[][] home;
	static Queue<Dust> dusts = new ArrayDeque<>();
	static int[] dx = { -1, 1, 0, 0};
	static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		home = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				home[i][j] = Integer.parseInt(st.nextToken());
				if(home[i][j] == -1) {
					ap = i; // 공기청정기 위치 (아래)
				}
			}
		}
		
		System.out.println(ap);
		
		for (int t = 0; t < T; t++) {
			func();
			spread();
	    	wind();
		}
		
		int res = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				res += home[i][j];
			}
		}
		System.out.println(Arrays.deepToString(home));

		System.out.println(res+2); // 공기청정기 -1로 된거 더하기
    }
    
    static void func() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (home[i][j] == -1 || home[i][j] == 0)
					continue;
				dusts.add(new Dust(i, j, home[i][j]));
			}
		}		
    }
    
    static void spread() {
    	
    	while (!dusts.isEmpty()) {
			Dust dust = dusts.poll();
			if (dust.d < 5) {
				continue;
			}
			
			int spreadDust = dust.d / 5;
			int cnt = 0;
			
			for (int d = 0; d < 4; d++) {
				int nx = dust.x + dx[d];
				int ny = dust.y + dy[d];
				
				if (nx < 0 || nx >= R || ny < 0 || ny >= C)
					continue;
				
				if (home[nx][ny] == -1)
					continue;
				
				home[nx][ny] += spreadDust;
				++cnt;
			}
			home[dust.x][dust.y] -= spreadDust * cnt;
		}
    	
    }
    
    static void wind() {
    	int upside = ap - 1;
    	int downside = ap;
    	
    	// upside 아래방향
    	for (int i = upside - 1; i > 0; i--) {
			home[i][0] = home[i - 1][0];
		}
    	
    	// upside 왼쪽방향
		for (int i = 0; i < C - 1; i++) {
			home[0][i] = home[0][i + 1];
		}
		
		// upside 위쪽방향
		for (int i = 0; i < upside; i++) {
			home[i][C - 1] = home[i + 1][C - 1];
		}
		
		// upside 오른쪽 방향
		for (int i = C - 1; i > 1; i--) {
			home[upside][i] = home[upside][i - 1];
		}
		
		// downside 위쪽 방향
		for (int i = downside + 1; i < R - 1; i++) {
			home[i][0] = home[i + 1][0];
		}
		
		// downside 왼쪽 방향
		for (int i = 0; i < C - 1; i++) {
			home[R - 1][i] = home[R - 1][i + 1];
		}
		
		// downside 아래쪽 방향
		for (int i = R - 1; i > downside; i--) {
			home[i][C - 1] = home[i - 1][C - 1];
		}
		
		// downside 오른쪽 방향
		for (int i = C - 1; i > 1; i--) {
			home[downside][i] = home[downside][i - 1];
		}
		
		home[upside][1] = 0;
		home[downside][1] = 0;
    }
    
    
	static class Dust {
		int x, y;
		int d; //미세먼지 양

		Dust(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}
