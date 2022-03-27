package algo.day0326;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BJ1011_flymetothealphacentauri {

	static int T, x, y;
	static int distance;
	static int max_move;
	static int count;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			distance = y - x;
			max_move = (int) Math.sqrt(distance); // 1 4 9 16... 기준으로 바뀜
			
			count = 0;
			
			if( distance == max_move * max_move) {
				count = max_move*2 - 1;
			} else if( distance - ( max_move * max_move) <= max_move ) {
				count = max_move*2;
			} else if ( distance - ( max_move * max_move) > max_move ) {
				count = max_move*2 + 1;
			}
			
			System.out.println(count);
		}
	}

}
