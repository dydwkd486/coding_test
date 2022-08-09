import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D4_사칙연산유효성검사 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			int result =1;
			for (int i = 0; i < n; i++) {
				String[] a = br.readLine().split(" ");
				if(result ==1) {
					if(a.length==2) {
						if(a[1].equals("+") | a[1].equals("-") | a[1].equals("*") | a[1].equals("/") ) {
							result =0;	
						}
					}
					else {
						if(!(a[1].equals("+") | a[1].equals("-") | a[1].equals("*") | a[1].equals("/"))) {
							result =0;	
						}
					}
				}
			}
			System.out.println("#"+tc+" "+result);
		}
	}
}
