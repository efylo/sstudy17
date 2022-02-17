import java.util.Scanner;
import java.util.Stack;

/* 1. 줄마다 스택에 하나씩 쌓기
 * 2. 앞<뒤 : 그냥 쌓기, 앞>뒤 : 앞 삭제
 * 3. 기존 숫자랑 겹치면 그 전까지 삭제*/
public class Solution_BOJ_2841_외계인의기타연주_실버1_고유라_2008ms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int P = sc.nextInt();
		int result = 0;
		
		Stack<Integer>[] stack = new Stack[N+1];
		for (int i=0; i<N; i++) {
			stack[i] = new Stack<Integer>();
		}

		for (int i=0; i<N; i++) {
			int line = sc.nextInt();
			int fret = sc.nextInt();
			
			if (stack[line].size()==0) { //스택 비어있을 때
				result++;
				stack[line].push(fret);
				continue;
			}
			while (stack[line].peek() > fret) { //프렛 앞의 숫자가 더 클 때 이미 누르고 있는 거
				result++;
				stack[line].pop();
				if (stack[line].size()==0) break;
			}
			if (stack[line].size() !=0 &&stack[line].peek()==fret) { //프렛 숫자 같을 때
				continue;
			}
			result++;
			stack[line].push(fret);
		}
		System.out.println(result);
		
		
		
		
	}//end of main

}//end of class
