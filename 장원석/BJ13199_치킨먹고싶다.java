package algo.day0402;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

public class BJ13199_치킨먹고싶다 {
	
	static int T, p, m, f, c;
	static int dn, dang, cu;
	static StringTokenizer st;

	public static void main(String[] argc) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			f = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			dang = (m / p) + ((m / p) * c) / f;
			dn = m / p;
			cu = ( m / p ) * c;
			
			if( cu >= f ) {
				dn += ( cu - f ) / ( f - c ) + 1;
			}
			
			System.out.println(dn - dang);
		}

	}
}
