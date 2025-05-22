package com.test02;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test02.dao.GoodsVo;
import com.test02.dao.GoodsDao;

public class MTest02 {
    public static void main(String[] args) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext02.xml");
        GoodsDao dao = factory.getBean("test", GoodsDao.class);
     
        java.util.function.Consumer<List<GoodsVo>> printAllGoods = goodsList -> {
            goodsList.forEach(System.out::println);
        };

        System.out.println("====== 전체 목록 ======");
        List<GoodsVo> all = dao.listGoods();
        printAllGoods.accept(all);

        System.out.println("====== vo 추가 후 전체 목록 ======");
        /*GoodsVo vo = factory.getBean("vo", GoodsVo.class);
        dao.insertGoods(vo);
        all = dao.listGoods();
        printAllGoods.accept(all);*/

        System.out.println("====== myname 삭제 후 전체 목록 ======");
        String name = factory.getBean("myname", String.class);
        dao.deleteGoods(name);
        all = dao.listGoods();
        printAllGoods.accept(all);

        ((ClassPathXmlApplicationContext) factory).close(); // 리소스 정리
    }
}