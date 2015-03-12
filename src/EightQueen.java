import gps.GPSEngine;
import gps.GPSProblemImpl;
import gps.Position;
import gps.SearchStrategy;


public class EightQueen {
	public static void main(String[] args) throws InterruptedException {
		GPSEngine gps = new GPSEngine();
		gps.engine(new GPSProblemImpl(), SearchStrategy.DFS);
//		Position p0= new Position(0,0);
//		Position p1= new Position(1,4);
//		Position p2= new Position(2,7);
//		Position p3= new Position(3,5);
//		Position p4= new Position(4,2);
//		Position p5= new Position(5,6);
//		Position p6=new Position(6,1);
//		Position p7= new Position(7,3);
//		int[][] board = new int[8][8];
//		board[p0.getRow()][p0.getCol()]=1;
//		board[p1.getRow()][p1.getCol()]=1;
//		board[p2.getRow()][p2.getCol()]=1;
//		board[p3.getRow()][p3.getCol()]=1;
//		board[p4.getRow()][p4.getCol()]=1;
//		board[p5.getRow()][p5.getCol()]=1;
//		board[p6.getRow()][p6.getCol()]=1;
//		System.out.println(queenInSameDiagonal(board,p7));
//		System.out.println(queenInSameRow(board, p7));
//		System.out.println(queenInSameColumn(board,p7));
	}
	
	private static boolean queenInSameDiagonal(int[][] board, Position queen) {
		for (int i = queen.getRow(), j = queen.getCol(); i >= 0
				&& j < GPSProblemImpl.COLUMN_SIZE; i--, j++) {
			if (board[i][j] == 1) {
				return true;
			}
		}
		for (int i = queen.getRow(), j = queen.getCol(); i < GPSProblemImpl.ROW_SIZE
				&& j < GPSProblemImpl.COLUMN_SIZE; i++, j++) {
			if (board[i][j] == 1) {
				return true;
			}
		}
		for (int i = queen.getRow(), j = queen.getCol(); i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1) {
				return true;
			}
		}
		for (int i = queen.getRow(), j = queen.getCol(); i < GPSProblemImpl.ROW_SIZE
				&& j >= 0; i++, j--) {
			if (board[i][j] == 1) {
				return true;
			}
		}
		return false;
	}
	

	private static boolean queenInSameColumn(int[][] board, Position queen) {
		for (int i = 0; i < GPSProblemImpl.ROW_SIZE; i++) {
			if (board[i][queen.getCol()] == 1) {
				return true;
			}
		}
		return false;
	}

	private static boolean queenInSameRow(int[][] board, Position queen) {
		for (int i = 0; i < GPSProblemImpl.COLUMN_SIZE; i++) {
			if (board[queen.getRow()][i] == 1) {
				return true;
			}
		}
		return false;
	}
}
