package com.test01;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest01 {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext01.xml");
    GoodsDao goodsDao = context.getBean("test", GoodsDao.class);

    System.out.println("================전체 상품 목록================");
    List<GoodsVo> all = goodsDao.listGoods();
    for (GoodsVo goodsVo : all) {
      System.out.println(goodsVo);
    }

    System.out.println("================상품 추가 후 전체 출력================");
    GoodsVo vo02 = context.getBean("vo02", GoodsVo.class);
    goodsDao.insertGoods(vo02);

    goodsDao.listGoods().forEach(System.out::println);

    System.out.println("================상품 수정 후 전체 출력================");
  }

}
