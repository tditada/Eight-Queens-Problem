package gps;

import java.util.List;

import gps.api.GPSProblem;
import gps.api.GPSRule;
import gps.api.GPSState;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getHValue(GPSState state) {
		// Retorna 0 para DFS y BFS
		return 0;
	}

	@Override
	public boolean isGoal(GPSState state) {
		return state.getBoard().size() == QUEENS;
	}

}
