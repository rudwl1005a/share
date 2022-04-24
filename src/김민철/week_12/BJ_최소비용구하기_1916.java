package week_12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_최소비용구하기_1916 {
	
	static int N, M;
	static int bus[][];
	static long cost[];
	static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N= Integer.parseInt(br.readLine());
		M= Integer.parseInt(br.readLine());
		bus = new int[N+1][N+1];
		cost = new long[N+1];
		Arrays.fill(cost, Integer.MAX_VALUE);
		
		for(int i = 0; i <= N; i++) {
			Arrays.fill(bus[i], INF);
		}
//		System.out.println(cost[1]);
		for(int i = 1; i <= M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			bus[y][x] = Math.min(bus[y][x], c);
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Node> pq = new PriorityQueue<>((n1,n2) -> n1.s-n2.s);
		pq.add(new Node(start));
		cost[start] = 0;
		while(!pq.isEmpty()) {
			
			Node n = pq.poll();
			int s = n.s;
//			int e = n.e;
			
			for(int i = 1; i <= N; i++) {
				if(bus[s][i] != INF && (cost[s] +bus[s][i]) < cost[i]) {
					pq.add(new Node(i));
					cost[i] = cost[s] +bus[s][i];
//					System.out.println(i + "  " + cost[i]);
				}
			}
		}
		System.out.println(cost[end]);
	}
	
	
	static class Node{
		int s;
		
		public Node(int s) {
			this.s = s;
		
		}
	}

}
