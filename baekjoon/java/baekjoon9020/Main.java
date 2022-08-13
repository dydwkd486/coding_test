package baekjoon9020;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 소수 만들기
		boolean[] prime = new boolean[10001];
		prime[0]=true;
		prime[1]=true;
		for (int i = 2; i*i <= 10000; i++) {
			if(prime[i]) {
				continue;
			}
			for (int j = i*i; j <= 10000; j+=i) {
				prime[j] =true;
			}
		}
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int mid = n/2;
			
			while(true) {
				if(!prime[mid] && !prime[n-mid]) {
					sb.append(mid).append(" ").append(n-mid).append("\n");
					break;
				}
				mid--;
			}
		}
		System.out.println(sb);
	}

}
