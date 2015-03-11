package gps;

import java.util.ArrayList;
import java.util.List;

import gps.api.GPSState;


public class GPSStateImpl implements GPSState {
	
	public static int COLUMN_SIZE = 8;
	public static int ROW_SIZE = 8;
	
	private List<Position> board = new ArrayList<Position>();
	
	public GPSStateImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public GPSStateImpl(List<Position> board){
		this.board=board;
	}

	@Override
	public boolean compare(GPSState state) {
		return this.getBoard().containsAll(state.getBoard())
				&& state.getBoard().containsAll(this.getBoard());
	}

	@Override
	public List<Position> getBoard() {
		return board;
	}

}