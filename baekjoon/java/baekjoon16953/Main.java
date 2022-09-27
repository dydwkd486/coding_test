package baekjoon16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int result = -1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] token = br.readLine().split(" ");
		long a= Integer.parseInt(token[0]);
		long b= Integer.parseInt(token[1]);
		dfs(a,b,0);
		System.out.println(result);
	}
	static void dfs(long a,long b,int count) {
		if(a>b) {
			return;
		}
		if(a==b) {
			if(result ==-1) {
				result = count+1;
			}
			else {
				result = Math.min(count+1, result);
			}
			return;
		}
		dfs(a*2,b,count+1);
		dfs((a*10)+1,b,count+1);
	}
}
