package baekjoon11057;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n,n_list[],result;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		n_list = new int[10];
		for (int i = 0; i < n_list.length; i++) {
			n_list[i]=1;
		}
		for (int i = 1; i < n; i++) {
			int temp = 0;
			for (int j = 0; j < n_list.length; j++) {
				temp+=n_list[j]%10007;
				n_list[j] = temp;
				
			}
		}
//		System.out.println(Arrays.toString(n_list));
		for (int i = 0; i < n_list.length; i++) {
			result+=n_list[i];
		}
		System.out.println(result%10007);
	}

}
