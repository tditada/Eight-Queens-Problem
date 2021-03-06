package gps;

import gps.api.GPSProblem;
import gps.api.GPSRule;
import gps.api.GPSState;

import java.util.ArrayList;
import java.util.List;

public class GPSQueensProblem implements GPSProblem {

	public static int COLUMN_SIZE = 8;
	public static int ROW_SIZE = 8;
	public static int QUEENS = 8;

	@Override
	public GPSState getInitState() {
		return new GPSQueensState();
	}

	@Override
	public List<GPSRule> getRules() {
		List<GPSRule> rules = new ArrayList<GPSRule>();
		for (int i = 0; i < ROW_SIZE; i++) {
			for (int j = 0; j <COLUMN_SIZE; j++) {
				GPSQueensRule rule = new GPSQueensRule(new Position(i,j));
				rules.add(rule);
			}
		}
		return rules;
	}

	@Override
	public Integer getHValue(GPSState state) {
		// Retorna 0 para DFS y BFS
		return 0;
	}

	public boolean isGoal(GPSState state) {
		int queens=0;
		for(int i=0; i<GPSQueensProblem.ROW_SIZE;i++){
			for(int j=0; j<GPSQueensProblem.COLUMN_SIZE;j++){
				if(state.getBoard()[i][j]==1){
					queens++;
				}
			}
		}
		return queens == QUEENS;
	}

}
