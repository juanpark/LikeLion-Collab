package com.test01;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public String order(int id, int price) { //business logic design: 회원이름 조회, 할인금액 계산, 최종결제 등 
        String name = memberRepository.findMemberById(id);
        int discount = discountPolicy.getDiscountAmount(price);
        int finalPrice = price - discount;
        return "회원: " + name + "\n주문 금액: " + price + "원\n할인 금액: " + discount + "원\n최종 결제 금액: " + finalPrice + "원";
    }
}
