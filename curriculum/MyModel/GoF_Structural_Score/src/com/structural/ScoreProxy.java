package com.structural;

public class ScoreProxy {
	private Score score = new Score(100, 100, 100);
	private Integer cached = null;
	
	public int getTot() {
		if(score != null) {
			return score.getTotal();
		} else {
			return cached;
		}
	}
	
	
}
