package gps;

import gps.api.GPSState;


public class GPSStateImpl implements GPSState {
	
	private int[][] board = new int[8][8];
	
	public GPSStateImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public GPSStateImpl(int[][] board){
		this.board=board;
	}

	@Override
	public boolean compare(GPSState state) {
		for(int i=0; i<GPSProblemImpl.ROW_SIZE; i++){
			for(int j=0; j<GPSProblemImpl.COLUMN_SIZE;j++){
				if(board[i][j]!=state.getBoard()[i][j]){
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public int[][] getBoard() {
		return board;
	}
	

}