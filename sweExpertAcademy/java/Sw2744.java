
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		for (int i = 0; i < n.length(); i++) {
			if(n.charAt(i)<91) {
				System.out.print((char)(n.charAt(i)+32));				
			}
			else {
				System.out.print((char)(n.charAt(i)-32));
			}
		}
	}

}