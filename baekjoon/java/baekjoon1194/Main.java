package baekjoon1194;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n,m;
	static char graph[][];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		// 1로 갈 수 있는지 확인하기
		// 열쇠가 있는지 확인
		// 열쇠가 있다면 열곳이 있는지 확인 -> 있다면 열고 . 그위치에서 다시 시작
		// 없으면 열쇠가 있는 장소 갈수있는지 확인
		// 있으면 열쇠가지러가기
		// 없으면 -1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] token = br.readLine().split(" ");
		int n = Integer.parseInt(token[0]);
		int m = Integer.parseInt(token[1]);
		graph = new char[n][];
		for (int i = 0; i < n; i++) {
			graph[i] = br.readLine().toCharArray();
		}
		
	}

}
