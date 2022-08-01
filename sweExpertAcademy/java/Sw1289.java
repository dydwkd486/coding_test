import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Sw1289 {


	static String change;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i < T+1; i++) {
			String n = br.readLine();
			char temp = '0';
			int result=0;
			for (int j = 0; j < n.length(); j++) {
				if(n.charAt(j)!=temp) {
					result+=1;
					temp=n.charAt(j);
				}
			}
			System.out.println("#"+i+" "+result);
		}
	}
}