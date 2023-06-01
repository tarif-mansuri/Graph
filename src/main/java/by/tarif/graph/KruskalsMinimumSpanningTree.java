//$Id$
package by.tarif.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class KruskalsMinimumSpanningTree {
	
	public static ArrayList<Edge> getMST(Graph g){
		Collections.sort(g.edges);
		int[] parent = new int[g.vCount];
		for(int i=0;i<parent.length;i++) {
			parent[i] = i;
		}
		ArrayList<Edge> res = new ArrayList<Edge>();
		for(Edge e: g.edges) {
			if(!isCycle(parent, e.start, e.end)) {
				res.add(e);
				parent[getParent(parent, e.start)] = e.end;
			}
		}
		return res;
	}
	
	public static boolean isCycle(int[] parent, int start, int end) {
		if(getParent(parent, start) == getParent(parent, end)) {
			return true;
		}
		return false;
	}
	
	public static int getParent(int[] parent, int vertex) {
		if(parent[vertex] == vertex) {
			return vertex;
		}
		return getParent(parent, parent[vertex]);
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int v = s.nextInt();
		int e = s.nextInt();
		ArrayList<Edge> edges = new ArrayList<Edge>();
		
		for(int i = 0; i<e; i++) {
			int start = s.nextInt();
			int end = s.nextInt();
			int weight = s.nextInt();
			Edge edge = new Edge(start, end, weight);
			edges.add(edge);
		}
		s.close();
		Graph g = new Graph(v, e, edges);
		ArrayList<Edge> msEdges = getMST(g);
		for(Edge edge: msEdges) {
			System.out.println("From Vertex "+edge.start+" to vertex "+edge.end+" with weight "+edge.weight);
		}
	}

}

class Edge implements Comparable<Edge>{
	int start;
	int end;
	int weight;
	
	public Edge(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge edge) {
		if(this.weight < edge.weight) {
			return -1;
		}else if(this.weight == edge.weight){
			return 0;
		}else {
			return 1;
		}
	}
	
}
class Graph{
	int vCount;
	int eCount;
	ArrayList<Edge> edges;
	public Graph(int vCount, int eCount, ArrayList<Edge> edges) {
		this.vCount = vCount;
		this.eCount = eCount;
		this.edges = edges;
	}
}
