package week_11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_수문_5638 {
	static StringBuilder sb = new StringBuilder();
	static ArrayList<gate> Arr = new ArrayList();
	static int N, M, F, C, V , T, ans , cnt;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Arr.add(new gate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		M = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < M; i++) {
			++cnt;
			ans = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());  
			T = Integer.parseInt(st.nextToken());      /// 입력
			comb();
		}
		System.out.println(sb.toString());
		

	}
	
	static void comb() {
		
		for(int i = 1; i < 1 << N; i++) { //수문 갯수 N 
			int sum = 0;  //  물 비울 수 있는지 체크 변수
			int cost = 0;  //  피해 비용
			for(int j = 0; j < N; j++) { // 비트마스킹 
				if((i & (1 << j)) != 0 ) {     
					if(cost >= ans) break; // 가지치기
					sum+= Arr.get(j).f * T;
					cost += Arr.get(j).c;
				}
			}
			if(sum >= V) {
				ans = Math.min(ans, cost);
			}
		}
		if(ans == Integer.MAX_VALUE) sb.append("Case ").append(cnt).append(": IMPOSSIBLE").append("\n");
		else sb.append("Case ").append(cnt).append(": ").append(ans).append("\n");
	}
	
	static class gate{
		int f, c;
		
		public gate(int f, int c) {
			this.f = f;
			this.c = c;
		}
	}

}
