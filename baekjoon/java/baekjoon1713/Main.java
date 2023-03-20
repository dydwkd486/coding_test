import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
	static Scanner sc = new Scanner(System.in);


	public static void main(String[] args) {
		// 1713 문제
		int picturetle = Integer.parseInt(sc.nextLine());
		int pCount = Integer.parseInt(sc.nextLine());

		class Person implements Comparable<Person>{
			int name;
			int count;
			int date;

			public Person(int name, int count, int date) {
				super();
				this.name = name;
				this.count = count;
				this.date = date;
			}

			public Person() {
				// TODO Auto-generated constructor stub
			}
			
			public int getName() {
				return name;
			}

			public void setName(int name) {
				this.name = name;
			}

			public int getCount() {
				return count;
			}

			public void setCount(int count) {
				this.count = count;
			}

			public int getDate() {
				return date;
			}

			public void setDate(int date) {
				this.date = date;
			}

			@Override
		    public int compareTo(Person o) {
				if(o.getCount()==this.getCount()) {
					return o.getDate()-this.getDate();
				}
				return this.getCount()-o.getCount();
		    }
		}

		List<Person> ps = new ArrayList<>();
		String[] temp = sc.nextLine().split(" ");
		for (String s : temp) {
			
			if(ps.size()==0) {
				ps.add(new Person(Integer.parseInt(s),1,1));
			}
			else {
				// 같은게 있는지 확인
				boolean flag = true;
				for (Person p : ps) {
					// 같은게 있네? 추가!
					if(p.name == Integer.parseInt(s)) {
						p.count++;
						flag=false;
					}
				}
				// 같은게 없다면 ps에 추가
				// 근데 개수를 초과하면? 추가하면 안됨
				if(flag) {
					if(ps.size()!=picturetle) {
						ps.add(new Person(Integer.parseInt(s),1,1));
					}
					// 여기서 이제 변경해야함.
					else {
						// 가장 적은 횟수
						// 같은 경우 오래된 수(date가 큰 경우)
						Collections.sort(ps);
						ps.remove(0);
						ps.add(new Person(Integer.parseInt(s),1,1));
						

					}
				}
				
			}
			for (Person p : ps) {
				p.date++;
			}
			

		}
		TreeSet<Integer> ans = new TreeSet<>();
		for (Person s1 : ps) {
			ans.add(s1.name);
		}
		for (Integer i : ans) {
			System.out.print(i+" ");
		}

		// 
		// count -> date 순으로 정렬해야함.
		

	}
}
