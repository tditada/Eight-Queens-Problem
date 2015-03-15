package gps;

import java.util.LinkedList;

public class GPSEngineImpl extends GPSEngine{
	
	private void addNodeDFS(GPSNode node) {
		//adds node to the beginning of the list
		((LinkedList<GPSNode>) open).addFirst(node);
	}
	
	private void addNodeBFS(GPSNode node) {
		//adds node to the end of the list
		open.add(node);
	}

	public void addNode(GPSNode node){
		switch(strategy){
			case DFS:
				addNodeDFS(node);
				break;
			case BFS:
				addNodeBFS(node);
				break;
			default:
				break;
		}
	}
}
