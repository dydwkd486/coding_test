package baekjoon2910;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Main {
	static int n,c;
	static HashMap<Integer, Integer> hashmap = new LinkedHashMap<>();
	static ArrayList<Integer> v;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		StringBuilder sb= new StringBuilder();
		n = Integer.parseInt(token.nextToken());
		c = Integer.parseInt(token.nextToken());
		token = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int temp = Integer.parseInt(token.nextToken());
			if(hashmap.containsKey(temp)) {
				hashmap.replace(temp, hashmap.get(temp)+1);
			}
			else {
				hashmap.put(temp, 1);
			}
		}
		v = new ArrayList<>(hashmap.keySet());
		
		Collections.sort(v, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return Integer.compare(hashmap.get(o2), hashmap.get(o1));
			}
		});
		Iterator<Integer> it = v.iterator();
		while(it.hasNext()) {
			Integer e = it.next();
			for (int i = 0; i < hashmap.get(e); i++) {
				sb.append(e+" ");
			}
		}
		System.out.print(sb);
	}

}
