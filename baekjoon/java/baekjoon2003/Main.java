package baekjoon2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// baekjoon2003
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Long M = Long.parseLong(st.nextToken());
		int num[] = new int[N];
		int start=0, end=0;
		long sum=0;
		int answer=0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < num.length; i++) {
			num[i]=Integer.parseInt(st.nextToken());
		}
		while(start<N) {
			// 먼저 크면
			if(sum>M || end==N) {
				sum-=num[start++];
			}
			else { // 작거나 같은 경우
				sum+=num[end++];
			}
			if(sum==M) {
				answer++;
			}
		}
		System.out.println(answer);
	}

}