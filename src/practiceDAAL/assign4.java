package practiceDAAL;

import java.util.Scanner;

public class assign4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	   	System.out.println("Enter the number of nodes : ");
	   	int v = sc.nextInt();
	   	int graph[][] = new int[v][v];
	   	System.out.print("Enter the number of Edges : ");
	   	int e = sc.nextInt();
	   	for (int i = 0; i < e; i++) {
				
					System.out.print("Enter the value of edge in form of u,v,w ");
					int u = sc.nextInt();
					int V = sc.nextInt();
					int w = sc.nextInt();
					graph[u-1][V-1] = w;
					graph[V-1][u-1] = w;
				
			}
	   	System.out.println("Final graph : ");
	   	for (int i = 0; i < v; i++) {
				for (int j = 0; j < v; j++) {
					System.out.print(graph[i][j]);
					
				}
				System.out.print("\n");
			}

	   	
	   	new Dijskstra().solveDijkstra(graph, 0);
	}
	
}


//class Dijkstra{
//	
//	public void solveDijkstra(int [][] graph, int src) {
//		int n = graph.length;
//		
//		int [] dist = new int[n];
//		boolean [] visited = new boolean[n];
//		
//		for(int i =0;i<n;i++) {
//			dist[i] = Integer.MAX_VALUE;
//			visited[i] = false;
//		}
//		
//		dist[src] = 0;
//		
//		for(int i =0;i<n-1;i++) {
//			
//			int u = minDist(graph, n, dist, visited);
//			if(u == -1 || u>=n) {
//				System.out.println("Something went wrong");
//				return;
//			}
//			visited[u] = true;
//			for(int j = 0;j<n;j++) {
//				if(!visited[j] && graph[u][j] != 0  && dist[u] + graph[u][j] < dist[j]) {
//					dist[j] = dist[u] + graph[u][j];
//				}
//			}
//			
//			
//		}
//		
//	       System.out.println("Vertex   Distance from Source");
//	       for (int i = 0; i < n; i++) {
//	           System.out.println(i + "\t" + dist[i]);
//	       }
//
//		
//		
//	}
//	
//	
//	public int minDist(int [][] graph, int n, int [] dist, boolean [] visited) {
//		
//		int minIndex = -1;
//		int min = Integer.MAX_VALUE;
//		for(int i = 0;i<n;i++) {
//			if(!visited[i] && min > dist[i]) {
//				min = dist[i];
//				minIndex = i;
//			}
//		}
//		return minIndex;
//		
//	}
//	
//	
//	
//}


class Dijskstra{
	
	
	public void solveDijkstra(int[][]graph,int src) {
		
		int n = graph.length;
		
		int [] dist = new int[n];
		boolean[] visited = new boolean[n];
		
		
		for(int i = 0;i<n;i++) {
			dist[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}
		
		dist[src] = 0;
		
		for(int i = 0;i<n-1;i++) {
			
			int u = minIndex(dist,visited);
			
			visited[u] = true;
			for(int j = 0;j<n;j++) {
				if(!visited[j] && graph[u][j] != 0 && dist[j] > dist[u]+graph[u][j]) {
					dist[j] = dist[u] + graph[u][j];
				}
			}			
		}
		
		System.out.println("Vertex -> Distance/Cost");
		for(int i = 0;i<n;i++) {
			System.out.println(i +" -> "+ dist[i]);
		}
		
		
				
		
	}
	
	public int minIndex(int [] dist,boolean []visited) {
		int minVal = Integer.MAX_VALUE;
		int min = -1;
		for(int i = 0;i<dist.length;i++) {
			if(minVal > dist[i] && !visited[i]) {
				minVal = dist[i];
				min = i;
			}
		}
		return min;
	}
	
	
}
