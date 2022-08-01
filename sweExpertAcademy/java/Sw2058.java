

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sw2058 {
	public static void main(String[] args) throws IOException {
		int result = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] a = br.readLine().split("");
		for(int i=0;i<a.length;i++) {
//			System.out.println(a[i]);
			result +=Integer.parseInt(a[i]);
		}
		System.out.println(result);
	}
}