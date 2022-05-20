import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class No13549_골드5_숨바꼭질3 {

	static int N, K;
	static boolean[] visit;
	static Deque<Point> deque = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visit = new boolean[100001];
		
		deque.offer(new Point(N, 0));
		bfs();

	}
	
	static void bfs() {
		while(!deque.isEmpty()) {
			Point p = deque.poll();
			int n = p.n;
			
			if(n == K) {
				System.out.println(p.t);
				return;
			}
			
			if(N < K) {
				if(n*2 < 100001 && !visit[n*2]) {
					deque.offerFirst(new Point(n*2, p.t));
					visit[n*2] = true;
				}
				
				if(n+1 < 100001 && !visit[n+1]) {
					deque.offer(new Point(n+1, p.t+1));
					visit[n+1] = true;
				}
			}
			
			if(n-1 >= 0 && !visit[n-1]) {
				deque.offer(new Point(n-1, p.t+1));
				visit[n-1] = true;
			}
			
			
			
		}
	}
	
	static class Point{
		int n, t;
		public Point(int n, int t) {
			this.n = n;
			this.t = t;
		}
	}

}
