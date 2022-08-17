package baekjoon1541;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] n = br.readLine().split("-");
		int sum = 0;
		
		for (String string2 : n[0].split("\\+")) {
			sum+=Integer.parseInt(string2);
		}
		for (int i = 1; i < n.length; i++) {
			for (String string2 : n[i].split("\\+")) {
				sum-=Integer.parseInt(string2);
			}
		}
		System.out.println(sum);
		
	}

}
