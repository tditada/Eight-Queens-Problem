package games;
import gps.GPSEngine;
import gps.GPSQueensProblem;
import gps.SearchStrategy;

public class EightQueen {
	public static void main(String[] args) throws InterruptedException {
		GPSEngine gps = new GPSEngine();
		gps.engine(new GPSQueensProblem(), SearchStrategy.BFS);		
	}
}
	