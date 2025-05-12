package com.structural;

// Legacy System
class OldScoreSystem {
	public int getSum() {
		return 270;
	}
	public double getAvg() {
		return 90.0;
	}
}

// Adapter
class AdapterScore extends Score {

	private OldScoreSystem oldSystem;
	
	public AdapterScore(OldScoreSystem oldSystem) {
		super(0, 0, 0);
		this.oldSystem = oldSystem;
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return oldSystem.getSum();
	}

	@Override
	public double getAverage() {
		// TODO Auto-generated method stub
		return oldSystem.getAvg();
	}
		
}
