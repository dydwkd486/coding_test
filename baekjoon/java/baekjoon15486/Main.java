package baekjoon15486;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
	static int n;
	static long n_list[][];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		n_list = new long[15000000][2];
		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split(" ");
			n_list[i][0]= Integer.parseInt(temp[0]);
			n_list[i][1]= Integer.parseInt(temp[1]);
		}
		for (int i = 0; i < n; i++) {
			if(n_list[n-1-i][0]>i+1) {
				n_list[n-1-i][0] = 0;
				n_list[n-1-i][1] = 0;
			}
		}
		
//		for (int[] i : n_list) {
//			System.out.println(Arrays.toString(i));
//		}
//		System.out.println();
		
		for (int i = 1; i < n; i++) {
			int time = (int) n_list[n-1-i][0];
			if((n_list[n-1-i+time][1]+n_list[n-1-i][1])>n_list[n-1-i+1][1]) {
				n_list[n-1-i][1] = n_list[n-1-i+time][1]+n_list[n-1-i][1];		
			}
			else {
				n_list[n-1-i][1] = n_list[n-1-i+1][1];
			}
		}
//		for (int[] i : n_list) {
//			System.out.println(Arrays.toString(i));
//		}
//		System.out.println();
		System.out.println(n_list[0][1]);
	}

}
