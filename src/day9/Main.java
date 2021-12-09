package day9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static class Point{
		int val;
		int x;
		int y;
	
		public Point(int val, int x, int y) {
			this.val = val;
			this.x = x;
			this.y = y;
		}
	}
	
	
	public static void main(String[] args) {
		int[][]input = makeArr("C:\\Users\\Luky\\eclipse-workspace\\adventofcode\\vstupy\\day9.txt");
		List<Point> low = new LinkedList<>();
		int sum = 0;
		for (int i = 0; i < input.length; i++) {
			boolean flag = true;
			for (int j = 0; j < input[0].length; j++) {
				if (flag && j - 1 >= 0) {
					flag = compare(input[i][j], input[i][j-1]);
				}
				if (flag && j + 1 < input[0].length) {
					flag = compare(input[i][j], input[i][j+1]);
				}
				if (flag && i - 1 >= 0) {
					flag = compare(input[i][j], input[i - 1][j]);
				}
				if (flag && i + 1 < input.length) {
					flag = compare(input[i][j], input[i + 1][j]);
				}
				
				if (flag) {
					sum += 1 + input[i][j];
					low.add(new Point(input[i][j], i, j));
				}
				flag = true;
			}
		}
		System.out.println(sum);
		int[]max = new int[low.size()];
		int idx = 0;
		for (Point p : low) {
			int result = bfs(p, input);
			max[idx++] = result;
		}
		Arrays.sort(max);
		int end = max.length - 1;
		System.out.println(Arrays.toString(max));
		System.out.println(max[end] * max[end - 1] * max[end - 2]);
	}
	
	public static int bfs(Point p, int[][]map) {
		int result = 1;
		Queue<Point> go = new LinkedList<>();
		boolean visited[][] = new boolean[map.length][map[0].length];
		go.add(p);
		visited[p.x][p.y] = true;
		while (!go.isEmpty()) {
			p = go.poll();
			int x = p.x;
			int y = p.y;
			if(y - 1 >= 0) {
				if(map[x][y-1] != 9) {
					Point n = new Point(map[x][y - 1], x,  y - 1);
					if(!visited[x][y-1]) {
						visited[x][y-1] = true;
						go.add(n);
						result++;
					}
				}
			}
			if(y + 1 < map[0].length) {
				if(map[x][y+1] != 9) {
					Point n = new Point(map[x][y + 1], x,  y + 1);
					if(!visited[x][y+1]) {
						visited[x][y+1] = true;
						go.add(n);
						result++;
					}
				}
			}
			if(x - 1 >= 0) {
				if(map[x-1][y] != 9) {
					Point n = new Point(map[x-1][y], x-1,  y);
					if(!visited[x-1][y]) {
						visited[x-1][y] = true;
						go.add(n);
						result++;
					}
				}
			}
			if(x + 1 < map.length) {
				if(map[x+1][y] != 9) {
					Point n = new Point(map[x+1][y], x+1,  y);
					if(!visited[x+1][y]) {
						visited[x+1][y] = true;
						go.add(n);
						result++;
					}
				}
			}
		}
		return result;
	}
	
	public static boolean compare(int a, int b) {
		if (a >= b) {
			return false;
		}
		return true;
	}
	
	public static int[][] makeArr(String path) {
		File f = new File(path);
		List<String> words = new ArrayList<>();
		if (f.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(f));
				String line;
				while ((line = br.readLine()) != null) {
					words.add(line);
				}
				br.close();
			} catch (FileNotFoundException ex) {
			} catch (IOException e) {
			}
		}
		
		int[][] retVal = new int[words.size()][];
		int idx = 0;
		for (String str: words) {
			int []tmp = new int[str.length()];
			String []tmpS = str.split("");
			int i = 0;
			for (String s : tmpS) {
				tmp[i++] = Integer.parseInt(s);
			}
			retVal[idx++] = tmp; 
		}
		return retVal;
	}
		

}
