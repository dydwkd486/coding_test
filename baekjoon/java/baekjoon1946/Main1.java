package baekjoon1946;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1 {
	static Employee[] employees;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t =Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());
			employees = new Employee[n];
			for (int i = 0; i < n; i++) {
				employees[i] = new Employee();
				String[] temp =br.readLine().split(" ");
				employees[i].paper = Integer.parseInt(temp[0]);
				employees[i].meeting = Integer.parseInt(temp[1]);
			}
			Arrays.sort(employees);
			int min = employees[0].meeting;
			int count = 1;
			for (int i = 1; i < n; i++) {
				if(employees[i].meeting<min) {
					min = employees[i].meeting;
					count++;
				}
				if(min ==1) {
					break;
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
		
	}
	
	static class Employee implements Comparable<Employee>{
		int paper;
		int meeting;
		public Employee() {
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public int compareTo(Employee o) {
			// TODO Auto-generated method stub
			if(this.paper == o.paper) {
				return this.meeting - o.meeting;
			}
			return this.paper - o.paper;
		}
	}
	
	static void print() {
		for (Employee employee : employees) {
			System.out.println(employee.paper+":"+employee.meeting);				
		}
		System.out.println();
	}
	

}
