package baekjoon2110;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
5 3
1
2
8
5
9
1 2 5 8 9
 * */

public class Main {
	static int n,c,x[],result; 
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		n = Integer.parseInt(token.nextToken());
		c = Integer.parseInt(token.nextToken());
		x = new  int[n];
		for (int i = 0; i < n; i++) {
			x[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(x); // 정렬
		
		int start= 1, end= x[n-1]-x[0];
		
		bin(start,end);

		System.out.println(result);
	}
	static int bin(int start,int end) {
		int mid = (start+end)/2;
		while(start<=end) {
			mid = (start+end)/2;
			int current = x[0];
			int count = 1;
			for (int i = 1; i < n; i++) {
				if(x[i]>= current+mid) {
					count++;
					current = x[i];
				}
			}
			if(count>=c) {
				result = mid;
				start = mid+1;
			}
			else {
				end = mid-1;
			}

		}
		return result;
	}
}
