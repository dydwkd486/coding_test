import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	// total 개수가 미달이면 탈락
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(token.nextToken());
		int p = Integer.parseInt(token.nextToken());
		char[] n= br.readLine().toCharArray();
		int[] n_count = new int[4];
		int[] min_count = new int[4];
		int result =0;
		token = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			min_count[i]=Integer.parseInt(token.nextToken());
		}
		for (int i = 0; i < s-p+1; i++) {
			if(i==0) {
				for (int j = 0; j < p; j++) {
					if(n[j]=='A') {
						n_count[0] +=1;
					}
					else if(n[j]=='C') {
						n_count[1] +=1;
					}
					else if(n[j]=='G') {
						n_count[2] +=1;
					}
					else if(n[j]=='T') {
						n_count[3] +=1;
					}
				}
			}
			else {
				if(n[i-1]=='A') {
					n_count[0] -=1;
				}
				else if(n[i-1]=='C') {
					n_count[1] -=1;
				}
				else if(n[i-1]=='G') {
					n_count[2] -=1;
				}
				else if(n[i-1]=='T') {
					n_count[3] -=1;
				}
				
				if(n[p-1+i]=='A') {
					n_count[0] +=1;
				}
				else if(n[p-1+i]=='C') {
					n_count[1] +=1;
				}
				else if(n[p-1+i]=='G') {
					n_count[2] +=1;
				}
				else if(n[p-1+i]=='T') {
					n_count[3] +=1;
				}
				
			}
//			System.out.println(Arrays.toString(n_count));
			boolean temp=true;
			for (int j = 0; j < min_count.length; j++) {
				if(min_count[j]>n_count[j]) {
					temp = false;
					break;
				}
			}
			if(temp) {
				result++;
			}
		}
		System.out.println(result);

	}

}
