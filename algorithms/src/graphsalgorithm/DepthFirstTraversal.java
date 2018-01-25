package graphsalgorithm;

import java.util.Iterator;
import java.util.LinkedList;

public class DepthFirstTraversal {
	int V;
	LinkedList<Integer> adj[];
	public DepthFirstTraversal(int v) {
		V=v;
		adj = new LinkedList[v];
		for(int i = 0; i<v;++i) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	void addEdge(int v , int w) {
		adj[v].offer(w);
	}
	
	void DFTUtil(int s, boolean valid[]) {
		valid[s] = true;
		System.out.println(s);
		Iterator<Integer> i = adj[s].listIterator();
		while(i.hasNext()) {
			int n = i.next();
			if(!valid[n]) {
				DFTUtil(n, valid);
			}
		}
	}
	void DFT(int s) {
		boolean[] visited = new boolean[V];
		DFTUtil(s, visited);
		
		
	}

	public static void main(String[] args) {
		 DepthFirstTraversal g = new DepthFirstTraversal(4);
		 
	        g.addEdge(0, 1);
	        g.addEdge(0, 2);
	        g.addEdge(1, 2);
	        g.addEdge(2, 0);
	        g.addEdge(2, 3);
	        g.addEdge(3, 3);
	 
	        System.out.println("Following is Depth First Traversal "+
	                           "(starting from vertex 2)");
	 
	        g.DFT(2);

	}

}
