package no3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int t,n,n_list[],n_solved[],n_re_solved[],result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			n_list = new int[n];
			result = Integer.MAX_VALUE;
			token = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				n_list[i] = Integer.parseInt(token.nextToken());
			}
			n_solved = n_list.clone();
			n_re_solved = n_list.clone();
			Arrays.sort(n_solved);
			for (int i = 0; i < n_solved.length; i++) {
				n_re_solved[i] = n_solved[n_solved.length-i-1];
			}
			shuffle(n_list,0);
			if(result == Integer.MAX_VALUE) {
				System.out.println("#"+tc+" "+-1);
			}
			else {
				System.out.println("#"+tc+" "+result);				
			}
		}// end tc
	} // end main
	static void shuffle(int[] graph,int cnt) {
		if(Arrays.equals(graph, n_solved) || Arrays.equals(graph, n_re_solved)) {
//			System.out.println(Arrays.toString(graph));
//			System.out.println(cnt);
			result = Math.min(result, cnt);
		}
		if(cnt==5) {
			return;
		}
		int[] tempGraph = graph.clone();
		int count = graph.length/2;
		for (int i = 1; i <= count; i++) {
			for (int j = 0; j < i; j++) {
				int temp = tempGraph[count-i+(j*2)];
				tempGraph[count-i+(j*2)] = tempGraph[(count-i+(j*2))+1];
				tempGraph[(count-i+(j*2))+1] = temp;
			}
//			System.out.println(Arrays.toString(tempGraph));
			shuffle(tempGraph,cnt+1);
		}
		
		for(int i = count-1; i>0; --i) {
			for (int j = 0; j < i; j++) {
				int temp = tempGraph[count-i+(j*2)];
				tempGraph[count-i+(j*2)] = tempGraph[(count-i+(j*2))+1];
				tempGraph[(count-i+(j*2))+1] = temp;
			}
//			System.out.println(Arrays.toString(tempGraph));
			shuffle(tempGraph,cnt+1);
		}
//		System.out.println();
	}
}
