//$Id$
package by.tarif.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ObjectSorting {
	public static void main(String[] abs) {
		Scanner s = new Scanner(System.in);
		int e = s.nextInt();
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for(int i=0;i<e;i++) {
			int start = s.nextInt();
			int end = s.nextInt();
			int w = s.nextInt();
			Edge edge = new Edge(start, end, w);
			edges.add(edge);
		}
		Collections.sort(edges);
		for(Edge edgeObject : edges) {
			System.out.println(edgeObject.start+ " " + edgeObject.end + " "+ edgeObject.weight);
		}
	}
}

//class Edge implements Comparable<Edge>{
//	int start;
//	int end;
//	int weight;
//	
//	public Edge(int s, int e, int w) {
//		this.start = s;
//		this.end = e;
//		this.weight = w;
//	}
//
//	public int compareTo(Edge obj) {
//		if(this.weight<obj.weight) {
//			return -1;
//		}else if(this.weight == obj.weight) {
//			return 0;
//		}else {
//			return 1;
//		}
//	}
//}
