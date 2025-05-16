package com.sec06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class ScoreMain {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application06.xml");
		Score score = context.getBean(Score.class);
		score.printScore();
		
		score = context.getBean("score",Score.class);
		score.printScore();
	}
}
