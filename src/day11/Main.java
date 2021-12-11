package day11;

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
		int[][] map = day9.Main.makeArr("C:\\Users\\Luky\\eclipse-workspace\\adventofcode\\vstupy\\day11.txt");
		int steps = 1;
		long flash = 0;
		while (true) {
			dispMap(map);
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					map[i][j]++; 
				}
			}
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					if(map[i][j] > 9) {
						map[i][j] = 0;
						makeFlash(map, i, j);
					}
				}
			}
			flash += countFlash(map);
			if(checkSync(map)) {
				System.out.println(steps);
				break;
			}
			steps++;
		}
		System.out.println(flash);

	}
	
	public static int[][] makeFlash(int[][]map, int x, int y) {
		if (y + 1 < map[0].length && map[x][y + 1] != 0) {
			if(flash(map[x][y + 1])) {
				map[x][y + 1] = 0;
				map = makeFlash(map, x, y + 1);
			}
			else {
				map[x][y + 1]++;
			}
		}
		
		if (y - 1 >= 0 && map[x][y - 1] != 0) {
			if(flash(map[x][y - 1])) {
				map[x][y - 1] = 0;
				map = makeFlash(map, x, y - 1);
			}
			else {
				map[x][y - 1]++;
			}
		}
		
		if (x + 1 < map.length && map[x + 1][y] != 0) {
			if(flash(map[x + 1][y])) {
				map[x + 1][y] = 0;
				map = makeFlash(map, x + 1, y);
			}
			else {
				map[x + 1][y]++;
			}
		}
		
		if (x - 1 >= 0 && map[x - 1][y] != 0) {
			if(flash(map[x - 1][y])) {
				map[x - 1][y] = 0;
				map = makeFlash(map, x - 1, y);
			}
			else {
				map[x - 1][y]++;
			}
		}
		
		if (y + 1 < map[0].length && x + 1 < map.length && map[x + 1][y + 1] != 0) {
			if(flash(map[x + 1][y + 1])) {
				map[x + 1][y + 1] = 0;
				map = makeFlash(map, x + 1, y + 1);
			}
			else {
				map[x + 1][y + 1]++;
			}
		}
		
		if (y - 1 >= 0 && x + 1 < map.length && map[x + 1][y - 1] != 0) {
			if(flash(map[x + 1][y - 1])) {
				map[x + 1][y - 1] = 0;
				map = makeFlash(map, x + 1, y - 1);
			}
			else {
				map[x + 1][y - 1]++;
			}
		}
		
		if (y + 1 < map[0].length && x - 1 >= 0 && map[x - 1][y + 1] != 0) {
			if(flash(map[x - 1][y + 1])) {
				map[x - 1][y + 1] = 0;
				map = makeFlash(map, x - 1, y + 1);
			}
			else {
				map[x - 1][y + 1]++;
			}
		}
		
		if (y - 1 >= 0 && x - 1 >= 0 && map[x - 1][y - 1] != 0) {
			if(flash(map[x - 1][y - 1])) {
				map[x - 1][y - 1] = 0;
				map = makeFlash(map, x - 1, y - 1);
			}
			else {
				map[x - 1][y - 1]++;
			}
		}
		
		return map;
	}
	
	public static void dispMap(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

	}
	
	public static long countFlash(int[][] map) {
		long count = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == 0) {
					count++;
				}
			}
		}
		return count;
	}
	public static boolean checkSync(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if(map[i][j] != 0) {
					return false;
				}
			}
		}
		return true;

	}
	public static boolean flash(int x) {
		if (x == 9) {
			return true;
		}
		return false;
	}
}
