//$Id$
package by.tarif.graph;

import java.util.Scanner;

public class PrimsMinimumSpanningTree {
	
	public static void printMST(int[][] g) {
		int n = g.length;
		int[] parent = new int[n];
		int[] weight = new int[n];
		boolean[] visited = new boolean[n];
		parent[0] = -1;
		weight[0] = 0;
		for(int i=1; i<n;i++) {
			weight[i] = Integer.MAX_VALUE;
		}
		for(int i=0; i<n; i++) {
			int vertex = minVertext(visited, weight);
			visited[vertex] = true;
			for(int j = 0; j<n; j++) {
				if(visited[j]==false && g[vertex][j] != 0) {
					if(weight[j]>g[vertex][j]) {
						weight[j] = g[vertex][j];
						parent[j] = vertex;
					}
				}
			}
		}
		
		//print the tree
		for(int i=1;i<parent.length;i++) {
			System.out.println(parent[i]+" "+i+" "+weight[i]);
		}
	}

	private static int minVertext(boolean[] visited, int[] weight) {
		int minValue = Integer.MAX_VALUE;
		int minIndex = -1;
		for(int i=0;i<visited.length;i++) {
			if(visited[i]==false && weight[i]<minValue) {
				minValue = weight[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int v = s.nextInt();
		int e = s.nextInt();

		int[][] graph = new int[v][v];
		for(int i=0;i<e;i++){
			int start = s.nextInt();
			int end = s.nextInt();
			int weight = s.nextInt();
			graph[start][end] = weight;
			graph[end][start] = weight;
		}
		printMST(graph);
	}

}
