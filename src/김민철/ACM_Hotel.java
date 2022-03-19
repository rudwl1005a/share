package day1;

import java.util.Scanner;

public class ACM_Hotel {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
//		String buffer;
//		buffer = sc.nextLine();
		//System.out.println(T);
		
//		System.out.println();
		for(int i = 0 ; i < T; i++) {
			System.out.println();
			int height = sc.nextInt();
			int width = sc.nextInt();
			int guestnum = sc.nextInt();
			
			// 나머지 0 일경우에 반례 찾기 
			int result = (guestnum % height) * 100 + (guestnum / height) + 1;
			System.out.print(result);
		
			
		}

	}

}
