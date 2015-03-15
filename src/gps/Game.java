package gps;


public class Game {
	
	public static void main(String[] args) {
		GPSEngine gps = new GPSEngineImpl();
//		gps.engine(new GPSProblemImpl(), SearchStrategy.DFS);
		gps.engine(new GPSProblemImpl(), SearchStrategy.BFS);
	}

}
