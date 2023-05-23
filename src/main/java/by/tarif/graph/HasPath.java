//$Id$
package by.tarif.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HasPath {
	public static void main(String[] args) {
        /* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
		 */
		 Scanner s = new Scanner(System.in);
		 int v,e;
		 v = s.nextInt();
		 e = s.nextInt();
		 if(v==0){
			System.out.println(false);
			s.close();
			return;
		}
		 boolean[][] graph = new boolean[v][v];
		 for(int i = 0; i<e; i++){
			 int a = s.nextInt();
			 int b = s.nextInt();
			 graph[a][b] = true;
			 graph[b][a] = true;
		 }
		 int start = s.nextInt();
		 int end = s.nextInt();
		 boolean[] visited = new boolean[v];
		 s.close();
		if(v==0){
			System.out.println(true);
		}else{
			System.out.println(pathExist(graph, start, end, visited));
		}
	}
	public static boolean pathExist(boolean[][] edges, int source, int destination, boolean[] visited){
		
		if(source == destination){
            return true;
        }
        Queue<Integer> q = new LinkedList<>();
        if(visited[source] == false){
            visited[source] = true;
            q.add(source);
        }
        while(!q.isEmpty()){
            int v = q.poll();
            if(v == destination){
                return true;
            }
            for(int i = 0; i<edges.length; i++){
                if(edges[v][i] == true && visited[i] == false){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
        return false;
	}

}
