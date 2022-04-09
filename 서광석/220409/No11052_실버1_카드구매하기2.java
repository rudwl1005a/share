package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No11052_실버1_카드구매하기2 {

	static int N, max;
	static int[] price;
	static int[] memoi;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		price = new int[N+1];
		memoi = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i <= N; i++) {
			int n = Integer.parseInt(st.nextToken());
			price[i] = n;
		}
		
		memoi[1] = price[1];
		
		for(int i = 2; i <= N; i++) {
			memoi[i] = price[i];
			for(int j = 0; j <= i/2; j++) {
				memoi[i] = Math.max(memoi[j] + memoi[i-j], memoi[i]);
			}
		}
		
		System.out.println(memoi[N]);
	}

}
