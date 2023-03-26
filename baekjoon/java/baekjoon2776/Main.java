package baekjoon2776;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	// 이분 탐색
	// 양 끝에서 하나씩 줄여가는 형식으로 진행
	// 먼저 정렬이 되어있는 배열에서 찾아가는 형식으로 진행이 됨
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static int[] nList;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			
			nList = new int[n+1];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				nList[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(nList);
			
			int m = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				sb.append(binarySearch(Integer.parseInt(st.nextToken()))+"\n");
			}
		}
		System.out.println(sb.toString());
	}
	static int binarySearch(int n) {
		int start = 0;
		int end = nList.length-1;
		int mid = (start+end)/2;

		while(start<=end) {
			if(nList[mid]==n) {
				return 1;
			}
			if(nList[mid]<n) {
				start= mid+1;
				
			}
			else if(nList[mid]>n) {
				end = mid-1;
			}
			mid = (start+end)/2;
		}
		return 0;
	}

}