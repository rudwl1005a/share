import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class No1918_골드3_후위표기식 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] charArr = br.readLine().toCharArray();
		
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for(char c : charArr) {
			if(c == '*' || c == '/') {
				while(!stack.isEmpty()) {
					int top = stack.get(stack.size()-1);
					if(top == '(' || top == '+' || top == '-') break;
					
					sb.append(stack.pop());
				}
			} else if(c == '+' || c == '-') {
				while(!stack.isEmpty()) {
					int top = stack.get(stack.size()-1);
					if(top == '(') break;
					
					sb.append(stack.pop());
				}
			} else if(c == ')') {
				while(!stack.isEmpty()) {
					int top = stack.get(stack.size()-1);
					if(top == '(') break;
					
					sb.append(stack.pop());
				}
				stack.pop();
				continue;
			}
			
			stack.push(c);
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb.toString());
		

	}

}
