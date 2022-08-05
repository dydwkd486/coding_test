import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result;
		Queue<Integer> n_list = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			n_list.offer(i);
		}
		for(;;) {
			if(n_list.size()==1) {
				result = n_list.poll();
				break;
			}
			n_list.poll(); // 한장 제거
			n_list.offer(n_list.poll());
			
		}
		System.out.println(result);
	}
}
