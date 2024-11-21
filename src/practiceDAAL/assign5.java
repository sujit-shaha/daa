package practiceDAAL;

import java.util.Scanner;

public class assign5 {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.print("Enter number of one dimension of chess: ");
		n = sc.nextInt();
		int x, y;
		System.out.print("Enter starting X position in Chess board: ");
		x = sc.nextInt();
		System.out.print("Enter starting Y position in Chess board: ");
		y = sc.nextInt();
		
		new KnightTour(n).solveTour(x, y);

	}
	
}

//class KnightTour{
//	
//	int n;
//	int chess[][];
//
//	public KnightTour(int n) {
//		super();
//		this.n = n;
//		chess = new int[n][n];
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < n; j++) {
//				chess[i][j] = -1;
//			}
//		}
//
//	}
//	
//	void solveTour(int xStart,int yStart) {
//		
//	int[] xMoves = {2,1,-1,-2,-2,-1,1,2};
//	int[] yMoves = {1,2,2,1,-1,-2,-2,-1};
//	chess[xStart][yStart] = 0;
//	if(Tour(chess, 1, xMoves, yMoves, xStart, yStart)) {
//        for (int x = 0; x < n; x++) {
//            for (int y = 0; y < n; y++) {
//            	System.out.print(chess[x][y] + " ");
//            }
//            System.out.println();
//        }
//	
//
//	}else {
//		System.out.println("Solution is not possible with these positions");
//	}
//		
//	}
//	
//	public boolean Tour(int[][]chess,int movei,int[]xMoves,int[]yMoves,int x,int y) {
//		if(movei == n*n) {
//			return true;
//		}
//		int xNew,yNew,i;
//		for( i = 0;i<8;i++) {
//			xNew = x + xMoves[i];
//			yNew = y + yMoves[i];
//			if(Safe(xNew, yNew, chess)) {
//				chess[xNew][yNew] = movei;
//				if(Tour(chess, movei+1, xMoves, yMoves, xNew, yNew)) {
//					return true;
//				}
//				else {
//					chess[xNew][yNew] = -1;
//					
//				}
//			}
//		}
//		return false;
//	}
//	public boolean Safe(int x, int y, int Chess[][])
//    {
//        return (x >= 0 && x < n && y >= 0 && y < n && Chess[x][y] == -1);
//    }
//
//	
//	
//}

class KnightTour{
	
	int [][] chess;
	int n;
	public KnightTour(int n) {
		this.n = n;
		chess = new int[n][n];
		for(int i =0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				chess[i][j] = -1;
			}
		}
	}
	
	public void solveTour(int x,int y) {
		
		int[] xMoves = {2,1,-1,-2,-2,-1,1,2};
		int[] yMoves = {1,2,2,1,-1,-2,-2,-1};
		
		chess[x][y] = 0;
		if(Tour(x,y,xMoves,yMoves,1)) {
			for(int i = 0;i<n;i++) {
				for(int j = 0;j<n;j++) {
					System.out.print(chess[i][j] + " ");
				}
				System.out.println();
			}
		}else {
			System.out.println("Solution not possible for this starting position");
		}
		
	}
	
	public boolean Tour(int x,int y,int[]xMoves,int[]yMoves,int movei) {
		
		if(movei == n*n) return true;
		
		for(int i = 0;i<8;i++) {
			int xNew = x+xMoves[i];
			int yNew = y + yMoves[i];
			
			if(isSafe(xNew,yNew)) {
				chess[xNew][yNew] = movei;
				if(Tour(xNew,yNew,xMoves,yMoves,movei+1)) {
					return true;
				}else {
					chess[xNew][yNew] = -1;
				}
			}
			
		}
		return false;
		
	}
	
	public boolean isSafe(int x,int y) {
		return x>= 0 && y >= 0 && x< n&& y< n&& chess[x][y] == -1;
	}
	
}

