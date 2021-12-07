package day6;

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
		/*int[] in =  readDictionaryWords("C:\\Users\\Luky\\Desktop\\day6.txt");
		System.out.println(Arrays.toString(in));
		//int[][] input = new int[257][]; 
		int day = 0;
		//input[day] = in;
		while (day < 256) {
			List<Integer> tDay = new ArrayList<>();
			for (int i = 0; i < in.length; i++) {
				if (in[i] == 0) {
					tDay.add(8);
					tDay.add(6);
				}
				else {
					tDay.add(in[i] - 1);
				}
			}
		day++;
		System.out.println(day);
		in = makeArr(tDay);

		}
		
		System.out.println(in.length);*/
		
		long[] in =  makeArray("C:\\Users\\Luky\\Desktop\\day6.txt");
		//int[][] input = new int[257][]; 
		int day = 0;
		//input[day] = in;
		while (day < 256) {
			long tmp = 0;
			for (int i = 0; i < in.length; i++) {
				if (i == 0) {
					tmp = in[i];
					in[0] = 0;
				}
				else {
					in[i - 1] = in[i];
				}
			}
		day++;
		in[6] += tmp;
		in[8] = tmp;
		long an = 0;
		for (int i = 0; i < 9; i++) {
			an += in[i];
		}
		}
		
		long an = 0;
		for (int i = 0; i < 9; i++) {
			an += in[i];
		}
		System.out.println(an);
		
		

	}
	public static int[] makeArr(List<Integer> s) {
		int[] ret = new int[s.size()];
		int idx = 0;
		for (int i : s) {
			ret[idx++] = i; 
		}
		
		return ret;
	}
	
	public static long[] makeArray(String path) {
		File f = new File(path);
		List<Integer> words = new ArrayList<>();
		if (f.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(f));
				String line;
				while ((line = br.readLine()) != null) {
					String[] tmp = (line.trim().split(","));
					for (String i : tmp) {
						words.add(Integer.parseInt(i));
					}
				}
				br.close();
			} catch (FileNotFoundException ex) {
			} catch (IOException e) {
			}
		}
		long[] retVal = new long[9];
		for (int i: words) {
			retVal[i] += 1; 
		}
		
		return retVal;
	}

}
