package baekjoon13335;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		Queue<Integer> truck = new LinkedList<Integer>();
		st = new StringTokenizer(br.readLine());
		for(int i= 0; i< n; i++) {
			truck.offer(Integer.parseInt(st.nextToken()));
		}
		int time = 0; 
		int bw=0;
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i =0; i<w ; i++) {
			q.add(0);
		}
		while(!q.isEmpty()) {
			time++;
			bw-=q.poll();
			if(!truck.isEmpty()) {
				if(truck.peek()+bw<=L) {
					bw+=truck.peek();
					q.offer(truck.poll());
				}else {
					q.offer(0);
				}
			}
		}
		System.out.println(time);
	}
}

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main {
//	static int n,w,L,time;
//	static int[] n_list;
//	public static void main(String[] args) throws Exception{
//		// TODO Auto-generated method stub
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer token = new StringTokenizer(br.readLine());
//		n = Integer.parseInt(token.nextToken());
//		w = Integer.parseInt(token.nextToken());
//		L = Integer.parseInt(token.nextToken());
//		n_list = new int[n];
//		token = new StringTokenizer(br.readLine());
//		for (int i = 0; i < n; i++) {
//			n_list[i] = Integer.parseInt(token.nextToken());
//		}
//		// 입력 완료
//		int sum =0;
//		for (int i = 0; i < n; i++) {
//			int temp = n_list[i];
//			int temp_sum = w;
//			int temp_count=1;
//			if(i+1 == n) {
//				sum+=temp_sum;
//				break;
//			}
//			while(temp+n_list[i+1]<=L) {
//				temp+=n_list[i+1];
//				temp_sum++;
//				i++;
//				temp_count++;
//				if(i>n-2) break;
//				if(temp_count>w) break;
//			}
//			sum+=temp_sum;
//		}
//		System.out.println(sum+1);
//	}
//
//}
