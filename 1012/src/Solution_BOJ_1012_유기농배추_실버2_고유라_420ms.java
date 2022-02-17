import java.util.Scanner;

/* 1. 테스트케이스만큼 반복
 * 2. 배추 있는 곳 1로 표시하고
 * 3. 배추 있으면 지렁이 +1
 * 4. dfs로 왔다간 곳이면 넘어가기*/
public class Solution_BOJ_1012_유기농배추_실버2_고유라_420ms {
	static int m; //가로
	static int n; //세로
	static int k; //배추 심어진 곳 갯수
	static int[][] cab; // 배추있는 곳
	static boolean[][] visit; // 방문한 곳
	static int dx[] = {-1, 1, 0, 0}; //상 하 좌 우
	static int dy[] = {0, 0, 1, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int i=0; i<t; i++) {
			int result=0; //배추흰지렁이 수
			m = sc.nextInt();
			n = sc.nextInt();
			k = sc.nextInt();
			
			cab = new int [m][n];
			visit = new boolean [m][n];
			
			for (int j=0; j<k; j++) {
				int x = sc.nextInt(); //배추 위치
				int y = sc.nextInt();
				cab[x][y] = 1; //배추 있음
			}
			for (int x=0; x<m; x++) {
				for (int y=0; y<n; y++) {
					if (cab[x][y]==1 && !visit[x][y]) {
						result++;
						dfs(x,y);
					}
				}
			}
			System.out.println(result);
			
		}//end of tc
		
	}//end of main

	private static void dfs(int x, int y) {
        // TODO Auto-generated method stub
		visit[x][y] = true;
		for (int i=0; i<4; i++) { 
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if (nx>=0 && nx<m && ny>=0 && ny<n) {
				if (cab[nx][ny] == 1 && !visit[nx][ny]) {
					dfs(nx,ny);
				}
			}
		}
		
		
	}//end of dfs

}//end of class