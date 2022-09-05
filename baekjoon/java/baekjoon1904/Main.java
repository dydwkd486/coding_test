package baekjoon1904;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] n_list = new int[n];
		if(n==1) {
			System.out.println(1);
			return;
		}
		else if(n==2) {
			System.out.println(2);
			return;
		}
		n_list[0]=1;
		n_list[1]=2;
		for (int i = 2; i < n_list.length; i++) {
			n_list[i] = (n_list[i-2]+n_list[i-1])%15746;
		}
		System.out.println(n_list[n-1]);
	}

}
