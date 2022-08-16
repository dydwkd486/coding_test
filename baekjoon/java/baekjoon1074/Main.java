package baekjoon1074;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int count;
	static int[][] graph;
	static int r,c;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] token = br.readLine().split(" ");
		int n= Integer.parseInt(token[0]);
		r= Integer.parseInt(token[1]);
		c= Integer.parseInt(token[2]);
		recursion(0,(int)Math.pow(2,n));

	}
	static void recursion(int idx,int cnt) {
		if(cnt == 1) {
			System.out.println(idx);
		}
		else {
			int temp = cnt/2;
			if(cnt/2>r && cnt/2>c) {
				recursion(idx+temp*temp*0,temp);
			}
			else if(cnt/2>r && cnt>c) {
				c-=temp;
				recursion(idx+temp*temp*1,temp);
			}
			else if(cnt>r && cnt/2>c) {
				r-=temp;
				recursion(idx+temp*temp*2,temp);
			}
			else {
				r-=temp;
				c-=temp;
				recursion(idx+temp*temp*3,temp);
			}
		}
	}
}
