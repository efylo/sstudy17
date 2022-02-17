import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 1. 큐에 우선순위 넣기
 * 2. 다른 큐에 인덱스 넣고
 * 3. 인덱스에 있는 숫자가 언제 나오는지
 * 4. 큐 처음 인덱스를 비교해서 더 크면 큐 맨 뒤에 넣기
 * 5. 반복 */
public class Solution_BOJ_1966_프린터큐_실버3_고유라_160ms {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for(int t=0; t<tc; t++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());	// 총 개수
			int x = Integer.parseInt(st.nextToken());	// 몇번째로 인쇄되었는지 궁금한 문서
			int result = 0;
			
			st = new StringTokenizer(bf.readLine());	// 중요도
			Queue<Integer> q = new LinkedList<Integer>();
			for(int i=0; i<N; i++) 
				q.add(Integer.parseInt(st.nextToken()));	// 중요도 저장
			
			while(!q.isEmpty()) {
				boolean flag = true;	// 현재 문서보다 중요도높은지 확인
				for(int i=1; i<q.size(); i++) {
					if(q.peek() < ((LinkedList<Integer>) q).get(i)) {	// 현재 문서보다 중요도가 높으면
						flag = false;
						break;
					}
				}
				
				// 현재 문서 중요도가 제일 클 때
				if(flag) {
					result ++;		// 현재 목록 인쇄 +1
					q.poll();	
					if(x == 0) 	break;	// 출력할 문서가 궁금한 문서일 때
					else 	x --;		
					
				} else { // 현재 문서보다 중요도가 높은게 있으면 큐 맨 뒤로 넣기
					int temp = q.poll();
					q.add(temp);
					if(x == 0) {
						x = q.size()-1; //궁금한 문서면 맨 뒤로
					} else x -= 1;
					
				}
			}
			System.out.println(result);
			
		}//end of tc
		
	}//end of main

}//end of class
