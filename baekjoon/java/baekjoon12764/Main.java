package baekjoon12764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	// baekjoon12764
	static class Node{
		int start, end,room;

		public Node(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, P, Q;
	static PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)->(Integer.compare(o1.start,o2.start)));
	static PriorityQueue<Node> rooms = new PriorityQueue<>((o1,o2)->(Integer.compare(o1.end,o2.end)));
	static PriorityQueue<Integer> candidates = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		N = Integer.parseInt(br.readLine());
		int roomNo = 0;
		int[] roomCnt = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			q.add(new Node(s, e));
		}
		while(!q.isEmpty()) {
			Node now = q.poll();
			while(!rooms.isEmpty() && rooms.peek().end<now.start) {
				candidates.add(rooms.poll().room);
			}
			
			int selectedRoomNo = candidates.isEmpty() ? roomNo++ : candidates.poll();
			roomCnt[selectedRoomNo]++;
			now.room = selectedRoomNo;
			rooms.add(now);

		}
		int cnt = 0;
		for (int i = 0; i <N && roomCnt[i]!=0; i++,cnt++) {
			sb.append(roomCnt[i]).append(" ");
		}
		System.out.println(cnt);
		System.out.println(sb);
	}

}
