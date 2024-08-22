import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Quiz1037 {
	public static void main(String[] args) {
		
		/*
		 문제
		 양수 A가 N의 진짜 약수가 되려면, N이 A의 배수이고, A가 1과 N이 아니어야 한다.
		 어떤 수 N의 진짜 약수가 모두 주어질 때, N을 구하는 프로그램을 작성하시오.
		 
		 입력
		 첫째 줄에 N의 진짜 약수의 개수가 주어진다. 이 개수는 50보다 작거나 같은 자연수이다.
		 둘째 줄에는 N의 진짜 약수가 주어진다. 1,000,000보다 작거나 같고, 2보다 크거나 같은 자연수이고, 중복되지 않는다.
		 
		 출력
		 첫째 줄에 N을 출력한다. N은 항상 32비트 부호있는 정수로 표현할 수 있다.
		 */
		
		
		// 방법 1
		// 1과 자기 자신을 제외한 약수들이 두 번째 입력으로 들어오기 때문에
		// 이 약수들을 크기 순으로 정렬한 후 제일 처음과 마지막의 곱이 구하고자 하는 수가 된다.
		
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			int a = input.nextInt();
			arr.add(a);
		}
		
		Collections.sort(arr, Collections.reverseOrder()); // arr 을 내림차순으로 정렬
		
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i) + " ");
		}
		System.out.println();
		
		Collections.sort(arr); // arr 을 오름차순으로 정렬
		
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i) + " ");
		}
		
		int answer_1 = arr.get(0) * arr.get(arr.size() - 1);
		System.out.println();
		System.out.println(answer_1);
		
		
		// 방법 2
		// 배열의 최솟값과 최댓값을 구해서 바로 곱한다.
		
		int max_1 = Collections.max(arr); // arr 중 최댓값을 반환
		int min_1 = Collections.min(arr); // arr 중 최솟값을 반환
		
		int answer_2 = max_1 * min_1;
		System.out.println();
		System.out.println(answer_2);
		
		
		// 방법 3
		// Scanner 로 input 을 받을 때 바로 최솟값과 최댓값을 구한다.
		// Collections 사용하지 않는 방법
		
		int max_2 = 0;
		int min_2 = 1000000; // 문제에서 주어진 최댓값
		
		int m = input.nextInt();
		
		for (int i = 0; i < m; i++) {
			int b = input.nextInt();
			
			if (max_2 < b) {
				max_2 = b;
			}
			
			if (min_2 > b) {
				min_2 = b;
			}
		}
		
		int answer_3 = max_2 * min_2;
		System.out.println();
		System.out.println(answer_3);
		
	}
}
