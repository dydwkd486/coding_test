package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sw2063 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] result = br.readLine().split(" ");
		int[] n_list = new int[result.length];
		for(int i=0;i<n;i++) {
			n_list[i]=Integer.parseInt(result[i]);
		}
		Arrays.sort(n_list); // 정렬 (내림 차순은 Collections.reverseOrder())
		System.out.println(n_list[(int)n/2]);
	}
}
