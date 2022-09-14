package Baekjoon1263;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static Time time[];
	static class Time implements Comparable<Time>{
		int t;
		int s;
		public Time(int t, int s) {
			super();
			this.t = t;
			this.s = s;
		}
		@Override
		public int compareTo(Time o) {
			// TODO Auto-generated method stub
			if(o.s == this.s) {
				return Integer.compare(o.t, this.t);
			}
			return Integer.compare(o.s,this.s);
		}
		
		
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		n = Integer.parseInt(br.readLine());
		time = new Time[n];
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(token.nextToken());
			int s = Integer.parseInt(token.nextToken());
			time[i]= new Time(t, s);
		}
		Arrays.sort(time);
//		for (Time i : time) {
//			System.out.println(i.t+" "+i.s);
//		}
		int result = time[0].s;
		for (int i = 0; i < n; i++) {
			if(time[i].s<result) result=time[i].s;
			result -= time[i].t;
		}
		if(result<0) {
			System.out.println(-1);
		}
		else {
			System.out.println(result);
		}
	}

}
