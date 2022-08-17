package baekjoon1946;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	static int[] employees;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t =Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());
			employees = new int[n];
			for (int i = 0; i < n; i++) {
				String[] temp =br.readLine().split(" ");
				employees[Integer.parseInt(temp[0])-1] = Integer.parseInt(temp[1]);
			}
			int min = employees[0];
			int count = 1;
			for (int i = 1; i < n; i++) {
				if(employees[i]<min) {
					min = employees[i];
					count++;
				}
			}
			System.out.println(count);
		}
		
	}

}
