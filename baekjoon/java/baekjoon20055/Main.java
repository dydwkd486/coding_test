package baekjoon20055;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int n,k,zeroCount,result;
	static Stack<Integer> n_list = new Stack<>();
	static ArrayList<Integer> robot_list = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		n = Integer.parseInt(token.nextToken());
		k = Integer.parseInt(token.nextToken());
		zeroCount = 0;
		result=1;
		token = new StringTokenizer(br.readLine());
		for (int i = 0; i < n*2; i++) {
			n_list.add(Integer.parseInt(token.nextToken()));
		}
		for (int i = 0; i < n; i++) {
			robot_list.add(0);
		}
		
		for (;;) { // 조건 4
			// 조건 1
			// 벨트 이동
			n_list.add(0, n_list.pop());
			// 같이 로봇도 이동
			robot_list.remove(n-1); // 끝에 있는 값 제거
			robot_list.add(0,0); // 처음 값 넣기
			robot_list.set(n-1, 0); // 이동한 마지막 값 0으로 변경
			
			// 조건 2 - 로봇이 움직여서 앞으로 이동
			for (int i = n-2; i >=0; --i) {
				if(robot_list.get(i)!=0) {
					if(robot_list.get(i+1)==1) continue;
					if(n_list.get(i+1)==0) continue;
					robot_list.set(i+1, 1); // 앞으로 이동
					robot_list.set(i, 0); // 현재 값 0으로 변경
					n_list.set(i+1, n_list.get(i+1)-1); // 값 1개 줄이기
					if(n_list.get(i+1)==0) {
						zeroCount++;
					}
				}
			}
			// 조건 3 - 로봇 올리기
			if(n_list.get(0)!=0) {
				robot_list.set(0, 1); // 로봇 올림
				n_list.set(0, n_list.get(0)-1); // 값 1개 줄이기
				if(n_list.get(0)==0) {
					zeroCount++;
				}
			}
			
//			System.out.println(n_list);
//			System.out.println(robot_list);
			if(zeroCount>=k) {
				break;
			}
			else {
				result++;
			}
			
		}
		
		System.out.println(result);

	}

}
