package graphsalgorithm;

public class FloydWarshallAlgorithm {
	static int INF = 99999;
	int v = 4;
	void floydWarshall(int graph[][]) {
		int dist[][] = new int[v][v];
		for (int i=0;i<v;i++) {
			for(int j =0;j<v;j++) {
				dist[i][j]= graph[i][j];
			}
		}
		for(int k=0;k<v;k++) {
			for (int i=0;i<v;i++) {
				for(int j =0;j<v;j++) {
					
					if(dist[i][k]+dist[k][j]<dist[i][j]) {
						dist[i][j]= dist[i][k]+ dist[k][j];
					}								
				}
			}
		}
		printSolution(dist);
	}
	void printSolution(int dist[][])
    {
        System.out.println("Following matrix shows the shortest "+
                         "distances between every pair of vertices");
        for (int i=0; i<v; ++i)
        {
            for (int j=0; j<v; ++j)
            {
                if (dist[i][j]==INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j]+"   ");
            }
            System.out.println();
        }
    }
	
	public static void main(String[] args) {
		 int graph[][] = { {0,   5,  INF, 10},
                 {INF, 0,   3, INF},
                 {INF, INF, 0,   1},
                 {INF, INF, INF, 0}
               };
   FloydWarshallAlgorithm a = new FloydWarshallAlgorithm();

    a.floydWarshall(graph);

	}

}
