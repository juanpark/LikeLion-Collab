beans {
    memberRepository(com.test03.MemoryMemberRepository)
    discountPolicy(com.test03.FixDiscountPolicy)
    orderService(com.test03.OrderServiceImpl, memberRepository, discountPolicy)
}
