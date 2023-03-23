package baekjoon2960;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	// baekjoon 2960
	static int N, K;
	static boolean[] num;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		num = new boolean[N + 1];
		int count = 0;
		int answer = 0;

		num[0] = num[1] = true;
		a: for (int k = 2; k < N + 1; k++) {
			if (!num[k]) {
				for (int j = k; j < N + 1; j += k) {
					if (num[j]) {
						continue;
					}
					num[j] = true;
					count++;
//					System.out.println(j);
					if (count == K) {
						answer = j;
						break a;
					}
				}
			}
		}
//		System.out.println(Arrays.toString(num));
		System.out.println(answer);

	}

}
