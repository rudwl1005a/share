package algo.day0508;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BJ1099_알수없는문장 {

	static int N, answer;
	static String word;
	static ArrayList<String> dictionary = new ArrayList<String>(50);
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		word = br.readLine();
		N = Integer.parseInt(br.readLine());
		dp = new int[word.length()];
		Arrays.fill(dp, 1000);

		for (int i = 0; i < N; i++) {
			String read = br.readLine();
			dictionary.add(read);
		}

		answer = DP(0);
		System.out.println(answer);
	}
	
	static ArrayList<String> partitionWord(String targetWord) {
		ArrayList<String> ans = new ArrayList<String>(targetWord.length());
		for (int i = 0; i < targetWord.length(); i++)
			ans.add(targetWord.substring(i, targetWord.length()));
		return ans;
	}

	static int DP(int idx) {
		System.out.println("idx : " + idx);
		
		if (idx == word.length()) {
			if (dp[word.length() - 1] == 1000)
				return -1;

			return dp[word.length() - 1];
		}

		ArrayList<String> partitionWordList = partitionWord(word.substring(0, idx + 1));

		System.out.println("리스트 " +partitionWordList.toString());

		for (int i = 0; i < partitionWordList.size(); i++) {
			String shuffleWord = partitionWordList.get(i);

			int from = i;
			//System.out.println("from: " + from);
			
			for (int j = 0; j < dictionary.size(); j++) {
				String originWord = dictionary.get(j);

				if (!compareAlphabet(shuffleWord, originWord)) {
					continue;
				}
				
				int diffWordCnt = compareWord(shuffleWord, originWord);
				System.out.println("dif word cnt " + diffWordCnt);
				
				if (from - 1 < 0) {
					dp[idx] = Math.min(dp[idx], diffWordCnt);
					continue;
				}

				dp[idx] = Math.min(diffWordCnt + dp[from - 1], dp[idx]);

			}

		}
		System.out.println(Arrays.toString(dp));
		System.out.println("-------------------------");
		return DP(idx + 1);
	}


	static boolean compareAlphabet(String comp1, String comp2) {
		
		System.out.println("compare: " + comp1 + " " + comp2);
		
		if (comp1.length() != comp2.length()) {
			return false;
		}
		
		int[] check = new int[30];
		
		for (int i = 0; i < comp1.length(); i++) {
			System.out.println(i + " " + comp1.charAt(i) + " " + comp2.charAt(i));
			check[(int) comp1.charAt(i) - (int) 'a']++;
			check[(int) comp2.charAt(i) - (int) 'a']--;
		}
		
		System.out.println(Arrays.toString(check));
		
		for (int i = 0; i < (int) 'z' - (int) 'a'; i++) {
			if (check[i] != 0)
				return false;
		}

		System.out.println("Yes " + comp2);
		return true;
	}

	static int compareWord(String comp1, String comp2) {
		int ans = 0;
		for (int i = 0; i < comp1.length(); i++) {
			if (comp1.charAt(i) != comp2.charAt(i))
				ans++;
		}
		return ans;
	}

}
