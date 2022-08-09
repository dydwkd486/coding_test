import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_D3_규영이와인영이의카드게임 {
	static int win_count;
	static boolean visited[];
	static int card[];
	static ArrayList<Integer> m;
	static int[] n;
	static int x;
	static int y;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int tc= 1 ; tc<= t;tc++) {
			win_count=0;
			visited = new boolean[9];
			card = new int[9];
			m = new ArrayList<>();
			n = new int[9];
			for(int i=1;i<19;i++) {
				m.add(i);
			}
			int count = 0;
			for(String i: br.readLine().split(" ") ) {
				n[count++] = Integer.parseInt(i);
				m.remove(Integer.valueOf(i));
			}
			dfs(0);
			sb.append("#"+tc+" "+win_count+" "+(362880-win_count)+"\n");
			
		}// tc end
		System.out.println(sb);
		
	} // main end
	
	public static void dfs(int idx) {
		if(idx == 9) {
			if(x>y) {
				win_count++;
			}
		}
		else {
			for (int i = 0; i < 9; i++) {
				if(!visited[i]) {
					visited[i]=true;
					if(n[idx] > m.get(i)) {
						x+=n[idx]+m.get(i);
						dfs(idx+1);
						x-=n[idx]+m.get(i);
					}
					else {
						y+=n[idx]+m.get(i);
						dfs(idx+1);
						y-=n[idx]+m.get(i);
					}
					visited[i]=false;
				}
			}
		}
	}
}
