import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_BOJ_15681_트리와쿼리_골드5_고유라_748ms {
	static ArrayList<Integer>[] list, tree;
	static int parent[], size[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuffer sb = new StringBuffer();
		
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		parent = new int [n+1];
		size = new int[n+1];
		list = new ArrayList[n+1];
		tree = new ArrayList[n+1];
		
		for(int i=0; i<list.length; i++) {
			list[i] = new ArrayList<>();
			tree[i] = new ArrayList<>();
		}
		for(int i=1; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}
		makeTree(r, -1);
		countSubtreeNodes(r);
		
		while(q-- > 0) {
			int query = Integer.parseInt(br.readLine());
			sb.append(size[query]).append("\n");
		}
		System.out.println(sb);
	} //end of main
	
	public static void makeTree(int curNode, int p) { //p=-1: 루트 노드
		for(int node : list[curNode]) {
			if(node != p) {
					tree[curNode].add(node);
					parent[node] = curNode;
					makeTree(node, curNode);
			}
		}
	}//end of makeTree
	
	public static void countSubtreeNodes(int curNode) {
		size[curNode] = 1; //자신이 루트인 서브트리에 포함
		for(int node : tree[curNode]) {
			countSubtreeNodes(node);
			size[curNode] += size[node];
		}
	}//end of countSubtreeNodes
	
}//end of class
