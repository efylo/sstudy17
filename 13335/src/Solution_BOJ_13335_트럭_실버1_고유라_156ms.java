import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 1. 다리길이만큼 큐에 0 넣기
*  2. 다리 위 공간 없을 때까지 반복 */
public class Solution_BOJ_13335_트럭_실버1_고유라_156ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		Queue<Integer> truck = new LinkedList<Integer>();
		st = new StringTokenizer(br.readLine());
		for(int i= 0; i< n; i++) {
			truck.offer(Integer.parseInt(st.nextToken()));
		}
		int time = 0; 
		int bw=0;
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i =0; i<w ; i++) {
			q.add(0);
		}
		while(!q.isEmpty()) {
			time++;
			bw-=q.poll(); //다리 무게에서 빠진 만큼
			if(!truck.isEmpty()) {
				if(truck.peek()+bw<=L) { //최대하중 확인
					bw+=truck.peek();
					q.offer(truck.poll());
				}else {
					q.offer(0);
				}
			}
		}
		System.out.println(time);
		
		
		
		
		
	}//end of main

}//end of class
