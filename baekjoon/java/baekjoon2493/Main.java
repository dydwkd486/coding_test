import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(token.nextToken());
		int[] n_list = new int[n];
		int[] result = new int[n];
		token = new StringTokenizer(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n_list.length; i++) {
			n_list[i] = Integer.parseInt(token.nextToken());
		}

		for (int i = 0; i < n_list.length; i++) {
			int count = n_list.length - 1 - i;
			while (!stack.empty() && n_list[count] > n_list[stack.peek()]) {
				result[stack.pop()] = count+1;
			}
			stack.push(count);
		}

		for (int i = 0; i < result.length; i++) {
			sb.append(result[i] + " ");
		}
		System.out.print(sb);
	}
}
