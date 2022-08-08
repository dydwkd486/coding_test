package bj6064;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(token.nextToken()), n = Integer.parseInt(token.nextToken()), 
					x = Integer.parseInt(token.nextToken())-1, y = Integer.parseInt(token.nextToken())-1; 
			int count = x;
			int result=-1;
			while(count<n*m) {
				if(count%n == y) {
					result = count+1;
					break;
				}
				count +=m;
			}
			System.out.println(result);
		}
	}
}
