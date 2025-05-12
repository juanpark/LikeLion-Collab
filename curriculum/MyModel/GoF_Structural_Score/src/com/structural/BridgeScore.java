package com.structural;

/////////추상 
abstract class  ScoreDisplay{
	protected Score score ; 
	public ScoreDisplay(Score score) {
		this.score  = score;
	}	
	public abstract void show() ;	
}
/////구현 
class  ConsoleScoreDisplay  extends ScoreDisplay{
	public ConsoleScoreDisplay(Score score) {
		super(score);		
	}
	@Override
	public void show() {
		
	}	
}

class   WebScoreDisplay  extends ScoreDisplay{

	public WebScoreDisplay(Score score) {
		super(score);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void show() {		
		
	}
	
}