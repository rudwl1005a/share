package week_12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_움직이는미로탈출_16954 {
	static char[][] map;
	static int dy[] = {-1, -1, -1, 0, 0, 1, 1, 1 , 0};
	static int dx[] = {-1, 0 , 1 , 1 , -1 , 1, 0, -1, 0};
	static Queue<Node> q = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[8][];
		
		
		for(int i = 0; i < 8; i++) {  // 입력받기 
			map[i] = br.readLine().toCharArray();
		}
		
		q.offer(new Node(7, 0));
		
		while(!q.isEmpty()) {
			
			int size = q.size();  // 현재 queue 의 size가 같은 시간 이동가능한 갯수임.
			for(int i = 0; i < size; i++) { 
				Node n = q.poll();
				int y = n.y;
				int x = n.x;
				if(map[y][x] == '#') continue;  // 벽이면 continue
				
				// 벽이 아니면.
				for(int j = 0 ; j < 9; j++) {  // 8방 탐색
					int ny = y + dy[j];
					int nx = x + dx[j];
					//범위 체크
					if(ny < 0 || nx < 0 || ny >= 8 ||  nx >= 8 ) continue;
					
					if(ny == 0 && nx == 7) {
						System.out.println(1);
						return;
					}
					if(map[ny][nx] != '#') q.offer(new Node(ny,nx));
				}
			}
			push(); //벽 내려주기
		}
		System.out.println(0); // while 문 빠져나왔는데도 리턴 안됐으면 빠져나갈 수 없음.
	}
	static void push() {  // 벽 내려주기
		
		for (int i = 6; i >= 0; i--) {
			for(int j = 0; j < 8; j++) {
				map[i+1][j] = map[i][j];
			}
		}
		for(int i = 0; i < 8; i++) {
			map[0][i] = '.';
		}
	}
	
	
	static class Node{  
		
		int y, x;
		
		public Node(int y, int x ) {
			
			this.y = y;
			this.x = x;
		}
	}

}
