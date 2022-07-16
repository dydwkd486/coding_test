package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sw1946 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int T=1;T<t+1;T++) {
            int count = 0;
			System.out.println("#"+T);
			int n = Integer.parseInt(br.readLine());
			for(int i=0;i<n;i++) {
				String[] n_list = br.readLine().split(" ");
				for(int j=0;j<Integer.parseInt(n_list[1]);j++) {
					System.out.print(n_list[0]);
					count+=1;
					if(count==10) {
						System.out.println();
						count=0;
					}
				}
				
			}
            System.out.println();
		}
		
	}
}

