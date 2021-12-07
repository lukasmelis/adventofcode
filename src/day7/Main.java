package day7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		int[] input = makeArr("C:\\Users\\Luky\\Desktop\\day7.txt");
		int start = findMinMax(input, false);
		int end = findMinMax(input, true);
		int fuel = 1000000000;
		for (int i = start; i <= end; i++) {
			int check = 0;
			for (int j = 0; j < input.length; j++) {
				check += countCost(i, input[j]);
			}
			if (check < fuel) {
				fuel = check;
			}
		}
		System.out.println("FINAL: " + fuel);
	
	}
	
	public static int countCost(int start, int end) {
		int retVal = 0;
		if (start > end) {
			for (int i = end; i < start; i++) {
				retVal += (i - (end - 1));
			}
		}
		else {
			for (int i = start; i < end; i++) {
				retVal += (i - (start - 1));
			}
		}
		
		return retVal;
	}

	public static int findMinMax(int[] in, boolean max) {
		int ret = in[0];
		if (max) {
			for (int i = 1; i < in.length; i++) {
				if (in[i] > ret) {
					ret = in[i];
				}
			}
		}
		else {
			for (int i = 1; i < in.length; i++) {
				if (in[i] < ret) {
					ret = in[i];
				}
			}
		}
		return ret;
	}
	
	public static int[] makeArr(String path) {
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
		
		int[] retVal = new int[words.size()];
		int idx = 0;
		for (int i: words) {
			retVal[idx++] = i; 
		}
		
		return retVal;
	}
}
