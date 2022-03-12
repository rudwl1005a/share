package 다익스트라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No16167_골드3_AGreatWay {

	static int N, R;
	static final int INF = Integer.MAX_VALUE;
	static ArrayList<ArrayList<Edge>> list = new ArrayList<>();
	static boolean[] visit;
	static int[][] codis;
	static PriorityQueue<Edge> pqueue = new PriorityQueue<>((e1, e2)->e1.cost==e2.cost?e1.dis-e2.dis:e1.cost-e2.cost);
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		visit = new boolean[N+1];
		codis = new int[N+1][2];
		
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
			codis[i][0] = INF;
			codis[i][1] = INF;
		}
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int bc = Integer.parseInt(st.nextToken());
			int ac = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			int cost = t <= 10 ? bc : bc + ac*(t-10);
			list.get(s).add(new Edge(e, cost, 1));
		}
		
		dijkstra();
		
		if(codis[N][0] == INF) {
			System.out.println("It is not a great way.");
		} else {
			System.out.println(codis[N][0] + " " + codis[N][1]);
		}

	}
	
	static void dijkstra() {
		codis[1][0] = 0;
		codis[1][1] = 1;
		pqueue.offer(new Edge(1, 0, 0));
		
		while(!pqueue.isEmpty()) {
			Edge e = pqueue.poll();
			
			if(visit[e.v]) continue;
			visit[e.v] = true;
			
			for(Edge ne : list.get(e.v)) {
				if(visit[ne.v] || ne.cost + codis[e.v][0] > codis[ne.v][0]) continue;
				
				if(ne.cost + codis[e.v][0] == codis[ne.v][0] && ne.dis + codis[e.v][1] >= codis[ne.v][1]) continue;
				
				codis[ne.v][0] = ne.cost + codis[e.v][0];
				codis[ne.v][1] = ne.dis + codis[e.v][1];
				int dis = e.dis + ne.dis;
				
				pqueue.offer(new Edge(ne.v, codis[ne.v][0], codis[ne.v][1]));
			}
		}
	}
	
	static class Edge{
		int v, cost, dis;
		public Edge(int v, int cost, int dis) {
			this.v = v;
			this.cost = cost;
			this.dis = dis;
		}
	}

}
