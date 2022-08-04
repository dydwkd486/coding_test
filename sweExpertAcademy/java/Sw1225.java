import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		StringBuilder sb = new StringBuilder();
		for(int tc=0;tc<10;tc++) {
			int n = Integer.parseInt(br.readLine());
			Queue<Integer> n_list = new LinkedList<>();
			token = new StringTokenizer(br.readLine()," ");
			int temp=1;
			for(int i=0;i<8;i++) n_list.offer(Integer.parseInt(token.nextToken()));
			for(;;) {
				if(n_list.peek()-temp<=0) {
					n_list.poll();
					n_list.offer(0);
					break;
				}
				else n_list.offer(n_list.poll()-temp++);
				temp = (temp==6) ? 1:temp;
				// temp = (temp%6)+1;
			}
			sb.append("#"+n);
			for (Integer integer : n_list) {
				sb.append(" "+integer);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
