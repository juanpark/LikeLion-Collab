package com.test01;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest01{
	public static void main(String[] args) {
		ApplicationContext  factory  = new ClassPathXmlApplicationContext("applicationContext01.xml");
	    GoodsDao  dao  = factory.getBean("test", GoodsDao.class);
	    
	    System.out.println("==============전체 상품 목록 ============= ");
	    List<GoodsVo>  all  = dao.listGoods();
	    for(GoodsVo res  :  all ) {
	    	 System.out.println(res);
	    }
		/*
	    System.out.println("====vo02 추가 후 전체 출력 ");
		GoodsVo vo02  =factory.getBean("vo02", GoodsVo.class);
		dao.insertGoods(vo02);
		
		dao.listGoods().forEach(System.out::println);
		*/
	    /*
	    System.out.println("===v03값으로 수정 후 전체 출력 ");
	    GoodsVo vo03 = factory.getBean("vo03", GoodsVo.class);
	    dao.udpateGoods(vo03);
	    dao.listGoods().forEach(System.out::println);*/
	    
	    System.out.println("====네임으로 삭제  후 전체 출력 ");
	    dao.deleteGoods("NewItem002");
	    dao.listGoods().forEach(System.out::println);
	    
	}	
	
}
