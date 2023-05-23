//$Id$
package by.tarif.graph;

import java.util.*;
import java.io.IOException;

public class BFS_DFS {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner s = new Scanner(System.in);
		int v = s.nextInt();
		int e = s.nextInt();
		boolean[][] graph = new boolean[v][v];
		// ArrayList<Boolean>[] mat = new ArrayList<Boolean>[2];
		for (int i = 0; i < e; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			graph[a][b] = true;
			graph[b][a] = true;
		}
		s.close();
		//bfs(graph, 0);
		boolean[] vis = new boolean[v];
		dfs(graph,0, vis);
		bfs(graph, 0,vis);
	}
	
	public static void dfs(boolean[][] graph, int vertex, boolean[] visited) {
		System.out.print(vertex+" ");
		visited[vertex] = true;
		for(int i=0; i<graph.length;i++) {
			if(graph[vertex][i]==true && visited[i]==false) {
				dfs(graph, i, visited);
			}
		}
		
	}
	
	public static void dfsDisconnectedGraph(boolean[][] graph) {
		boolean[] visited = new boolean[graph.length];
		for(int i=0; i<graph.length; i++) {
			dfsDisconnectedGraphHelper(graph, i, visited);
		}
	}
	
	public static void dfsDisconnectedGraphHelper(boolean[][] graph, int vertex, boolean[] visited) {
		System.out.print(vertex+" ");
		visited[vertex] = true;
		for(int i=0; i<graph.length;i++) {
			if(graph[vertex][i]==true && visited[i]==false) {
				dfsDisconnectedGraphHelper(graph, i, visited);
			}
		}
		
	}
	

	public static void bfsDisconnectedGraph(boolean[][] graph, int s) {
		int n = graph.length;
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			bfs(graph, i, visited);
		}
	}
	
	public static void bfs(boolean[][] graph, int vertex, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();
			if (visited[vertex] == false) {
				visited[vertex] = true;
				q.add(vertex);
			}
			while (!q.isEmpty()) {
				vertex = q.poll();
				System.out.print(vertex + " ");
				for (int i = 0; i < graph.length; i++) {
					if (graph[vertex][i] == true && visited[i] == false) {
						q.add(i);
						visited[i] = true;
					}
				}
			}
		
	}
}
