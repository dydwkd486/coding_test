import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,n_list[][],stack[];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		n = Integer.parseInt(br.readLine());
		n_list = new int[n][2];
		stack = new int[n+1];
		for (int i = 0; i < n_list.length; i++) {
			token = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(token.nextToken());
			int p = Integer.parseInt(token.nextToken());
			n_list[i][0] = t;
			n_list[i][1] = p;
		}
//		print();
		// 초과 분은 0으로 변경하기
		for (int i = 0; i < n_list.length; i++) {
			if(n_list[n-i-1][0]>i+1) {
//				System.out.println(n_list[n-i-1][0]);
				n_list[n-i-1][1]=0;
			}
		}
//		print();
		for (int i = 0; i < n_list.length; i++) {
			int temp = i+n_list[i][0];
			if(temp<=n) {
				if(stack[i+n_list[i][0]]<n_list[i][1]+stack[i]) {
					stack[i+n_list[i][0]] = n_list[i][1]+stack[i];				
				}
			}

			if(stack[i]>stack[i+1]) {
				stack[i+1] = stack[i];
			}
		}
//		System.out.println(Arrays.toString(stack));
		System.out.println(stack[n]);
		
	}
	
	static void print() {
		for (int i = 0; i < n_list.length; i++) {
			System.out.println(n_list[i][0]+":"+n_list[i][1]);
		}
		System.out.println();
	}
}
