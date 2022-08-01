import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] result = new int[n];
		
		String[] temp = new String[n];
		temp =br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			result[i]=Integer.parseInt(temp[i]);
		}
		int person=Integer.parseInt(br.readLine());
		for(int i=0;i<person;i++) {
			String[] temp1 = br.readLine().split(" ");
			if(Integer.parseInt(temp1[0])==1) {
				//남학생
				int count = Integer.parseInt(temp1[1]);
				for(int j=count;j<=result.length;j+=count) {
					if(result[j-1]==0) result[j-1]=1;
					else result[j-1]=0;
				}
			}
			else {
				//여학생
				int count = Integer.parseInt(temp1[1])-1;
				int a = 0;
				int b = 0;
				while(count+a>=0 && count+b<n) {
					if(result[count+a]==result[count+b]) {
						if(result[count+a]==0) {
							result[count+a]=1;
							result[count+b]=1;
						}
						else {
							result[count+a]=0;
							result[count+b]=0;
						}
					}
					else {
						break;
					}
					a-=1;
					b+=1;
				}
			}
		}
		int temp2=0;
		for(int j=0;j<result.length;j++) {
			temp2++;
			if(temp2%20==0) {
				System.out.println(result[j]);
			}
			else {
				System.out.print(result[j]+" ");
			}
			
			
		}
	}
}