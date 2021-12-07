package day_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String> input = makeArr("C:\\Users\\Luky\\Desktop\\day3.txt");
		int pos = 0;
		int length = input.get(0).length(); 
		int[] bit = new int[length];
		for (String in  : input) {
			for(char c: in.toCharArray()) {
				if (c == '0') {
					bit[pos]--;
				}
				else {
					bit[pos]++;
				}
				pos++;
			}
			pos = 0;
		}
		pos = 0;
		char[] g= new char[length];
		char[] y = new char[length];
		System.out.println(Arrays.toString(bit));
		for (int i : bit) {
			if (i > 0) {
				g[pos] = '1';
				y[pos] = '0';
			}
			else {
				g[pos] = '0';
				y[pos] = '1';
			}
			pos++;
		}
		pos = 0;
		char[] c1 = new char[length];
		char[] c2 = new char[length];
		
		List<String> input2 = input;
		
		System.out.println("G: " + Arrays.toString(g));
		for (int i = 0; i < length; i++) {
			char a = makeMask(input2, i, true);
			List<String> check = new ArrayList<>();
			for (String in: input2) {
				if(in.charAt(i) == a) {
					check.add(in);
				}
			}
			if(check.size() == 1) {
				System.out.println("PLS");
				c1 = check.get(0).toCharArray();
				System.out.println(Arrays.toString(c1));

			}
			input2 = check;
		}
		
		input2 = input;
		System.out.println("Y: " + Arrays.toString(y));
		for (int i = 0; i < length; i++) {
			char a = makeMask(input2, i, false);
			List<String> check = new ArrayList<>();
			for (String in: input2) {
				if(in.charAt(i) == a) {
					check.add(in);
				}
			}
			if(check.size() == 1) {
				System.out.println("PLS");
				c2 = check.get(0).toCharArray();
				System.out.println(Arrays.toString(c2));

			}
			input2 = check;
		}
		
		System.out.println(convertToDec(c1));
		System.out.println(convertToDec(c2));
		System.out.println(convertToDec(c1) * convertToDec(c2));

		
	}
	
	public static char makeMask(List<String> in, int pos, boolean src) {
		int ans = 0;
		for (String i: in) {
			if (i.charAt(pos) == '1') {
				ans++;
			}
			else {
				ans--;
			}
		}
		if (src) {
		if (ans >= 0) {
			return '1';
		}
		return '0';
		}
		else {
			if (ans >= 0) {
				return '0';
			}
			return '1';
		}
	}
	
	public static int convertToDec(char[] c) {
		int length = c.length;
		int num = 0;
		int p = 0;
		for (int i = length - 1; i >= 0; i--) {
			if (c[i] == '1') {
			num |= 1 << p;	
			}
			p++;
		}
		return num;
	}
	
	public static List<String> makeArr(String path) {
		File f = new File(path);
		List<String> words = new ArrayList<>();
		if (f.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(f));
				String line;
				while ((line = br.readLine()) != null) {
					words.add(line.trim());
				}
				br.close();
			} catch (FileNotFoundException ex) {
			} catch (IOException e) {
			}
		}
		return words;
	}

}
