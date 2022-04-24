package week_12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_내려가기_2906 {
	
	static int N;
	static int max[], min[];
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		max = new int[3];
		min = new int[3];
		
		StringTokenizer st;
		for(int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
				
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int n3 = Integer.parseInt(st.nextToken());
			
			if(i == 0) {
				max[0] = n1;
				max[1] = n2;
				max[2] = n3;
				
				min[0] = n1;
				min[1] = n2;
				min[2] = n3;
			}
			
			else {
				int tmpmax = max[0];
				int tmpmax2 = max[2];
				
				max[0] = n1+ Math.max(max[0], max[1]);
				max[2] = n3 + Math.max(max[2], max[1]);
				max[1] = n2 + Math.max(max[1], Math.max(tmpmax, tmpmax2));
				
				
				int tmpmin = min[0];
				int tmpmin2 = min[2];
				min[0] = n1 + Math.min(min[0], min[1]);
				min[2] = n3 + Math.min(min[2], min[1]);
				min[1] = n2 + Math.min(min[1], Math.min(tmpmin, tmpmin2));
				
			}
			
		}
		
		System.out.println(Math.max(max[0], Math.max(max[1], max[2]))+ " " + Math.min(min[0], Math.min(min[1], min[2])));
		
		

	}

}
