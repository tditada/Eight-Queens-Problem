package gps;

import java.util.ArrayList;
import java.util.List;

import gps.api.GPSRule;
import gps.api.GPSState;
import gps.exception.NotAppliableException;

public class GPSRuleImpl implements GPSRule{
	private Position queen;
	
	public GPSRuleImpl(Position queen) {
		this.queen=queen;
	}
	
	@Override
	public Integer getCost() {
		return 1;
	}

	@Override
	public String getName() {
		return "Row: " + String.valueOf(queen.getRow())
				+ ", Col: " + String.valueOf(queen.getCol());
	}

	@Override
	public GPSState evalRule(GPSState state) throws NotAppliableException {
		if(ableToEval(state)){
			List<Position> newBoard = new ArrayList<Position>();
			newBoard.addAll(state.getBoard());
			newBoard.add(queen);
			return new GPSStateImpl(newBoard);
		}
		throw new NotAppliableException();
	}
	
	private boolean ableToEval(GPSState state){
		List<Position> board = state.getBoard();
		if(board.contains(queen)){
			return false;
		}
		if(queenInSameColumn(board) || queenInSameRow(board) || queenInSameDiagonal(board)){
			return false;
		}
		return true;		
	}
	
	private boolean queenInSameColumn(List<Position> board){
		for(Position p:board){
			if(p.getCol()==queen.getCol()){
				return true;
			}
		}
		return false;
	}

	private boolean queenInSameRow(List<Position> board){
		for(Position p:board){
			if(p.getRow()==queen.getRow()){
				return true;
			}
		}
		return false;
	}
	
	private boolean queenInSameDiagonal(List<Position> board){
		Position p;
		for(int i= queen.getRow(), j=queen.getCol(); i>=0 && j< GPSProblemImpl.COLUMN_SIZE; i--, j++){
			p= new Position(i,j);
			if(board.contains(p)){
				return true;
			}
		}
		for(int i= queen.getRow(), j=queen.getCol(); i<GPSProblemImpl.ROW_SIZE && j< GPSProblemImpl.COLUMN_SIZE; i++, j++){
			p= new Position(i,j);
			if(board.contains(p)){
				return true;
			}
		}
		for(int i= queen.getRow(), j=queen.getCol(); i>=0 && j>=0; i--, j--){
			p= new Position(i,j);
			if(board.contains(p)){
				return true;
			}
		}
		for(int i= queen.getRow(), j=queen.getCol(); i<GPSProblemImpl.ROW_SIZE && j>=0; i++, j--){
			p= new Position(i,j);
			if(board.contains(p)){
				return true;
			}
		}
		return false;
	}
	
}
