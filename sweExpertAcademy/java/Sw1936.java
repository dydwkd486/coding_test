
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sw1936 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String result[] = br.readLine().split(" ");
		if (Integer.parseInt(result[0])<Integer.parseInt(result[1])) {
			System.out.println("B");	
		}
		else {
			System.out.println("A");
		}
		
		
	}

}
