package day5;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String> input = day3.Main.makeArr("C:\\Users\\Luky\\Desktop\\day5.txt");
		int[][] map = new int[1000][1000];
		for (String in : input) {
			String[] check = in.split(" -> ");
			String[] f = check[0].split(",");
			String[] g = check[1].split(",");
			
			int x1 = Integer.parseInt(f[0]);
			int y1 = Integer.parseInt(f[1]);
			int x2 = Integer.parseInt(g[0]);
			int y2 = Integer.parseInt(g[1]);
	
			if (x1 == x2) {
				for (int i = compare(y1, y2, true); i <= compare(y1, y2, false); i++) {
					map[x1][i]++;
				}
			}
			else if(y1 == y2) {
				for (int i = compare(x1, x2, true); i <= compare(x1, x2, false); i++) {
					map[i][y1]++;
				}
			}
			
			else {
				
				while (true) {
					if (x1 < x2 && y1 < y2) {
						map[x1++][y1++]++;
						if (x1 > x2 && y1 > y2) {
							break;
						}
					}
					else if(x1 > x2 && y1 < y2) {
						map[x1--][y1++]++;
						if (x1 < x2 && y1 > y2) {
							break;
						}
					}
					else if (x1 > x2 && y1 > y2) {
						map[x1--][y1--]++;
						if (x1 < x2 && y1 < y2) {
							break;
						}
					}
					else {
						map[x1++][y1--]++;
						if (x1 > x2 && y1 < y2) {
							break;
						}
					}
				}
			}
		}
		
		System.out.println(check(map));


	}
	
	public static int compare(int x1, int x2, boolean check) {
		if (x1 > x2 && check)
			return x2;
		else if(check)
			return x1;
		else if(x1 > x2)
			return x1;
		else
			return x2;
	}
	
	
	public static int check(int[][] map) {
		int count = 0;
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				if (map[i][j] > 1) {
					count++;
				}
			}
		}
		return count;
	}

}
