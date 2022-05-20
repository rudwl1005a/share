import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1238_골드3_파티 {

	static int N, M, X, max;
	static int[][] matrix;
	static PriorityQueue<Node> pqueue = new PriorityQueue<>((n1, n2)->n1.min-n2.min);
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		matrix = new int[N+1][N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			matrix[s][e] = t;
		}
		
		int[] dist = new int[N+1];
		boolean[] visit;
		max = Integer.MIN_VALUE;
		
		for(int i = 1; i <= N; i++) {
			if(i == X) continue;
			int nowDist = 0;
			pqueue.clear();
			
			visit = new boolean[N+1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[i] = 0;
			pqueue.offer(new Node(i, dist[i]));
			
			while(!pqueue.isEmpty()) {
				Node node = pqueue.poll();
				
				visit[node.no] = true;
				if(node.no == X) {
					break;
				}
				
				for(int j = 1; j <= N; j++) {
					if(!visit[j] && matrix[node.no][j] != 0 && dist[j] > dist[node.no] + matrix[node.no][j] ) {
						dist[j] = dist[node.no] + matrix[node.no][j];
						pqueue.offer(new Node(j, dist[j]));
					}
				}
			}
			nowDist += dist[X];
			
			pqueue.clear();
			visit = new boolean[N+1];

			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[X] = 0;
			pqueue.offer(new Node(X, dist[X]));
			
			while(!pqueue.isEmpty()) {
				Node node = pqueue.poll();
				
				visit[node.no] = true;
				if(node.no == i) {
					break;
				}
				
				for(int j = 1; j <= N; j++) {
					if(!visit[j] && matrix[node.no][j] != 0 && dist[j] > dist[node.no] + matrix[node.no][j] ) {
						dist[j] = dist[node.no] + matrix[node.no][j];
						pqueue.offer(new Node(j, dist[j]));
					}
				}
			}
			nowDist += dist[i];
			
			max = Math.max(max, nowDist);
			
		}
		
		System.out.println(max);

	}
	
	static class Node{
		int no, min;
		public Node(int no, int min) {
			this.no = no;
			this.min = min;
		}
	}

}
