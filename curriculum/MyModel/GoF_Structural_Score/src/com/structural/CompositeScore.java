package com.structural;
import java.util.ArrayList;
import java.util.List;

interface ScoreComponent{
	 int getTotal(); 
	 double  getAverage();	
}
///개별 객체
class SubjectScore  implements  ScoreComponent{	
	private int score;
    public SubjectScore(int score) {
    	 this.score  =  score ;
    }	
	@Override
	public int getTotal() {		
		return score;
	}
	@Override
	public double getAverage() {		
		return score;
	}	
}
//복합객체  
class CompositeScore {
       private  List<ScoreComponent>  scores  =  new ArrayList<>();
       
       public void add(ScoreComponent   sc ) {
    	   scores.add(sc);
       }
     
   	 public int getTotal() {		
   		return scores.stream().mapToInt(ScoreComponent::getTotal).sum();
   	 }
   
   	 public double getAverage() {		
   		return getTotal()/ (double) scores.size() ;
   	 }	
       
}




