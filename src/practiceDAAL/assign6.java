package practiceDAAL;
//
//import java.lang.reflect.Array;
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.PriorityQueue;
//import java.util.Scanner;
//
//public class assign6 {
//
//	
//    static final int INF = Integer.MAX_VALUE;
//
//    static class Node {
//        int[] assigned;
//        boolean[] available;
//        int cost;
//        int level;
//
//        Node(int[] assigned, boolean[] available, int cost, int level) {
//            this.assigned = assigned.clone();
//            this.available = available.clone();
//            this.cost = cost;
//            this.level = level;
//        }
//    }
//
//    static int findMinCost(int[][] costMatrix, int N) {
//        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
//
//        boolean[] available = new boolean[N];
//        Arrays.fill(available, true);
//
//        int[] assigned = new int[N];
//        Node root = new Node(assigned, available, 0, 0);
//        pq.add(root);
//
//        while (!pq.isEmpty()) {
//            Node node = pq.poll();
//            int level = node.level;
//
//            if (level == N) {
//                return node.cost;
//            }
//
//            for (int i = 0; i < N; i++) {
//                if (node.available[i]) {
//                    node.assigned[level] = i;
//                    node.available[i] = false;
//
//                    int newCost = node.cost + costMatrix[level][i];
//                    pq.add(new Node(node.assigned, node.available, newCost, level + 1));
//
//                    node.available[i] = true;
//                }
//            }
//        }
//        return INF;
//    }
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		int n;
//		System.out.println("Enter no. of clubs: ");
//		n = sc.nextInt();
//		int ip;
//		
//		int[][] costMatrix =  {
//	            {9, 2, 7, 8},
//	            {6, 4, 3, 7},
//	            {5, 8, 1, 8},
//	            {7, 6, 9, 4}
//	        };
//		for(int i = 0; i < n; i++) {
//			System.out.println("Enter Cost Matrix line by line ( end with -1): ");
//			ip = sc.nextInt();
//			int j=0;
//			while(ip != -1) {
//				costMatrix[i][j] = ip;
//				j++;
//				ip = sc.nextInt();				
//			}
//		}
//
//	        int N = costMatrix.length;
//	        int minCost = findMinCost(costMatrix, N);
//	        System.out.println("Minimum cost: " + minCost);
//	}
//
//	
//}


import java.util.*;

public class assign6 {

    static class Node {
        int level;        // Depth of node in the decision tree
        int cost;         // Cost of the partial solution
        int[] assignment; // Current assignments

        Node(int level, int cost, int[] assignment) {
            this.level = level;
            this.cost = cost;
            this.assignment = assignment.clone();
        }
    }

    public static int findMinCost(int[][] costMatrix) {
        int n = costMatrix.length;

        // Priority Queue for branch and bound
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));

        // Initial node with no assignments
        Node root = new Node(-1, 0, new int[n]);
        Arrays.fill(root.assignment, -1);

        pq.add(root);

        int minCost = Integer.MAX_VALUE;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            // If all students are assigned, check the cost
            if (current.level == n - 1) {
                minCost = Math.min(minCost, current.cost);
                for(int i = 0;i<n;i++) {
                	System.out.println(current.assignment[i]);
                }
                continue;
            }

            // Expand the current node (assign next student)
            int nextStudent = current.level + 1;
            for (int club = 0; club < n; club++) {
                // Check if the club is already assigned
                if (isSafeToAssign(current.assignment, club, nextStudent)) {
                    // Calculate cost of assigning this student to this club
                    int newCost = current.cost + costMatrix[nextStudent][club];

                    // Prune paths with cost already exceeding the minimum
                    if (newCost >= minCost) continue;

                    // Create a new node for this assignment
                    Node child = new Node(nextStudent, newCost, current.assignment);
                    child.assignment[nextStudent] = club;

                    pq.add(child);
                }
            }
        }
        

        return minCost;
    }

    // Utility function to check if assigning a student to a club is safe
    private static boolean isSafeToAssign(int[] assignment, int club, int student) {
        for (int i = 0; i <= student; i++) {
            if (assignment[i] == club) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Example: Cost matrix where costMatrix[i][j] is the cost for student i to join club j
        int[][] costMatrix = {
            {9,2,7,8},
            {6,4,3,7},
            {5,8,1,8},
            {7,6,9,4}
        };

        int minCost = findMinCost(costMatrix);
        System.out.println("The minimum cost for assigning students to clubs is: " + minCost);
    }
}