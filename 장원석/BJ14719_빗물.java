package algo.day0326;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ14719_빗물 {

	static int H, W; // height width
	static int[] height;
	static int sum = 0;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		height = new int[W];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < W - 1; i++) {  // 인덱스
			int left = 0;
			int right = 0;

			// 왼쪽
			for (int j = 0; j < i; j++) {
				left = Math.max(left, height[j]);
			}

			// 오른쪽
			for (int j = i + 1; j < W; j++) {
				right = Math.max(right, height[j]);
			}

			// 물 계산
			if (left > height[i] && right > height[i]) {
				sum += Math.min(left, right) - height[i];
			}
		}

		System.out.println(sum);
	}

}