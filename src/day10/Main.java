package day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		List<String> input = day3.Main.makeArr("C:\\\\Users\\\\Luky\\\\eclipse-workspace\\\\adventofcode\\\\vstupy\\\\day10.txt");
		final List<Character> open = Arrays.asList('(', '[', '{', '<');
		int score = 0;
		Dictionary<Character, Character> closing = new Hashtable<>();
		closing.put('(', ')');
		closing.put('{', '}');
		closing.put('[', ']');
		closing.put('<', '>');
		Dictionary<Character, Integer> errorScore = new Hashtable<>();
		errorScore.put(')', 3);
		errorScore.put(']', 57);
		errorScore.put('}', 1197);
		errorScore.put('>', 25137);
	
		for (String in : input) {
			Stack<Character>st = new Stack<>();
			for (char z : in.toCharArray()) {
				if (open.contains(z)) {
					st.push(z);
				}
				else {
					char temp = closing.get(st.pop());
					if (temp != z) {
						score += errorScore.get(z);
						break;
					}
				}
				
			}	
		}
		System.out.println("A: " + score);

	long scoreB;
	List<Long> scoreArr = new ArrayList<>();
	Dictionary<Character, Integer> errorScore2 = new Hashtable<>();
	errorScore2.put(')', 1);
	errorScore2.put(']', 2);
	errorScore2.put('}', 3);
	errorScore2.put('>', 4);
	for (String in : input) {
		Stack<Character>st = new Stack<>();
		scoreB = 0;
		boolean flag = false;
		for (char z : in.toCharArray()) {
			if (open.contains(z)) {
				st.push(z);
			}
			else {
				char temp = closing.get(st.pop());
				if (temp != z) {
					flag = true;
					break;
				}
			}
		}
		if (!flag && !st.isEmpty()) {
		while(!st.isEmpty()) {
			int charScore = errorScore2.get(closing.get(st.pop()));;
			scoreB =  5 * scoreB + charScore;
		}
		scoreArr.add(scoreB); 
		}
		
	}
	Collections.sort(scoreArr);
	System.out.println("B: " + scoreArr.get((scoreArr.size() - 1)/2));

	}

}
