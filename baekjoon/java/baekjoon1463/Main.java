package baekjoon1463;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int[] n_list = new int[x+1]; 
		for (int i = n_list.length-1; i > -1; --i) {
			n_list[i]=n_list.length-i-1;
		}
		for (int i = n_list.length-1; i > 0; --i) {
			if(i%2==0) {
				if(n_list[i/2]>n_list[i]) n_list[i/2]=n_list[i]+1;
			}
			if(i%3==0) {
				if(n_list[i/3]>n_list[i]) n_list[i/3]=n_list[i]+1;
			}
			if(n_list[i-1]>n_list[i]) n_list[i-1]=n_list[i]+1;
		}
//		for (int i = 0; i < n_list.length; i++) {
//			System.out.print(i+" ");
//		}
//		System.out.println();
//		for (int i : n_list) {
//			System.out.print(i+" ");
//		}
		System.out.println(n_list[1]);
	}

}
