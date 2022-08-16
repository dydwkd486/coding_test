package baekjoon2839;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] n_list = new int[n+5];
		for (int i = 0; i < n_list.length; i++) {
			n_list[i]=5001;
		}
		n_list[3] =1;
		n_list[5] = 1;
			for (int i = 6; i < n_list.length; i++) {

			n_list[i] = Math.min(n_list[i-5], n_list[i-3])+1;
				
			}
//		System.out.println(Arrays.toString(n_list));
		if(n_list[n]<5000) {
			System.out.println(n_list[n]);			
		}
		else {
			System.out.println(-1);
		}
	}
}
