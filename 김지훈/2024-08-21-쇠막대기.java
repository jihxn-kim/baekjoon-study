/*
 여러 개의 쇠막대기를 레이저로 절단하려고 한다. 효율적인 작업을 위해서 쇠막대기를 아래에서 위로 겹쳐 놓고,
 레이저를 위에서 수직으로 발사하여 쇠막대기들을 자른다. 쇠막대기와 레이저의 배치는 다음 조건을 만족한다.
 
 - 쇠막대기는 자신보다 긴 쇠막대기 위에만 놓일 수 있다.
 - 쇠막대기를 다른 쇠막대기 위에 놓는 경우 완전히 포함되도록 놓되, 끝점은 겹치지 않도록 놓는다.
 - 각 쇠막대기를 자르는 레이저는 적어도 하나 존재한다.
 - 레이저는 어떤 쇠막대기의 양 끝점과도 겹치지 않는다.
 
 이러한 레이저와 쇠막대기의 배치는 다음과 같이 괄호를 이용하여 왼쪽부터 순서대로 표현할 수 있다.
 1. 레이저는 여는 괄호와 닫는 괄호의 인접한 쌍 '()'으로 표현된다. 또한, 모든 '()' 는 반드시 레이저를 표현한다.
 2. 쇠막대기의 왼쪽 끝은 여는 괄호 '('로, 오른쪽 끝은 닫힌 괄호 ')'로 표현된다.
 
 쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 주어졌을 때, 잘려진 쇠막대기 조각의 총 개수를 구하는 프로그램을 작성하시오.
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Quiz10799 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String ex = input.next(); // 입력값 (괄호로 이루어진 문자열)
		
		int len = ex.length();
		
		ArrayList<Integer> arr = new ArrayList<>(); //레이저와 막대의 시작과 끝을 숫자로 표현하여 나타낼 배열
		
		// 레이저 -> 0
		// 쇠막대 시작 -> 1
		// 쇠막대 끝 -> -1
		
		for (int i = 0; i < len; i++) {
			char c = ex.charAt(i); // 문자열을 하나씩 뜯어서 확인
			// char cc = ex.charAt(i + 1); -> out of index error
			
			if (c == '(' && i < len - 1 && ex.charAt(i + 1) == ')') { // i == len -1 일 때는 에러 날 수 있으니 조건 추가
				arr.add(0);
				i++; // 레이저는 괄호가 두 개 이기 때문에 i 를 하나 증가시켜주며 닫는 괄호 ')' 를 패스한다.
			} else if (c == '(') {
				arr.add(1); // 쇠막대 시작
			} else {
				arr.add(-1); // 쇠막대 끝
			}
		}
		
		// 숫자배열로 바꾼 레이저와 쇠막대를 프린트 (확인 용도 - 실제 코드에서는 삭제)
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i));
		}
		
		int answer = 0;
		int temp = 0; // arr 을 순회하면서 지금까지의 모든 값을 더한 값
		int laser_count = 0; // 레이저의 갯수
		int iron_count = 0; // 쇠막대의 갯수
		
		for (int i = 0; i < arr.size(); i++) {
			int a = arr.get(i);
			temp += a; // temp 에 지금까지 인덱스를 돌며 있던 모든 값들을 더한다.
			
			if (a == 0) {
				answer += temp; // 레이저를 만났다면 temp 값이 그 레이저가 자르는 쇠막대의 갯수가 된다.
				laser_count++;
			} else if (a == 1) {
				iron_count++;
			}
		}
		
		answer += iron_count; // 막대를 2번 자를 때 막대는 3개가 되므로 잘린 횟수에 막대 갯수를 더해주어야 한다.
		System.out.println();
		System.out.println(answer);
		
		
		
		// 배열을 만들지 않고 input 에서 바로 연산들어가도 괜찮을 듯
		
		
		
	}

}
