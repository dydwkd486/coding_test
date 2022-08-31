package baekjoon1166;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long n,l,w,h;
	static double result;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		n = Long.parseLong(token.nextToken());
		l = Long.parseLong(token.nextToken());
		w = Long.parseLong(token.nextToken());
		h = Long.parseLong(token.nextToken());
		result = Math.max(l, w);
		result = Math.max(result, h);
		
		Double start = 0.0;
		Double end = result*2;
		
		for (int i = 0; i < 50000; i++) {
			Double mid = (start+end)/2;
			long target = (long)(l/mid)*(long)(w/mid)*(long)(h/mid);
			if(n<=target) {
				start = mid;
			}
			else {
				end = mid;
			}
		}
	System.out.println(start);
	}

}
