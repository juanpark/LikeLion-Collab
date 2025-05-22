package com.test03;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest03 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext03.xml");

        GoodsService service = context.getBean(GoodsService.class);

        // 전체 목록 조회
        System.out.println("====== 전체 상품 목록 ======");
        List<GoodsVo> all = service.getAll();
        printAllGoods.accept(all);

        // 상품 추가
        GoodsVo newItem = new GoodsVo("A999", "샘플상품", 9999, "샘플회사");
        service.add(newItem);
        System.out.println("====== 상품 추가 후 목록 ======");
        all = service.getAll();
        printAllGoods.accept(all);

        // 상품 삭제
        String nameToDelete = context.getBean("myname", String.class);  // xml에 myname 등록된 경우
        service.delete(nameToDelete);
        System.out.println("====== '" + nameToDelete + "' 삭제 후 목록 ======");
        all = service.getAll();
        printAllGoods.accept(all);
    }

    // 출력용 Consumer
    static Consumer<List<GoodsVo>> printAllGoods = list -> {
        if (list.isEmpty()) {
            System.out.println(">> 상품이 없습니다.");
        } else {
            for (GoodsVo vo : list) {
                System.out.println(vo);
            }
        }
    };
}
