//$Id$
package by.tarif.graph;

import java.util.*;

public class GetPath_DFS {
	public static void main(String[] args) {
        
        /* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
		 */
		int v, e;
		 Scanner s = new Scanner(System.in);
		 v= s.nextInt();
		 e = s.nextInt();

		 boolean[][] g = new boolean[v][v];
		for(int i=0;i<e;i++){
			int a = s.nextInt();
			int b = s.nextInt();
			g[a][b] = true;
			g[b][a] = true;
		}
		int start = s.nextInt();
		int end = s.nextInt();

		boolean[] visited = new boolean[v];
		ArrayList<Integer> res = getPath(g, start, end, visited);
		if(res!=null) {
			res.add(start);
			for(int i =0; i< res.size(); i++){
				System.out.print(res.get(i)+" ");
			}
		}
	}

	public static ArrayList<Integer> getPath(boolean[][] g, int vertex, int e, boolean[] visited){
		if(vertex==e){
			ArrayList<Integer> res = new ArrayList<>();
			return res;
		}
		if(visited[vertex] ==false){
			visited[vertex] = true;
		}
		for(int i=0;i<g.length;i++){
			if(g[vertex][i] == true && visited[i]==false){
				visited[i]=true;
				ArrayList<Integer> temp = getPath(g, i, e,visited);
				if(temp!=null){
					temp.add(i);
				}
				return temp;
			}
		}
		return null;
	}

}
