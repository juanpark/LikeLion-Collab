package com.structural;

interface  ReportComponet{
	String getReport();	
}

class BaseScore  implements  ReportComponet{
	 private  int kor,eng,mat;

	public BaseScore(int kor, int eng, int mat) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	@Override
	public String getReport() {
		int tot  = kor+ eng + mat ; 
		double avg  = tot/3.0; 
		return  "총점 :"  + tot + "평균: " + avg;
	} 	
}

// 기능 추가  
abstract  class ScoreDecorator implements  ReportComponet  {
	protected    ReportComponet   component;

	public ScoreDecorator(ReportComponet component) {
		super();
		this.component = component;
	} 	
}

//생성자 만들고 등급 추가하자.  
class GradeDecorator  extends  ScoreDecorator{
	
	public GradeDecorator(ReportComponet component) {
        super(component);
    }

	@Override
	public String getReport() {		
		return component.getReport() +   "  등급 :" +  "A";
	}
}









