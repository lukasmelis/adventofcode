package day4;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String> input = day_1.Main.makeArr("C:\\Users\\Luky\\Desktop\\day4.txt");
		String[] an = input.get(0).split(",");
		String [][][] board = new String[100][5][5];
		int counter = 0;
		for(int i = 2; i < input.size() - 2; i++) {
			if (input.get(i) != null || input.get(i) != "\n" ) {
				if ((i - 2) % 6 != 5) {
					board[counter][(i - 2) % 6] = input.get(i).trim().replace("  ", " ").split(" ");
				}
				else {
					counter++;
				}
			}
		}
		int win = 0;
		for (int i = 0; i < an.length; i++) {
			for (int j = 0; j < 99; j++) {
				for (int g = 0; g < 5; g++) {
					for (int z = 0; z < 5; z++) {
						if (board[j] != null && board[j][g][z].equals(an[i])) {
							board[j][g][z] = "-1";
							if (checkWin(board[j], g, z)) {
								win++;
								if (win == counter) {
									System.out.println(Arrays.deepToString(board[j]));
									System.out.println("Board: "+j + ", winNum " + an[i]);
									System.out.println("Final score: " + sumUn(board[j]) * Integer.parseInt(an[i]));
								}
								board[j] = null;
							}	
						}
					}
				}
			}
		}
	}
	
	public static boolean checkWin(String[][] board, int row, int col) {
		boolean flag1 = true;
		boolean flag2 = true;
		for (int i = 0; i < 5; i++) {
			if (!board[row][i].equals("-1")) {
				flag1 = false;
			}
		}
		
		for (int i = 0; i < 5; i++) {
			if (!board[i][col].equals("-1")) {
				flag2 = false;
			}
		}
		
		if (flag1 || flag2) {
			return true;
		}
		return false;
	}
	
	public static int sumUn(String[][] board) {
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (!board[i][j].equals("-1")) {
					sum += Integer.parseInt(board[i][j]);
				}
			}
		}
		return sum;
	}
	
}



