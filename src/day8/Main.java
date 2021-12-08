package day8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	static Map<Integer, String> disp = new HashMap<>();

	public static void main(String[] args) {
		List<String> in = day3.Main.makeArr("C:\\Users\\Luky\\Desktop\\day8.txt");
		int sum = 0;
		for (String row : in) {
			String[] input = row.split("\\|");
			for (String ans : input[1].split(" ")) {
				int len = ans.length();
				if (len == 2 || len == 3 || len == 4 || len == 7) {
					sum++;
				}
			}
		}
		
		System.out.println("8A: " + sum);
		sum = 0;
		
		for (String row : in) {
			String[] input = row.split("\\|");
			for (String ans : input[0].split(" ")) {
				int len = ans.length();
				switch (len) {
					case 2:
						disp.put(1, ans);
						break;
					case 3:
						disp.put(7, ans);
						break;
					case 4:
						disp.put(4, ans);
						break;
					case 7:
						disp.put(8, ans);
						break;
				}
			}
			
			for (String ans : input[0].split(" ")) {
				int len = ans.length();
				if (len == 6) {
					if (comChar(ans, disp.get(7)) &&  comChar(ans, disp.get(4))) {
						disp.put(9, ans);
					}
					else if (comChar(ans, disp.get(1)) &&  comChar(ans, disp.get(7))) {
						disp.put(0, ans);
					}
					else {
						disp.put(6, ans);
					}
					
				}
				
			}
			for (String ans : input[0].split(" ")) {
				int len = ans.length();
				if (len == 5){
					if (comChar(ans, disp.get(1)) &&  comChar(ans, disp.get(7))) {
						disp.put(3, ans);
					}
					else if (comChar(disp.get(6), ans)) {
						disp.put(5, ans);
					}
					else {
						disp.put(2, ans);
					}
				}
			}
			int idx = 1000;
			int num = 0;
			for (String ans : input[1].trim().split(" ")) {
				System.out.println(getDigit(ans));
				num += getDigit(ans) * idx;
				idx /= 10;
			}
			System.out.println(num);
			sum += num;	
		}

		System.out.println("8B: " + sum);
	}
	
	public static int getDigit(String input) {
		switch(input.length()) {
			case 2:
				return 1;
			case 3:
				return 7;
			case 4:
				return 4;
			case 5:
				if(comChar(input, disp.get(5))) {
					return 5;
				}
				else if(comChar(input, disp.get(3))) {
					return 3;
				}
				else {
					return 2;
				}
			case 6:
				if(comChar(input, disp.get(9))) {
					return 9;
				}
				else if(comChar(input, disp.get(0))) {
					return 0;
				}
				else {
					return 6;
				}
			case 7:
				return 8;
			default:
				break;
		}
		return -1;
	}
	public static boolean comChar(String checked, String pattern) {
		boolean flag = false;
		for (int i = 0; i < pattern.length(); i++) {
			for (char c: checked.toCharArray()) {
				if (c == pattern.charAt(i)) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				return false;
			}
			flag = false;
		}
		return true;
	}

}
