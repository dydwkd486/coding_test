package baekjoon1339;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int n,result=0;
	static String n_list[][];
	static HashMap<String,Integer> n_dic = new HashMap<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		n_list = new String[n][];
		for (int i = 0; i < n; i++) {
			String[] token = br.readLine().split("");
			n_list[i] = new String[token.length];
			for (int j = 0; j < token.length; j++) {
				n_list[i][j] = token[j];			
			}
		}
		// 입력 완료
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n_list[i].length; j++) {
				if(n_dic.containsKey(n_list[i][j])) {
					n_dic.put(n_list[i][j], (int) (n_dic.get(n_list[i][j])+Math.pow(10, (n_list[i].length-j-1))));
				}
				else {
					n_dic.put(n_list[i][j], (int) Math.pow(10, (n_list[i].length-j-1)));
				}
			}
		}
		Integer[] n_dic_list =new Integer[n_dic.size()];
		for (int i = 0; i < n_dic_list.length; i++) {
			n_dic_list[i] = (Integer) n_dic.values().toArray()[i];
		}
		Arrays.sort(n_dic_list,Collections.reverseOrder());
		int count = 9;
		for (int i : n_dic_list) {
			result+= count*i;
			count-=1;	
		}
		System.out.println(result);
	} // end main

}
