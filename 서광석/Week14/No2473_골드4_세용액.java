import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2473_골드4_세용액 {

	static int N;
	static long min;
	static long[] input;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		input = new long[N];
		for(int i = 0; i < N; i++) {
			input[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(input);
		
		min = Long.MAX_VALUE;
		String ans = "";
		
		for(int i = 0; i < N; i++) {
			int left = i+1;
			int right = N-1;
			
			while(left < right) {
				long sum = input[i] + input[left] + input[right];
				
				if(sum == 0) {
					System.out.println(input[i] + " " + input[left] + " " + input[right]);
					return;
				}
				
				long abs = Math.abs(sum);
				if(min > abs) {
					ans = input[i] + " " + input[left] + " " + input[right];
					min = abs;
				}
				
				if(sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}
		
		System.out.println(ans);

	}

}
