package baekjoon2075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
			
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					
					pQ.add(Integer.parseInt(st.nextToken()));
				}

		}
		for(int i=0;i<n*n-n;i++) {
			pQ.remove();
		}
		System.out.println(pQ.remove());
		
		
		

	}

}
