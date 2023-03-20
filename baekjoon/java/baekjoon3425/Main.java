package baekjoon3425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// baekjoon 3425
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static List<String> input;
	public static long MAX = 1000000000;

	public static void main(String[] args) throws IOException {
		// 숫자만 저장 가능
		while (true) {
			input = new ArrayList<>();
			while (true) {
				String[] temp = br.readLine().split(" ");
				// 종료 해버렷!
				if (temp[0].equals("QUIT")) {
					System.out.println(sb);
					return;
				}
				if (temp[0].equals("END")) {
					break;
				}
				if(temp.length==1) {
					input.add(temp[0]);
                }
                else {
                	input.add(temp[0]+" "+temp[1]);
                    
                }
			}
			//
			int count = Integer.parseInt(br.readLine());
			for (int i = 0; i < count; i++) {
				Program(Long.parseLong(br.readLine()));
			}
			System.out.println();
		}

	}

	static void Program(Long num) {
		ArrayDeque<Long> ans = new ArrayDeque();
		ans.addFirst(num);
		boolean flag = false;
		for (String s : input) {
			if (flag) {
				break;
			}
			switch (s.split(" ")[0]) {
			case "NUM":
				ans.addFirst(Long.parseLong(s.split(" ")[1]));
				break;
			case "POP":
				if (ans.size() < 1) {
					flag = true;
					break;
				}
				ans.removeFirst();
				break;
			case "INV": {
				if (ans.size() < 1) {
					flag = true;
					break;
				}
				Long a = ans.removeFirst();
				ans.addFirst(a * -1);
				break;
			}
			case "DUP":
				if (ans.size() < 1) {
					flag = true;
					break;
				}
				ans.addFirst(ans.peek());
				break;
			case "SWP": {
				if (ans.size() < 2) {
					flag = true;
					break;
				}
				Long a = ans.removeFirst();
				Long b = ans.removeFirst();
				ans.addFirst(a);
				ans.addFirst(b);
				break;
			}
			case "ADD": {
				if (ans.size() < 2) {
					flag = true;
					break;
				}
				Long a = ans.removeFirst();
				Long b = ans.removeFirst();
				if (Math.abs(a + b) > MAX) {
					flag = true;
					break;
				}

				ans.addFirst(a + b);
				break;
			}
			case "SUB": {
				if (ans.size() < 2) {
					flag = true;
					break;
				}
				Long a = ans.removeFirst();
				Long b = ans.removeFirst();
				if (Math.abs(b - a) > MAX) {
					flag = true;
					break;
				}
				ans.addFirst(b - a);
				break;
			}
			case "MUL": {
				if (ans.size() < 2) {
					flag = true;
					break;
				}
				Long a = ans.removeFirst();
				Long b = ans.removeFirst();
				if (Math.abs(a * b) > MAX) {
					flag = true;
					break;
				}
				ans.addFirst(a * b);
				break;
			}
			case "DIV": {
				if (ans.size() < 2) {
					flag = true;
					break;
				}
				int minus_cnt = 0;
				Long a = ans.removeFirst();
				Long b = ans.removeFirst();
				if (a < 0) {
					minus_cnt++;
				}
				if (b < 0) {
					minus_cnt++;
				}
				if (a == 0) {
					flag = true;
					break;
				}
				long div = Math.abs(b) / Math.abs(a);
				if (minus_cnt == 1) {
					ans.addFirst(div * -1);
				} else {
					ans.addFirst(div);
				}

				break;
			}
			case "MOD": {
				if (ans.size() < 2) {
					flag = true;
					break;
				}
				Long a = ans.removeFirst();
				Long b = ans.removeFirst();
				if (a == 0) {
					flag = true;
					break;
				}
				long mod = Math.abs(b) % Math.abs(a);
				if (b < 0) {
					mod *= -1;
				}
				ans.addFirst(mod);
				break;
			}
			default:
				break;
			}
//			System.out.println(s+":"+ans);
		}
		if (!flag && ans.size() == 1)
			System.out.println(ans.getFirst());
		else
			System.out.println("ERROR");

	}
}
