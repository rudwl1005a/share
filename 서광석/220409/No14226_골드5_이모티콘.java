package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class No14226_골드5_이모티콘 {

	static int N;
	static boolean[][] check;
	static int[] minMove;
	static Queue<Memo> queue = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		check = new boolean[N][N+1];
		minMove = new int[N+1];
		Arrays.fill(minMove, Integer.MAX_VALUE);

		bfs();
		
		System.out.println(minMove[N]);
	}
	
	static void bfs() {
		queue.offer(new Memo(0, 1, 0));
		
		while(!queue.isEmpty()) {
			Memo memo = queue.poll();
			int move = memo.m;
			int draw = memo.d;
			int copy = memo.c;
			
			minMove[draw] = Math.min(minMove[draw], move);
			if(draw == N) break; 
			
			// 복사
			queue.offer(new Memo(move+1, draw, draw));
			
			// 붙여넣기
			if(copy != 0 && draw+copy <= N) {
				if(copy < N && draw+1 <= N && !check[copy][draw+copy]) {
					check[copy][draw+copy] = true;
					queue.offer(new Memo(move+1, draw+copy, copy));
				}
			}
			
			// 삭제
			if(draw > 1) {
				if(copy < N && draw-1 <= N && !check[copy][draw-1]) {
					check[copy][draw-1] = true;
					queue.offer(new Memo(move+1, draw-1, copy));
				}
			}
		}
	}
	
	static class Memo{
		int m, d, c;
		public Memo(int m, int d, int c) {
			this.m = m;
			this.d = d;
			this.c = c;
		}
	}

}
