package baekjoon4811;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static long n_list[];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			n = Integer.parseInt(br.readLine());
			if(n==0) {
				break;
			}	
			n_list =new long[n+1];
			n_list[0] = 1;
			for (int j = 1; j < n+1; j++) {
				for (int i = 0; i < j; i++) {
					n_list[j]+= n_list[i]*n_list[j-1-i];
				}
			}
			System.out.println(n_list[n]);
		}
	}

}
