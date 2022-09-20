package baekjoon1715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static int n,sum;
	static PriorityQueue<Integer> q = new PriorityQueue<>();
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			q.add(Integer.parseInt(br.readLine()));
		}
		if(q.size()==1) {
			sum = 0;
		}
		else {
			while(q.size()>1) {
				int a = q.poll();
				int b = q.poll();
				sum+=a+b;
				q.add(a+b);
			}
		}
		System.out.println(sum);
	}// end main

}
