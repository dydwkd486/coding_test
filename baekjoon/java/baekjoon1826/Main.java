package baekjoon1826;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n,curP,curO,count,maxPosition;
	static PriorityQueue<OilStore> queue;
	static class OilStore implements Comparable<OilStore>{
		int position;
		int oil;
		
		public OilStore(int position, int oil) {
			super();
			this.position = position;
			this.oil = oil;
		}

		@Override
		public int compareTo(OilStore o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.position,o.position);
		}
		
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		queue = new PriorityQueue<>();
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(token.nextToken()); // 위치
			int b = Integer.parseInt(token.nextToken()); // 기름
			queue.add(new OilStore(a, b));
		}
		token = new StringTokenizer(br.readLine());
		maxPosition = Integer.parseInt(token.nextToken());
		curP = Integer.parseInt(token.nextToken());
		PriorityQueue<Integer> fuels = new PriorityQueue<>(Collections.reverseOrder());
		while(curP<maxPosition) {
			while (!queue.isEmpty() && queue.peek().position <=curP) { // 현재 위치에서 주유소 까지 갈 수 있는 경우
					fuels.add(queue.poll().oil); // 들렸다고 치자
			}
			if(fuels.isEmpty()) {
				System.out.println(-1);
				return;
			}
			count++;
			curP += fuels.poll();
		}
		System.out.println(count);	
	}
	static void print() {
		for (OilStore i : queue) {
			System.out.println(i.position+":"+i.oil);
		}
		
	}
}
