package gps;

import gps.api.GPSProblem;
import gps.api.GPSRule;
import gps.api.GPSState;
import gps.exception.EndInterruption;
import gps.exception.NotAppliableException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Abstract?
public class GPSEngine {

	private List<GPSNode> open = new LinkedList<GPSNode>();

	private List<GPSNode> closed = new ArrayList<GPSNode>();

	private GPSProblem problem;

	// Use this variable in the addNode implementation
	private SearchStrategy strategy;

	public void engine(GPSProblem myProblem, SearchStrategy myStrategy) throws InterruptedException {

		problem = myProblem;
		strategy = myStrategy;

		GPSNode rootNode = new GPSNode(problem.getInitState(), 0);
		boolean finished = false;
		boolean failed = false;
		long explosionCounter = 0;

		open.add(rootNode);
		while (!failed && !finished) {
			if (open.size() <= 0) {
				failed = true;
			} else {
				GPSNode currentNode = open.get(0);
				closed.add(currentNode);
				open.remove(0);
				if (problem.isGoal(currentNode.getState())) {
					finished = true;
					System.out.println(currentNode.getSolution());
					System.out.println("Expanded nodes: " + explosionCounter);
				} else {
//					System.out.println("Explode");
					explosionCounter++;
					try {
						explode(currentNode);
					} catch (EndInterruption e) {
					}
				}
			}
		}

		if (finished) {
			System.out.println("OK! solution found!");
		} else if (failed) {
			System.err.println("FAILED! solution not found!");
		}
	}

	private boolean explode(GPSNode node) throws EndInterruption, InterruptedException {
		if (problem.getRules() == null) {
			System.err.println("No rules!");
			return false;
		}

		for (GPSRule rule : problem.getRules()) {
//			System.out.println(rule.getName());
			GPSState newState = null;
			try {
				newState = rule.evalRule(node.getState());
			} catch (NotAppliableException e) {
				// Do nothing
			}
			if (newState != null
					&& !checkBranch(node, newState)
					&& !checkOpenAndClosed(node.getCost() + rule.getCost(),
							newState)) {
				GPSNode newNode = new GPSNode(newState, node.getCost()
						+ rule.getCost());
				newNode.setParent(node);
				addNode(newNode);
			}
		}
		if(problem.isGoal(node.getState())){
			System.out.println("Is true");
			printBoard(node.getState().getBoard());
			throw new EndInterruption();
		}
		open.remove(node);
		closed.add(node);

//		printBoard(node.getState().getBoard());
//		 Thread.sleep(1337);
		return true;
	}

	private boolean checkOpenAndClosed(Integer cost, GPSState state) {
		for (GPSNode openNode : open) {
			if (openNode.getState().compare(state) && openNode.getCost() < cost) {
				return true;
			}
		}
		for (GPSNode closedNode : closed) {
			if (closedNode.getState().compare(state)
					&& closedNode.getCost() < cost) {
				return true;
			}
		}
		return false;
	}

	private boolean checkBranch(GPSNode parent, GPSState state) {
		if (parent == null) {
			return false;
		}
		return checkBranch(parent.getParent(), state)
				|| state.compare(parent.getState());
	}

	// IMPLEMENTAR cambia segun la estrategia
	public void addNode(GPSNode node) throws InterruptedException, EndInterruption {
		if (strategy == SearchStrategy.DFS) {
			addNodeDFS(node);
		} else if (strategy == SearchStrategy.BFS) {
			addNodeBFS(node);
		} else if (strategy == SearchStrategy.AStar) {
			// AStar method
		} else {
			// error
		}
	}

	private void addNodeBFS(GPSNode node) {
		open.add(node);
	}
	
	private void addNodeDFS(GPSNode node) throws InterruptedException, EndInterruption{
//		System.out.println("Add node");
		open.add(node);
//		System.out.println(open.size());
//		printBoard(node.getState().getBoard());
		explode(node);
	}
	
	private void printBoard(int[][] board){
		for(int i=0; i<8;i++){
			for(int j=0;j<8;j++){
				System.out.print(board[i][j]);
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.println("");
	}
	
}
