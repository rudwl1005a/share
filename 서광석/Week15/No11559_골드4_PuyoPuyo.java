package 시뮬레이션;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No11559_골드4_PuyoPuyo {

	static char[][] map;
	static boolean[][] visit;
	static char nowColor;
	static LinkedList<int[]> list;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[12][];
		for(int i = 0; i < 12; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		boolean isRun = true;
		int ans = 0;
		
		while(isRun) {
			visit = new boolean[12][6];
			isRun = false;
			
			// 터뜨리기
			for(int i = 0; i < 12; i++) {
				for(int j = 0; j < 6; j++) {
					if(map[i][j] == '.' || visit[i][j]) continue;
					
					list = new LinkedList<>();
					nowColor = map[i][j];
					
					visit[i][j] = true;
					dfs(i, j);
					
					if(list.size() >= 4) {
						for(int[] arr : list) {
							map[arr[0]][arr[1]] = '.';
						}
						isRun = true;
					}
				}
			}
			
			// 정렬하기
			for(int i = 0; i < 6; i++) {
				Queue<Character> queue = new LinkedList<>();
				
				for(int j = 11; j >= 0; j--) {
					char c = map[j][i];
					
					if(c != '.') {
						queue.offer(map[j][i]);
					}
				}
				
				int h = 11;
				while(!queue.isEmpty()) {
					map[h][i] = queue.poll();
					h--;
				}
				while(h >= 0) {
					map[h][i] = '.';
					h--;
				}
			}
			
			ans++;
		}
		
		System.out.println(ans-1);

	}
	
	static void dfs(int y, int x) {
		list.add(new int[] {y, x});
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny < 0 || nx < 0 || ny >= 12 || nx >= 6 || map[ny][nx] != nowColor || visit[ny][nx]) continue;
			visit[ny][nx] = true;
			
			dfs(ny, nx);
		}
	}

}
