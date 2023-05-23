//$Id$
package by.tarif.graph;

import java.util.*;

public class GetPath_BFS {
	public static void main(String[] args){
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
		HashMap<Integer, Integer> map = getPath(g, start, end, visited);
		if(map!=null) {
			while(end !=-1) {
				System.out.print(end +" ");
				end = map.get(end);
			}
		}
	}

	public static HashMap<Integer, Integer> getPath(boolean[][] g, int vertex, int e, boolean[] visited){
		HashMap<Integer, Integer> map = new HashMap<>();
		Queue<Integer> q = new LinkedList<>();
		q.add(vertex);
		visited[vertex] = true;
		map.put(vertex, -1);
		while(!q.isEmpty()){
			vertex = q.poll();
			for(int i=0;i<g.length;i++){
				if(g[vertex][i]==true && visited[i]==false){
					q.add(i);
					visited[i] = true;
					map.put(i, vertex);
					if(i == e) {
						return map;
					}
				}
			}
		}
		
		return null;
	}

}
