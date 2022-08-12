package Sw5432;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			String[] n = br.readLine().split("");
			int temp = 0;
			int result =0;
			for (int i = 1; i < n.length; i++) {
				if(n[i].equals("(")) {
					temp++;
				}
				else {
					if(n[i-1].equals("(")) {
						result+= temp;
					}
					else {
						result++;
					}
					temp--;
				}
			}
			sb.append("#").append(tc);
			sb.append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}
