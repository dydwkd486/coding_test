package baekjoon12015;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,n_list[],stack[],lastCount;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		n_list = new int[n];
		stack = new int[n];
		
		StringTokenizer token = new StringTokenizer(br.readLine()," ");
		
		for (int i = 0; i < n; i++) {
			n_list[i]=Integer.parseInt(token.nextToken());
		}
		
		stack[0] = n_list[0];
		lastCount =1;
		
		for (int i = 1; i < n; i++) {
			int key = n_list[i];
			if(stack[lastCount-1]<key) {
				lastCount++;
				stack[lastCount-1] = key;
			}
			else {
				stack[bin(key)] = key;
			}
		}
//		System.out.println(Arrays.toString(stack));
		System.out.println(lastCount);
	} // end main
	static int bin(int target) {
		int start = 0;
		int end = lastCount;
		int mid = (start+end)/2;
		while(start<end) {
			mid = (start + end)/2 ;
			if(stack[mid]<target)
				start = mid+1;
			else {
				end = mid;
			}
		}
		return start;
	}

}
