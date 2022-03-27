package 실시간;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1011_골드5_Fly_me_to_the_AlphaCentauri {

	static int T, cnt;
	static long F, D;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			F = Long.parseLong(st.nextToken());
			D = Long.parseLong(st.nextToken());
			
			cnt = 0;
			int start = 1;
			
			while(F < D) {
				
				if(D-F == start) {
					F += start;
					cnt++;
					start++;
					continue;
				} else if(D-F < start) {
					cnt--;
					start--;
				}
				
				F += start;
				D -= start;
				cnt += 2;
				
				start++;
			}
			
			System.out.println(cnt);
			
		}

	}

}
