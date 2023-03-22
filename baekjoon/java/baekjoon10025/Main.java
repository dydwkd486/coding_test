package baekjoon10025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] graph = new int[1000001];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int max = 0;
		long sum = 0;
		int start = 0;
		long answer = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			int pos = Integer.parseInt(st.nextToken());
			max = Math.max(max, pos);
			graph[pos] = cnt;
		}
		for (int i = 0; i < (K * 2) + 1 && i <= 1000000; i++) {
			sum += graph[i];
		}
		answer = Math.max(sum, answer);
		while (start + (K * 2)+1 < max+1) {

			sum -= graph[start];
			sum += graph[start + (K * 2)+1];

//			System.out.println(start + " " + (start + (K * 2)) + " " + sum);
			start++;
			if(sum>answer)
				answer = sum;
		}
		System.out.println(answer);

	}

}
