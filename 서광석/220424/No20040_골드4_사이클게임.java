import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class No20040_골드4_사이클게임 {

	static int N, M, cnt;
	static int[] parent;
	static boolean isCycle;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		makeSet();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			cnt++;
			if(!union(a, b)) {
				isCycle = true;
				break;
			}
		}
		if(isCycle) System.out.println(cnt);
		else System.out.println(0);
	}
	
	static void makeSet() {
		parent = new int[N];
		for(int i = 0; i < N; i++) {
			parent[i] = i;
		}
	}
	
	static int findSet(int a) {
		if(parent[a] == a) return a;
		
		return parent[a] = findSet(parent[a]);
	}
	
	static boolean union(int a, int b) {
		int na = findSet(a);
		int nb = findSet(b);
		if(na == nb) return false;
		
		if(na > nb) parent[na] = nb;
		else parent[nb] = na;
		
		return true;
	}

}
