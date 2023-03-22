package baekjoon1644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	// baekjoon 1644
	static boolean prime[];
	static ArrayList<Integer> prime_numbers = new ArrayList<>(); 
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int N = Integer.parseInt(br.readLine());
		prime = new boolean[N+1];
		int start = 0, end = 0, sum=0;
		int answer =0;
		// 먼서 소수를 찾기
		prime[0]=prime[1]=true;
		for(int i=2;i*i<=N;i++) {
			if(!prime[i]) {
				for(int j=i*i;j<=N;j+=i) prime[j]=true;
			}
		}
		for(int i=0;i<=N;i++) {
			if(!prime[i]) prime_numbers.add(i);
		}
//		System.out.println(prime_numbers);
		int len= prime_numbers.size();
		// 이제 합치면서 개수 확인하기
		while(start<len) {
			if(sum>N || end==len) {
				sum-=prime_numbers.get(start++);
			}
			else {
				sum+=prime_numbers.get(end++);
			}
			if(sum==N) {
				answer++;
			}
		}
		System.out.println(answer);
	}

}
