import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1043_골드4_거짓말 {

	static int N, M, T, ans;
	static int[][] party;
	static int[] truePerson;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		party = new int[M][N+1];
		truePerson = new int[N+1];
		// makeSet
		for(int i = 0; i <= N; i++) {
			truePerson[i] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for(int i = 0; i < T; i++) {
			int t = Integer.parseInt(st.nextToken());
			truePerson[t] = 0;		// 진실을 알면 0
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			party[i][0] = n;
			
			for(int j = 1; j <= n; j++) {
				party[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < M; i++) {
			int n = party[i][0];
			for(int j = 2; j <= n; j++) {
				int a = party[i][j-1];
				int b = party[i][j];
				
				if(findSet(a) != findSet(b) ) {
					union(a, b);
				}
			}
		}
		
		for(int i = 0; i < M; i++) {
			int talk = 1;
			int n = party[i][0];
			for(int j = 1; j <= n; j++) {
				if(findSet(party[i][j]) == 0) {
					talk = 0;
					break;
				}
			}
			
			if(talk == 1) ans++;
		}
		
		System.out.println(ans);

	}
	
	static int findSet(int a) {
		if(a == truePerson[a]) return a;
		
		return truePerson[a] = findSet(truePerson[a]);
	}
	
	static void union(int a, int b) {
		int ar = findSet(a);
		int br = findSet(b);
		
		if(ar < br) truePerson[br] = ar;
		else truePerson[ar] = br;
	}

}
