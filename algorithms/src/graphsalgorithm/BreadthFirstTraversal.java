package graphsalgorithm;

import java.util.Iterator;
import java.util.LinkedList;

public class BreadthFirstTraversal {
	int V;
	LinkedList<Integer> adj[];
	
	public BreadthFirstTraversal(int v) {
		V = v;
		adj = new LinkedList[v];
		for(int i=0; i<v; ++i) {
			adj[i]= new LinkedList<>();
		}
		
	}
	void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	void BFS(int s) {
		boolean[] visited = new boolean[V];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[s] = true;
		queue.offer(s);
		while(queue.size() != 0) {
			s= queue.poll();
			System.out.println(s);
			Iterator<Integer> iterator = adj[s].listIterator();
			while(iterator.hasNext()) {
				int n= iterator.next();
				if(!visited[n]) {
					visited[n] = true;
					queue.offer(n);
				}
			}
			
		}
		
	}
	

	public static void main(String[] args) {
		BreadthFirstTraversal bft = new BreadthFirstTraversal(4);
		bft.addEdge(0, 1);
		bft.addEdge(0, 2);
		bft.addEdge(1, 2);
		bft.addEdge(2, 0);
		bft.addEdge(2, 3);
		bft.addEdge(3, 3);
		bft.BFS(2);
		

	}

}
