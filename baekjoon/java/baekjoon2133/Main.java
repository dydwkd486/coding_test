package baekjoon2133;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static long[] n_list = new long[30];
	public static void main(String[] args) throws Exception{ 
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if(n%2==1) {
			System.out.println(0);
			return;
		}
		n_list[0] = 1;
		for (int i = 1; i < n_list.length; i++) {
			n_list[i] = n_list[i-1]*3;
			for (int j = 2; j <= i; j++) {
				n_list[i]+=n_list[i-j]*2;
			}
		}
//		System.out.println(Arrays.toString(n_list));
		System.out.println(n_list[(n/2)]);
	}

}
