package study;

import java.util.Scanner;

public class Quiz_14053_2 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		int m = input.nextInt();
		
		int [][] arr = new int [n][m];
		
		int r = input.nextInt();
		int c = input.nextInt();
		int d = input.nextInt();
		
		int [] dx = {-1, 0, 1, 0};
		int [] dy = {0, 1, 0, -1};
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = input.nextInt();
			}
		}
		
		arr[r][c] = 2;
		
		int count = 1;
		boolean run = true;
		
		while_ :
		while (run) {
			
			for (int i = 0; i < 4; i++) {
				d = (d + 3) % 4;
				
				int rr = r + dx[d];
				int cc = c + dy[d];
				
				if (arr[rr][cc] == 0) {
						r = rr;
						c = cc;
						arr[r][c] = 2;
						count++;
						continue while_;
					}
			} // for
			
			// 4번 반복 후에도 0이 없으면
			int rr = r - dx[d];
			int cc = c - dy[d];
			
			if (arr[rr][cc] != 1) {
				r = rr;
				c = cc;
			} else {
				run = false;
			}
			
			
		} // while
		
		System.out.println(count);
		
		
		
		
		
		
	}
}
