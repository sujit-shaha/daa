package practiceDAAL;

import java.util.Scanner;

public class assign3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of vertices : ");
		int n = sc.nextInt();
		
		System.out.println("Now Enter the graph of size nxn for INF enter 9999");
		
		int graph[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				graph[i][j] = sc.nextInt();
			}
		}
		
		
		for(int k = 0;k<n;k++) {
			for(int j = 0;j<n;j++) {
				for(int i= 0;i<n;i++) {
					if(graph[j][i]>graph[j][k]+graph[k][i]) {
						graph[j][i] = graph[j][k]+graph[k][i];
					}
					
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(graph[i][j]);;
			}
		}
		
		

	}
	
}
