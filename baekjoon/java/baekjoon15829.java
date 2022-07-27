import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] n_list = br.readLine().split("");
		long result = 0;
		long r = 1;
		for (String i : n_list) {
			for (int j = 0; j < (int)i.charAt(0)-96; j++) {
				result=(result+r)%1234567891;
			}
			r=(r*(31))%1234567891;			
		}
		System.out.println(result);
	}
}