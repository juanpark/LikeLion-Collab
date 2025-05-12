package com.structural;

class ScoreService {
	private Score score;
	// private Score score = new Score(100, 100, 100);
	private WithGradeScore withgrade = new WithGradeScore(null);
	
	public ScoreService(int k, int e, int m) {
		score = new Score(k, e, m);
	}
	public void print() {
		System.out.println(score.getTotal());
		System.out.println(score.getAverage());
		System.out.println(withgrade.getReport());
	}
}

public class FacadeScore {
	
	
	public void printReport() {
		
	}
}
