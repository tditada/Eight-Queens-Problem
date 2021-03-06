package gps;

import gps.api.GPSRule;
import gps.api.GPSState;
import gps.exception.NotAppliableException;

public class GPSQueensRule implements GPSRule {
	private Position queen;

	public GPSQueensRule(Position queen) {
		this.queen = queen;
	}

	@Override
	public Integer getCost() {
		return 1;
	}

	@Override
	public String getName() {
		return "queen in:x=" + queen.getRow() + " y=" + queen.getCol();
	}

	// ¿Esta bien haber tenido que poner un limite para el estado final?
	@Override
	public GPSState evalRule(GPSState state) throws NotAppliableException {
		int[][] newBoard = new int[8][8];
		if (ableToEval(state)) {
			newBoard = copyBoard(state.getBoard());
			newBoard[queen.getRow()][queen.getCol()] = 1;
			return new GPSQueensState(newBoard);
//			return new GPSStateImpl(newBoard, state.getQueens()+1);
		}
		throw new NotAppliableException();
	}

	private boolean ableToEval(GPSState state) {
		int[][] board = state.getBoard();
		if (board[queen.getRow()][queen.getCol()] == 1) {
			return false;
		}
		if (queenInSameColumn(board) || queenInSameRow(board)
				|| queenInSameDiagonal(board) || !isUpperAbleRow(board)) {
			return false;
		}
		return true;
	}

	private boolean isUpperAbleRow(int[][] board){
		for (int i = 0; i < queen.getRow(); i++) {
			boolean isQueen=false;
			for (int j = 0; j < GPSQueensProblem.COLUMN_SIZE; j++) {
				if(board[i][j]==1){
					isQueen=true;
				}
			}
			if(!isQueen){
				return false;
			}
		}
		return true;
	}
	
	private boolean queenInSameColumn(int[][] board) {
		for (int i = 0; i < GPSQueensProblem.ROW_SIZE; i++) {
			if (board[i][queen.getCol()] == 1) {
				return true;
			}
		}
		return false;
	}

	private boolean queenInSameRow(int[][] board) {
		for (int i = 0; i < GPSQueensProblem.COLUMN_SIZE; i++) {
			if (board[queen.getRow()][i] == 1) {
				return true;
			}
		}
		return false;
	}

	private boolean queenInSameDiagonal(int[][] board) {
		for (int i = queen.getRow(), j = queen.getCol(); i >= 0
				&& j < GPSQueensProblem.COLUMN_SIZE; i--, j++) {
			if (board[i][j] == 1) {
				return true;
			}
		}
		for (int i = queen.getRow(), j = queen.getCol(); i < GPSQueensProblem.ROW_SIZE
				&& j < GPSQueensProblem.COLUMN_SIZE; i++, j++) {
			if (board[i][j] == 1) {
				return true;
			}
		}
		for (int i = queen.getRow(), j = queen.getCol(); i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1) {
				return true;
			}
		}
		for (int i = queen.getRow(), j = queen.getCol(); i < GPSQueensProblem.ROW_SIZE
				&& j >= 0; i++, j--) {
			if (board[i][j] == 1) {
				return true;
			}
		}
		return false;
	}

	private int[][] copyBoard(int[][] board) {
		int[][] retBoard = new int[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				retBoard[i][j] = board[i][j];
			}
		}
		return retBoard;
	}

}
