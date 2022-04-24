package week_12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_평범한배낭_12865 {
	
	static int N, K , ans;
	static int[][] dp;
	static int[] W, V;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		W = new int[N]; 
		V = new int[N];
		dp = new int[N][K+1];
		for(int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(napsack(N-1, K));
//		bottomup();
		System.out.println(ans);
	}
	
	static int napsack(int i , int k) {
		
		if(i < 0)   // 인덱스 범위 벗어나니깐 리턴 0
			return 0;
		
		if(dp[i][k] == 0) { // 아직 방문 X 
			
			if(W[i] > k) {
				dp[i][k] = napsack(i-1, k); 
			}
			
			else {
				dp[i][k] = Math.max(napsack(i-1, k), napsack(i-1, k - W[i]) + V[i]); // 이전꺼랑 / 이전 + 현재  
			}
		}
		return dp[i][k];
	}
	
	
	
	
	
	
	
	
	
	
	
	static void bottomup(){
		
		int[] dp2 = new int[K+1];
		
		for(int i = 0; i < N; i++) {
			for(int j = K; j - W[i] >= 0; j--) {
				dp2[j] = Math.max(dp2[j], dp2[j- W[i]] + V[i]);
			}
		}
		ans = dp2[K];
	}


}
