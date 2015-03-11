package gps;

import java.util.ArrayList;
import java.util.List;

import gps.api.GPSProblem;
import gps.api.GPSRule;
import gps.api.GPSState;

public class GPSProblemImpl implements GPSProblem {

	@Override
	public GPSState getInitState() {
		return new GPSStateImpl();
	}

	@Override
	public GPSState getGoalState() {
		List<Position> goalBoard=new ArrayList<Position>();
		goalBoard.add(new Position(0,3));
		goalBoard.add(new Position(1,6));
		goalBoard.add(new Position(2,2));
		goalBoard.add(new Position(3,7));
		goalBoard.add(new Position(4,1));
		goalBoard.add(new Position(5,4));
		goalBoard.add(new Position(6,0));
		goalBoard.add(new Position(7,5));
		GPSState goal = new GPSStateImpl(goalBoard);
		return goal;
	}
	
	@Override
	public List<GPSRule> getRules() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getHValue(GPSState state) {
		//  Retorna 0 para DFS y BFS
		return 0;
	}

}
