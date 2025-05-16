beans {
    apple(com.sec03.Apple)    
    fruitService(com.sec03.FruitService) {
        fruit = ref("apple")
    }
}