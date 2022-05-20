import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class No9935_골드4_문자열폭발2 {

	static Stack<Character> stack = new Stack<>();
	static char[] str;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		str = br.readLine().toCharArray();
		for(int i = 0; i < input.length(); i++) {
			stack.push(input.charAt(i));
			
			if(stack.size() >= str.length) {
				boolean isBomb = true;
				
				for(int j = 0; j < str.length; j++) {
					if(stack.get(stack.size() - str.length + j) != str[j]) {
						isBomb = false;
						break;
					}
				}
				
				if(isBomb) {
					for(int j = 0; j < str.length; j++) {
						stack.pop();
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(char c : stack) {
			sb.append(c);
		}
		System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
		
		

	}

}
