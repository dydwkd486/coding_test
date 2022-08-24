package baekjoon1759;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int l,c;
	static char[] c_list;
	static char[] ans;
	static String[] vowels = new String[] {"a","e","i","o","u"};
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		l = Integer.parseInt(token.nextToken());
		c = Integer.parseInt(token.nextToken());
		c_list = new char[c];
		ans = new char[l];
		token = new StringTokenizer(br.readLine());
		for (int i = 0; i < c; i++) {
			c_list[i] = token.nextToken().charAt(0);
		}
		Arrays.sort(c_list);
//		System.out.println(Arrays.toString(c_list));
		
		combination(0,0);
	}
	static void combination(int idx,int cnt) {
		if(cnt==l) {
			StringBuilder sb = new StringBuilder();
			for (char c : ans) {
				sb.append(c);
			}
			int temp = 0;
			for (int i = 0; i < 5; i++) {
				if(sb.toString().contains(vowels[i])) {
					temp++;
				}
			}
			if(temp!=0 && cnt - temp >= 2)	print();
			return;
		}
		for (int i = idx; i < c; i++) {
			ans[cnt] = c_list[i];
			combination(i+1, cnt+1);
			
		}
		
	}
	static void print() {
		for (char c : ans) {
			System.out.print(c);
		}
		System.out.println();
	}
}
