package algo.day0402;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ16562_친구비 {

	static int N, M, K, ans;
	static int[] rank;
	static int[] parent;
	static int[] cost;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());  // 학생수
		M = Integer.parseInt(st.nextToken());  // 친구관계수
		K = Integer.parseInt(st.nextToken());  // 가진 돈

		ans = 0;
		rank = new int[N + 1];	// 트리의 높이
		parent = new int[N + 1];// 부모
		cost = new int[N + 1];  // 비용
		
		for (int i = 0; i <= N; ++i) {
			parent[i] = i;
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; ++i) {
			cost[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(Arrays.toString(parent));
		
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());

			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			if (find(p1) != find(p2)) {
				union(p1, p2);
			}
			System.out.println(Arrays.toString(parent));
		}

		System.out.println("==========");
		
		int[] min = new int[N + 1];
		Arrays.fill(min, Integer.MAX_VALUE);

		// 각 트리 내의 최소값 찾기
		for (int i = 1; i <= N; ++i) {
			int set = find(i);
			min[set] = min[set] > cost[i] ? cost[i] : min[set];
			System.out.println(Arrays.toString(min));
		}

		// 최소값들 모두 합하기
		for (int i = 1; i <= N; ++i) {
			if (min[i] != Integer.MAX_VALUE) {
				ans += min[i];
			}
		}

		if (ans <= K)
			System.out.println(ans);
		else
			System.out.println("Oh no");
	}

	static void union(int p1, int p2) {
		int a = find(p1);
		int b = find(p2);

		if (rank[a] < rank[b]) {
			parent[a] = b;
		} else {
			parent[b] = a;

			if (rank[a] == rank[b]) {
				rank[a]++;
			}
		}

	}

	static int find(int x) {
		if (parent[x] == x)
			return x;

		return parent[x] = find(parent[x]);
	}
}