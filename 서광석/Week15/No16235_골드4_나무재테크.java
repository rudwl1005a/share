package 시뮬레이션;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class No16235_골드4_나무재테크 {

	static int N, M, K;
	static int[][] map, s2d2;
	static PriorityQueue<Tree> pqueue = new PriorityQueue<>((t1, t2) -> t1.age - t2.age);
	
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		s2d2 = new int[N+1][N+1];
		map = new int[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				s2d2[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			
			pqueue.offer(new Tree(y, x, age));
		}
		
		
		for(int k = 0; k < K; k++) {
			int[][] deadTree = new int[N+1][N+1];
			
			Queue<Tree> keep = new LinkedList<>();
			
			// 봄
			while(!pqueue.isEmpty()) {
				Tree t = pqueue.poll();
				int y = t.y;
				int x = t.x;
				int age = t.age;
				
				if(map[y][x] >= age) {
					map[y][x] -= age;
					keep.offer(new Tree(y, x, age+1));
				} else {
					deadTree[y][x] += age/2; 
				}
			}
			
			// 여름
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					map[i][j] += deadTree[i][j];
				}
			}
			
			// 가을
			while(!keep.isEmpty()) {
				Tree t = keep.poll();
				
				if(t.age%5 == 0) {
					int y = t.y;
					int x = t.x;
					
					for(int i = 0; i < 8; i++) {
						int ny = y + dy[i];
						int nx = x + dx[i];
						
						if(ny < 1 || nx < 1 || ny > N || nx > N) continue;
						pqueue.offer(new Tree(ny, nx, 1));
					}
				}
				pqueue.offer(t);
			}
			
			// 겨울
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					map[i][j] += s2d2[i][j];
				}
			}
		}
		
		System.out.println(pqueue.size());

	}
	
	static class Tree{
		int y, x, age;
		public Tree(int y, int x, int age) {
			this.y = y;
			this.x = x;
			this.age = age;
		}
	}

}
