package Baekjoon3040;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] number;
	static int[] n_list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n_list = new int[9];
		number = new int[7];
		for (int i = 0; i < 9; i++) {
			n_list[i] = Integer.parseInt(br.readLine());
		}
		permutation(0, 0);
	}
	static void permutation(int idx, int isSelect) {
		if(7==idx) {
			int sum =0;
			for (int i = 0; i < number.length; i++) {
				sum+=number[i];
			}
			if(sum==100) {
				for (int i = 0; i < number.length; i++) {
					System.out.println(number[i]);
				}
				System.exit(0);
			}
			return;
		}
		for (int i = idx; i < 9; i++) {
			if((isSelect & 1<<i) !=0) continue;
			number[idx]=n_list[i];
			permutation(idx+1, isSelect| 1<<i);
		}
	}
}
