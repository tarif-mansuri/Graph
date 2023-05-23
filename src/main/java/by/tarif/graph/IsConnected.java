//$Id$
package by.tarif.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IsConnected {


	public static void main(String[] args){
       
        /* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
		 */
		Scanner s = new Scanner(System.in);
		 int v = s.nextInt();
		 int e = s.nextInt();
		 boolean[][] graph = new boolean[v][v];
		 for(int i=0;i<e;i++){
			 int a = s.nextInt();
			 int b = s.nextInt();
			 graph[a][b] = true;
			 graph[b][a] = true;
		 }
		 System.out.println(bfs(graph, 0));
	}
	public static boolean bfs(boolean[][] graph, int s){
		int n = graph.length;
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[n];
			if(visited[s]==false){
				visited[s] = true;
				q.add(s);
			}
				while(!q.isEmpty() ){
				int v = q.poll();
				for(int j =0; j<n;j++){
					if(graph[v][j]==true && visited[j]==false){
						q.add(j);
						visited[j] = true;
					}
				}
				}
		for(int i=0;i<n;i++){
			if(visited[i]==false){
				return false;
			}
		}
		return true;

	}

}


