package baekjoon2230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	//baekjoon 2230
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		Long[] a = new Long[n];
		int start=0, end=0;
		long sum=0;
		long answer = Long.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			a[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(a); //한번만 정렬?
		
		while(start<n && end<n) {
			sum = Math.abs(a[start]-a[end]);
			if(sum<m) {
					start++;
			}
			else {
				answer = Math.min(answer, sum);
				end++;
			}
		}
		System.out.println(answer);
		
		
		
//		System.out.println(n);
//		System.out.println(m);
//		for (long l : a) {
//			System.out.println(l);
//		}
		
	}

}
