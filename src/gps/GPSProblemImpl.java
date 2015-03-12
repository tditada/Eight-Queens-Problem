package gps;

import gps.api.GPSProblem;
import gps.api.GPSRule;
import gps.api.GPSState;

import java.util.ArrayList;
import java.util.List;

public class GPSProblemImpl implements GPSProblem {

	public static int COLUMN_SIZE = 8;
	public static int ROW_SIZE = 8;
	public static int QUEENS = 8;

	@Override
	public GPSState getInitState() {
		return new GPSStateImpl();
	}

	@Override
	public List<GPSRule> getRules() {
		List<GPSRule> rules = new ArrayList<GPSRule>();
//		rules.add(new GPSRuleImpl(new Position(0,0)));
//		rules.add(new GPSRuleImpl(new Position(1,4)));
//		rules.add(new GPSRuleImpl(new Position(2,7)));
//		rules.add(new GPSRuleImpl(new Position(3,5)));
//		rules.add(new GPSRuleImpl(new Position(4,2)));
//		rules.add(new GPSRuleImpl(new Position(5,6)));
//		rules.add(new GPSRuleImpl(new Position(6,1)));
//		rules.add(new GPSRuleImpl(new Position(7,3)));
		for (int i = 0; i < ROW_SIZE; i++) {
			for (int j = 0; j <COLUMN_SIZE; j++) {
				GPSRuleImpl rule = new GPSRuleImpl(new Position(i,j));
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
		for(int i=0; i<GPSProblemImpl.ROW_SIZE;i++){
			for(int j=0; j<GPSProblemImpl.COLUMN_SIZE;j++){
				if(state.getBoard()[i][j]==1){
					queens++;
				}
			}
		}
		return queens == QUEENS;
	}

}
